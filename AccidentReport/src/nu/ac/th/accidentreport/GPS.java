package nu.ac.th.accidentreport;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GPS extends Locator implements LocationListener {
	private LocationManager mLocationManager;
	
	public GPS(LocatorListener locatorListener, Context context) {
		super(locatorListener);
		mLocationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
	}

	@Override
	public void startLocatePosition() {
		mLocationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 1500, 1, this);
	}

	
	@Override
	public void stopLocatePosition() {
		mLocationManager.removeUpdates(this);
	}

	
	@Override
	public void onLocationChanged(Location location) {
		mPosition.setLatitude(location.getLatitude());
		mPosition.setLongitude(location.getLongitude());
		updateLocation();
	}

	@Override
	public void onProviderDisabled(String provider) {
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		
	}
}
