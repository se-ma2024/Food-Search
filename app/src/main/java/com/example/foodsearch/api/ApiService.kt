package com.example.foodsearch.api

import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.DataSource.RestaurantResponse
import com.example.foodsearch.SearchResultScreen.SearchResultViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

class RestaurantRepositoryImpl(private val searchResultViewModel: SearchResultViewModel) :
    RestaurantRepository {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://webservice.recruit.co.jp/hotpepper/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(createOkHttpClient())
        .build()

    private val hotPepperService = retrofit.create(GourmetApiService::class.java)

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

                    searchResultViewModel.setFilteredRestaurantList(filteredRestaurantList)

                    restaurantResponse?.copy(
                        results = restaurantResponse.results.copy(shops = filteredRestaurantList as List<RestaurantResponse.Results.Shop>)
                    )
                } else {
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