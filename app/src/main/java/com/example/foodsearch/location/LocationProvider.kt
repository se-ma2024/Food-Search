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
            lastKnownLocation = location
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String) {
        }

        override fun onProviderDisabled(provider: String) {
        }
    }

    fun startLocationUpdates() {
        try {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000,
                10f,
                locationListener
            )
            lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    fun stopLocationUpdates() {
        locationManager.removeUpdates(locationListener)
    }

    fun getLocation(): Location? {
        return lastKnownLocation
    }
}