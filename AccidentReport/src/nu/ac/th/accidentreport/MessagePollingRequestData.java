package nu.ac.th.accidentreport;

import java.io.Serializable;


public class MessagePollingRequestData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -931018523111937200L;
	String imei;

	public MessagePollingRequestData(String imei) {
		super();
		this.imei = imei;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
}
