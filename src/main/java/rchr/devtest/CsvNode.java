package rchr.devtest;

public class CsvNode {

	private String _id;
	private String name;
	private String type;
	private String latitude;
	private String longitude;
	
	public CsvNode(String _id, String name, String type, String latitude,
			String longitude) {
		super();
		this._id = _id;
		this.name = name;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}
	
}
