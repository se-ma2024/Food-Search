package com.example.foodsearch.SearchScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.SearchResultScreen.SearchResultViewModel
import com.example.foodsearch.api.RestaurantRepository
import com.example.foodsearch.api.RestaurantRepositoryImpl
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {
    private val repository = RestaurantRepositoryImpl()
    private val viewModel = SearchResultViewModel()

    // レストラン情報を保存する変数
    var restaurantList by mutableStateOf<List<RestaurantInfo>>(emptyList())
        private set

    suspend fun searchRestaurants(
        navController: NavController,
        apiKey: String,
        keyword: String,
        latitude: Double,
        longitude: Double,
        start: Int,
        count: Int,
        format: String,
        range: Int
    ) {
        viewModelScope.launch {
            try {
                val result = repository.getRestaurants(
                    key = apiKey,
                    keyword = keyword,
                    latitude = latitude,
                    longitude = longitude,
                    start = start,
                    count = count,
                    format = format,
                    range = range
                )

                result?.let {
                    val filteredList = it.results?.shops?.map { shop ->
                        RestaurantInfo(
                            id = shop.id,
                            name = shop.name ?: "",
                            nameKana = shop.nameKana ?: "",
                            logoImage = shop.logoImage ?: "",
                            catchPhrase = shop.catchPhrase ?: "",
                            open = shop.open ?: "",
                            close = shop.close ?: "",
                            averageBudget = shop.budget?.average ?: "",
                            access = shop.access ?: ""
                        )
                    } ?: emptyList()

                    restaurantList = filteredList
                    viewModel.setRestaurantResponse(it)
                    navController.navigate("SearchResultScreen/$keyword")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}