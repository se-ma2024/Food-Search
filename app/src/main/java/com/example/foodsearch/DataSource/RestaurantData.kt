package com.example.foodsearch.DataSource

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@JsonClass(generateAdapter = true)
data class RestaurantResponse(
    @Json(name = "results")
    val results: Results
) {
    @JsonClass(generateAdapter = true)
    data class Results(
        @Json(name = "api_version")
        val apiVersion: String,
        @Json(name = "results_available")
        val resultsAvailable: Int,
        @Json(name = "results_returned")
        val resultsReturned: String,
        @Json(name = "results_start")
        val resultsStart: Int,
        @Json(name = "shop")
        val shops: List<Shop>
    ) {
        @JsonClass(generateAdapter = true)
        data class Shop(
            @Json(name = "access")
            val access: String?,
            @Json(name = "address")
            val address: String?,
            @Json(name = "band")
            val band: String?,
            @Json(name = "barrier_free")
            val barrierFree: String?,
            @Json(name = "budget")
            val budget: Budget?,
            @Json(name = "budget_memo")
            val budgetMemo: String?,
            @Json(name = "capacity")
            val capacity: Int?,
            @Json(name = "card")
            val card: String?,
            @Json(name = "catch")
            val catchPhrase: String?,
            @Json(name = "charter")
            val charter: String?,
            @Json(name = "child")
            val child: String?,
            @Json(name = "close")
            val close: String?,
            @Json(name = "coupon_urls")
            val couponUrls: CouponUrls?,
            @Json(name = "course")
            val course: String?,
            @Json(name = "english")
            val english: String?,
            @Json(name = "free_drink")
            val freeDrink: String?,
            @Json(name = "free_food")
            val freeFood: String?,
            @Json(name = "genre")
            val genre: Genre?,
            @Json(name = "horigotatsu")
            val horigotatsu: String?,
            @Json(name = "id")
            val id: String?,
            @Json(name = "karaoke")
            val karaoke: String?,
            @Json(name = "ktai_coupon")
            val ktaiCoupon: Int?,
            @Json(name = "large_area")
            val largeArea: Area?,
            @Json(name = "large_service_area")
            val largeServiceArea: ServiceArea?,
            @Json(name = "lat")
            val lat: Double?,
            @Json(name = "lng")
            val lng: Double?,
            @Json(name = "logo_image")
            val logoImage: String?,
            @Json(name = "lunch")
            val lunch: String?,
            @Json(name = "middle_area")
            val middleArea: Area?,
            @Json(name = "midnight")
            val midnight: String?,
            @Json(name = "mobile_access")
            val mobileAccess: String?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "name_kana")
            val nameKana: String?,
            @Json(name = "non_smoking")
            val nonSmoking: String?,
            @Json(name = "open")
            val open: String?,
            @Json(name = "other_memo")
            val otherMemo: String?,
            @Json(name = "parking")
            val parking: String?,
            @Json(name = "party_capacity")
            val partyCapacity: Any?,
            @Json(name = "pet")
            val pet: String?,
            @Json(name = "photo")
            val photo: Photo?,
            @Json(name = "private_room")
            val privateRoom: String?,
            @Json(name = "service_area")
            val serviceArea: ServiceArea?,
            @Json(name = "shop_detail_memo")
            val shopDetailMemo: String?,
            @Json(name = "show")
            val show: String?,
            @Json(name = "small_area")
            val smallArea: Area?,
            @Json(name = "station_name")
            val stationName: String?,
            @Json(name = "tatami")
            val tatami: String?,
            @Json(name = "tv")
            val tv: String?,
            @Json(name = "urls")
            val urls: Urls?,
            @Json(name = "wedding")
            val wedding: String?,
            @Json(name = "wifi")
            val wifi: String?
        ) {
            @JsonClass(generateAdapter = true)
            data class Budget(
                @Json(name = "average")
                val average: String?,
                @Json(name = "code")
                val code: String?,
                @Json(name = "name")
                val name: String?
            )

            @JsonClass(generateAdapter = true)
            data class CouponUrls(
                @Json(name = "pc")
                val pc: String?,
                @Json(name = "sp")
                val sp: String?
            )

            @JsonClass(generateAdapter = true)
            data class Genre(
                @Json(name = "catch")
                val catch: String?,
                @Json(name = "code")
                val code: String?,
                @Json(name = "name")
                val name: String?
            )

            @JsonClass(generateAdapter = true)
            data class Area(
                @Json(name = "code")
                val code: String?,
                @Json(name = "name")
                val name: String?
            )

            @JsonClass(generateAdapter = true)
            data class ServiceArea(
                @Json(name = "code")
                val code: String?,
                @Json(name = "name")
                val name: String?
            )

            @JsonClass(generateAdapter = true)
            data class Photo(
                @Json(name = "mobile")
                val mobile: MobileImage?,
                @Json(name = "pc")
                val pc: PcImage?
            )

            @JsonClass(generateAdapter = true)
            data class MobileImage(
                @Json(name = "l")
                val l: String?,
                @Json(name = "s")
                val s: String?
            )

            @JsonClass(generateAdapter = true)
            data class PcImage(
                @Json(name = "l")
                val l: String?,
                @Json(name = "m")
                val m: String?,
                @Json(name = "s")
                val s: String?
            )

            @JsonClass(generateAdapter = true)
            data class Urls(
                @Json(name = "pc")
                val pc: String?
            )
        }
    }
}

@Serializable
data class RestaurantInfo(
    val id: String?,
    val name: String?,
    val nameKana: String?,
    val logoImage: String?,
    val lMobileImage: String?,
    val catchPhrase: String?,
    val open: String?,
    val close: String?,
    val averageBudget: String?,
    val access: String?
)


data class Restaurants(
    val id: String?,
    val name: String?,
    val logoImage: String?,
    val nameKana: String?,
    val address: String?,
    val stationName: String?,
    val ktaiCoupon: Int?,
    val largeServiceArea: Area?,
    val serviceArea: Area?,
    val largeArea: Area?,
    val middleArea: Area?,
    val smallArea: Area?,
    val location: Location?,
    val genre: Genre?,
    val subGenre: SubGenre?,
    val budget: Budget?,
    val average: String?,
    val budgetMemo: String?,
    val catchPhrase: String?,
    val capacity: Int?,
    val access: String?,
    val mobileAccess: String?,
    val urls: Urls?,
    val photo: Photo?,
    val open: String?,
    val close: String?,
    val partyCapacity: Int?,
    val wifi: String?,
    val wedding: String?,
    val course: String?,
    val freeDrink: String?,
    val freeFood: String?,
    val privateRoom: String?,
    val horigotatsu: String?,
    val tatami: String?,
    val card: String?,
    val nonSmoking: String?,
    val charter: String?,
    val ktai: String?,
    val parking: String?,
    val barrierFree: String?,
    val otherMemo: String?,
    val sommelier: String?,
    val openAir: String?,
    val show: String?,
    val equipment: String?,
    val karaoke: String?,
    val band: String?,
    val tv: String?,
    val english: String?,
    val pet: String?,
    val child: String?,
    val lunch: String?,
    val midnight: String?,
    val shopDetailMemo: String?,
    val couponUrls: CouponUrls?
)
data class Area(
    val code: String?,
    val name: String?
)
data class Location(
    val lat: Double?,
    val lng: Double?
)
data class Genre(
    val code: String?,
    val name: String?,
    val catchPhrase: String?,
    val subGenre: SubGenre?
)
data class SubGenre(
    val code: String?,
    val name: String?
)
data class Budget(
    val code: String?,
    val name: String?,
    val average: String?,
    val budgetMemo: String?
)
data class Urls(
    val pc: String?,
    val mobile: String?
)
data class Photo(
    val pc: PhotoUrls?,
    val mobile: PhotoUrls?
)
data class PhotoUrls(
    val l: String?,
    val m: String?,
    val s: String?
)
data class CouponUrls(
    val pc: String?,
    val sp: String?
)
