package ch.teko.railtraffic;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class TrafficDataset {

	@SerializedName("datasetid")
	private String datasetid;
	@SerializedName("recordid")
	private String recordid;
	@SerializedName("record_timestamp")
	private Date record_timestamp;
	@SerializedName("fields")
	private TrafficDatasetFields dataset_fields;
	
	public void perpareDatasets() {
		dataset_fields.setRecord_timestamp(record_timestamp);
		dataset_fields.setRecord_id(recordid);
		dataset_fields.prepareProperties();
	}
	
	public TrafficDatasetFields getDatasetFields () {
		return this.dataset_fields;
	}
}
