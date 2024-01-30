import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle

class LocationSensor(private val context: Context) {

    private val locationManager: LocationManager by lazy {
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    private var lastKnownLocation: Location? = null

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            // 位置情報が変更されたときの処理
            lastKnownLocation = location
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            // ステータスが変更されたときの処理
        }

        override fun onProviderEnabled(provider: String) {
            // プロバイダが有効になったときの処理
        }

        override fun onProviderDisabled(provider: String) {
            // プロバイダが無効になったときの処理
        }
    }

    fun startLocationUpdates() {
        try {
            // 位置情報の更新を開始する
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000, // 1000ミリ秒ごとに更新
                10f,   // 10メートル移動するごとに更新
                locationListener
            )
            lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    fun stopLocationUpdates() {
        // 位置情報の更新を停止する
        locationManager.removeUpdates(locationListener)
    }

    fun getLocation(): Location? {
        // 最後に知られている位置情報を返す
        return lastKnownLocation
    }
}