package nu.ac.th.accidentreport;

public abstract class Locator {	
	private LocatorListener mLocatorListener;
	protected Position mPosition;
	
	protected Locator(LocatorListener locatorListener) {
		mLocatorListener = locatorListener;
		mPosition = new Position(0.0, 0.0);
	}
	
	protected void updateLocation()
	{
		mLocatorListener.onLocationUpdated(mPosition);
	}
	
	public abstract void startLocatePosition();
	public abstract void stopLocatePosition();
}
