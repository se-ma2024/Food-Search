package com.example.foodsearch.SearchResultScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.DataSource.RestaurantResponse
import com.example.foodsearch.DataSource.Restaurants
import com.example.foodsearch.R
import com.example.foodsearch.SearchScreen.SearchScreenViewModel
import com.example.foodsearch.api.RestaurantRepository
import com.example.foodsearch.api.RestaurantRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResultViewModel : ViewModel() {
    private val _restaurantList = mutableListOf<RestaurantInfo>()

    // restaurantListを外部に公開
    val restaurantList: List<RestaurantInfo> get() = _restaurantList

    // 新しいメソッド: restaurantResponseを受け取り、リストに変換して保存する
    fun setRestaurantResponse(restaurantResponse: RestaurantResponse?) {
        val filteredRestaurantList = restaurantResponse?.results?.shops?.map { shop ->
            // shopをRestaurantInfoに変換
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

        // レストランリストを一旦クリアする
        _restaurantList.clear()
        // 渡された新しいリストの要素をすべて追加する
        _restaurantList.addAll(filteredRestaurantList)
    }
}

//class SearchResultViewModel : ViewModel() {
//    var restaurantList by mutableStateOf<List<RestaurantInfo>>(emptyList())
//        private set
//
//    private val repository = RestaurantRepositoryImpl() // RestaurantRepositoryの実装クラス
//
//    suspend fun searchRestaurants(apiKey: String, range: Int) {
//        try {
//            // repository.getRestaurants を呼び出し
//            val result = repository.getRestaurants(
//                key = apiKey,
//                keyword = "your_keyword", // ここに実際の検索ワードを入れる
//                latitude = 34.705647748772236,
//                longitude = 135.49483743011916,
//                start = 1,
//                count = 100,
//                format = "json",
//                range = range
//            )
//
//            result?.let {
//                // レストラン情報をViewModelの変数に格納
//                restaurantList = it.results?.shops?.mapIndexed { index, shop ->
//                    RestaurantInfo(
//                        id = shop.id,
//                        name = shop.name ?: "",
//                        nameKana = shop.nameKana ?: "",
//                        logoImage = shop.logoImage ?: "",
//                        catchPhrase = shop.catchPhrase ?: "",
//                        open = shop.open ?: "",
//                        close = shop.close ?: "",
//                        averageBudget = shop.budget?.average ?: "",
//                        access = shop.access ?: ""
//                    )
//                } ?: emptyList()
//            }
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//}