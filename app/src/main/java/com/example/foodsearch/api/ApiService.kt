package com.example.foodsearch.api

import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.DataSource.RestaurantResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



//Retrofitインターフェースの作成
interface GourmetApiService {
    @GET("gourmet/v1/")
    suspend fun searchRestaurants(
        @Query("key") key: String,
        @Query("keyword") keyword: String?,
        @Query("lat") latitude: Double?,
        @Query("lng") longitude: Double?,
        @Query("start") start: Int?,
        @Query("count") count: Int?,
        @Query("format") format: String?,
        @Query("range") range: Int?
    ): Response<RestaurantResponse>
}

//Repository
interface RestaurantRepository {
    suspend fun getRestaurants(
        key: String,
        keyword: String,
        latitude: Double,
        longitude: Double,
        start: Int,
        count: Int,
        format: String,
        range: Int
    ): RestaurantResponse?
}

class RestaurantRepositoryImpl : RestaurantRepository {

    // JSONからKotlinのクラスに変換するためのライブラリの設定
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // REST APIを利用するためのライブラリの設定
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://webservice.recruit.co.jp/hotpepper/") // 今回利用するWeb APIのURL
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(createOkHttpClient())
        .build()

    // HotPepperApiClientに定義したメソッドを呼び出すための設定
    private val hotPepperService = retrofit.create(GourmetApiService::class.java)

    // Web APIからデータを取得するメソッド
    override suspend fun getRestaurants(
        key: String,
        keyword: String,
        latitude: Double,
        longitude: Double,
        start: Int,
        count: Int,
        format: String,
        range: Int
    ): RestaurantResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = hotPepperService.searchRestaurants(
                    key,
                    keyword,
                    latitude,
                    longitude,
                    start,
                    count,
                    format,
                    range
                )

                if (response.isSuccessful) {
                    val restaurantResponse = response.body()
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

// RestaurantResponseをそのまま返すか、必要な情報だけを抽出したものを返す
// 以下はRestaurantResponseをそのまま返す例です。
                    restaurantResponse?.copy(results = restaurantResponse.results.copy(shops = filteredRestaurantList as List<RestaurantResponse.Results.Shop>))

                } else {
                    // レスポンスがエラーだった場合の処理
                    null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}





////Retrofitの初期化
//object RetrofitClient {
//    private const val BASE_URL = "https://webservice.recruit.co.jp/hotpepper/" //webサービスのベースURL
//
//    val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(MoshiConverterFactory.create())
//        .build()
//}
//
//// API呼び出し
//class RestaurantRepository {
//    private val apiService: GourmetApiService = RetrofitClient.retrofit.create(GourmetApiService::class.java)
//
//    suspend fun searchRestaurants(apiKey: String, keyword: String?,latitude: Double?, longitude: Double?, start: Int?, count: Int?, format: String?, range: Int?): RestaurantResponse? {
//        return withContext(Dispatchers.IO) {
//            try {
//                val response = apiService.searchRestaurants(apiKey, keyword, latitude, longitude, start, count, format, range)
//                if (response.isSuccessful) {
//                    response.body()
//                } else {
//                    // Handle the error case
//                    null
//                }
//            } catch (e: Exception) {
//                // Handle the exception
//                e.printStackTrace()
//                null
//            }
//        }
//    }
//}
