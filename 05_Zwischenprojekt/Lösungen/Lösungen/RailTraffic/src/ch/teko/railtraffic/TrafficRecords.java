package ch.teko.railtraffic;

import com.google.gson.annotations.SerializedName;

public class TrafficRecords {

	// Für Test public
	@SerializedName("nhits")
	private int nhits;
	@SerializedName("records")
	private TrafficDataset[] records;
	@SerializedName("parameters")
	private TrafficRecordsParameter parameter;

	// Getter
	public int getNhits() {
		return this.nhits;
	}
	public TrafficDataset[] getRecords() {
		return this.records;
	}
	
}


