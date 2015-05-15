package rchr.devtest;

import rchr.devtest.MyJsonNode.GeoPosition;

public class JsonNode2CsvNode {

	public static CsvNode[] convertToCsvNode(MyJsonNode[] jsonNodes) {
		CsvNode[] csvNodes = new CsvNode[jsonNodes.length];
		for (int i = 0; i < jsonNodes.length; i++) {
			MyJsonNode node = jsonNodes[i];
			csvNodes[i] = toCsvNode(node);
		}
		return csvNodes;
	}

	private static CsvNode toCsvNode(MyJsonNode node) {
		String id = node.get_id();
		String name = node.getName();
		String type = node.getType();
		GeoPosition geoPosition = node.getGeo_position();
		String latitude = geoPosition.getLatitude();
		String longitude = geoPosition.getLongitude();
		return new CsvNode(id, name, type, latitude, longitude);

	}

}
