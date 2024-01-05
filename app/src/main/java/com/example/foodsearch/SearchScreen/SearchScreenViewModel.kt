package com.example.foodsearch.SearchScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.DataSource.RestaurantResponse
import com.example.foodsearch.SearchResultScreen.SearchResultViewModel
import com.example.foodsearch.api.RestaurantRepository
import com.example.foodsearch.api.RestaurantRepositoryImpl
import kotlinx.coroutines.launch

// SearchScreenViewModel.kt

class SearchScreenViewModel(
    private val repository: RestaurantRepository,
    private val searchResultViewModel: SearchResultViewModel
) : ViewModel() {

    private val _restaurantList = mutableStateOf<List<RestaurantInfo>>(emptyList())
    val restaurantList: State<List<RestaurantInfo>> = _restaurantList

    suspend fun searchRestaurants(
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

                result?.let { results ->
                    val shopList = results.results.shops ?: emptyList()
                    val filteredList = shopList.mapNotNull { shop ->
                        createRestaurantInfo(shop)
                    }

                    _restaurantList.value = filteredList

                    // SearchResultViewModelのインスタンスメソッドを呼び出す
                    searchResultViewModel.setRestaurantResponse(results)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun createRestaurantInfo(shop: RestaurantResponse.Results.Shop): RestaurantInfo? {
        return RestaurantInfo(
            id = shop.id,
            name = shop.name,
            nameKana = shop.nameKana,
            logoImage = shop.logoImage,
            lMobileImage = shop.photo?.mobile?.l,
            catchPhrase = shop.catchPhrase,
            open = shop.open,
            close = shop.close,
            averageBudget = shop.budget?.average,
            access = shop.access
        )
    }
}
