package com.example.foodsearch.SearchResultScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.DataSource.RestaurantResponse

class SearchResultViewModel : ViewModel() {
    private val _filteredRestaurantList = mutableStateOf<List<RestaurantInfo>>(emptyList())
    val filteredRestaurantList: State<List<RestaurantInfo>> = _filteredRestaurantList
    private val _selectedRestaurant = MutableLiveData<RestaurantInfo>()
    val selectedRestaurant: LiveData<RestaurantInfo> get() = _selectedRestaurant
    fun setFilteredRestaurantList(list: List<RestaurantInfo>) {
        _filteredRestaurantList.value = list
    }

    private var _clickedRestaurant: RestaurantInfo? = null
    val clickedRestaurant: RestaurantInfo?
        get() = _clickedRestaurant

    fun setClickedRestaurant(restaurantInfo: RestaurantInfo) {
        _clickedRestaurant = restaurantInfo
    }

    private val _restaurantList = mutableStateOf<List<RestaurantInfo>>(emptyList())
    fun setRestaurantResponse(restaurantResponse: RestaurantResponse?) {
        val filteredRestaurantList = restaurantResponse?.results?.shops?.map { shop ->
            // shop を RestaurantInfo に変換
            RestaurantInfo(
                id = shop.id,
                name = shop.name ?: "",
                nameKana = shop.nameKana ?: "",
                logoImage = shop.logoImage ?: "",
                lMobileImage = shop.photo?.mobile?.l ?: "",
                catchPhrase = shop.catchPhrase ?: "",
                open = shop.open ?: "",
                close = shop.close ?: "",
                averageBudget = shop.budget?.average ?: "",
                access = shop.access ?: ""
            )
        } ?: emptyList()
        _restaurantList.value = emptyList()
        _restaurantList.value = filteredRestaurantList
    }
}