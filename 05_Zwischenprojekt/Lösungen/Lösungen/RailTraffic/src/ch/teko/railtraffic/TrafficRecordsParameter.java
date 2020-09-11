package ch.teko.railtraffic;

import com.google.gson.annotations.SerializedName;

	public class TrafficRecordsParameter {

		@SerializedName("timezone")
		public String timezone;
		@SerializedName("rows")
		public int rows;

		// Getter
		public String getTimezone() {
			return timezone;
		}

		public int getRows() {
			return rows;
		}

	}