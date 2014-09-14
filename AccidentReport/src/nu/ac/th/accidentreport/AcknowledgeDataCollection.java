package nu.ac.th.accidentreport;

public class AcknowledgeDataCollection {

	private AcknowledgeData mAcknowledgeData;
	
	
	public AcknowledgeDataCollection() {
		this(new AcknowledgeData());
	}

	public AcknowledgeDataCollection(AcknowledgeData acknowledgeInfo) {
		super();
		mAcknowledgeData = acknowledgeInfo;
	}
	
	public AcknowledgeData getAcknowledgeData() {
		return mAcknowledgeData;
	}
}
