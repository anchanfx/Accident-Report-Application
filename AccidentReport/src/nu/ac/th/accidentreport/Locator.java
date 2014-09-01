package nu.ac.th.accidentreport;

public abstract class Locator {	
	private LocatorListener mLocatorListener;
	protected Position mPosition;
	
	protected Locator(LocatorListener locatorListener, Position position) {
		mLocatorListener = locatorListener;
		mPosition = position;
	}
	
	protected void updateLocation()
	{
		mLocatorListener.onLocationUpdated(mPosition);
	}
	
	public abstract void startLocatePosition();
	public abstract void stopLocatePosition();
}
