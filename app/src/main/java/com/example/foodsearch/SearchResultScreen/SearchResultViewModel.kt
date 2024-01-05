package com.example.foodsearch.SearchResultScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.DataSource.RestaurantResponse

// SearchResultViewModel.kt

class SearchResultViewModel : ViewModel() {
    private val _filteredRestaurantList = mutableStateOf<List<RestaurantInfo>>(emptyList())
    val filteredRestaurantList: State<List<RestaurantInfo>> = _filteredRestaurantList
    private val _selectedRestaurant = MutableLiveData<RestaurantInfo>()//クリックされたレストラン情報を管理
    val selectedRestaurant: LiveData<RestaurantInfo> get() = _selectedRestaurant
    fun setFilteredRestaurantList(list: List<RestaurantInfo>) {
        _filteredRestaurantList.value = list
    }

    // クリックされたレストラン情報を保持する変数
    private var _clickedRestaurant: RestaurantInfo? = null
    val clickedRestaurant: RestaurantInfo?
        get() = _clickedRestaurant
    // クリックされたレストラン情報をセットする関数
    fun setClickedRestaurant(restaurantInfo: RestaurantInfo) {
        _clickedRestaurant = restaurantInfo
    }
    private val _restaurantList = mutableStateOf<List<RestaurantInfo>>(emptyList())
    // restaurantResponse を受け取り、それを _restaurantList にセットするメソッド
    // SearchResultViewModel.kt
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

        // レストランリストを一旦クリアする
        _restaurantList.value = emptyList()
        // 渡された新しいリストの要素をすべて追加する
        _restaurantList.value = filteredRestaurantList
    }

}