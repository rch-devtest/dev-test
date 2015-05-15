package rchr.devtest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties({ "key", "fullName", "iata_airport_code", "country",
		"locationId", "inEurope", "countryCode", "coreCountry", "distance" })
@JsonPropertyOrder({"_id", "name", "type", "latitude", "longitude"})
public class MyJsonNode {

	@JsonProperty("_id")
	private String _id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("geo_position")
	public GeoPosition geo_position;
	
	public MyJsonNode() {
		
	}
	
	public static class GeoPosition {
		private String latitude, longitude;

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		
	}

	public String get_id() {
		return _id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public GeoPosition getGeo_position() {
		return geo_position;
	}
	
	
}
