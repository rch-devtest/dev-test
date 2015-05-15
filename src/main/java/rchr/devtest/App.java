package rchr.devtest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


public class App {
	private final static Logger LOGGER = Logger.getLogger(App.class.getName()); 
	private final static String ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en/";
	private final static String CSV = ".csv";

	public static void main(String[] args) {

		if (args.length == 0) {
			LOGGER.log(Level.SEVERE, "No city name given. Specify one as parameter!");
		} else if (args.length > 1) {
			LOGGER.log(Level.SEVERE, "Too many parameters given. I can handle only one!");
		}

		String cityName = args[0];
		String query = ENDPOINT + cityName;

		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			MyJsonNode[] jsonNodes = objectMapper.readValue(new URL(query), MyJsonNode[].class);
			
			CsvNode[] csvNodes = JsonNode2CsvNode.convertToCsvNode(jsonNodes);
			
			CsvSchema schema = CsvSchema.builder()
			        .addColumn("_id")
			        .addColumn("name")
			        .addColumn("type")
			        .addColumn("latitude")
			        .addColumn("longitude")
			        .build();
			
			CsvMapper mapper = new CsvMapper();
			schema = schema.withColumnSeparator(',');
			ObjectWriter myObjectWriter = mapper.writer(schema);
			String fileName = cityName + CSV;
	        File tempFile = new File(fileName);
	        FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
	        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
	        OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
	        myObjectWriter.writeValue(writerOutputStream, csvNodes);
			
		}  catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error while reading or writing data. See following exception log:", e);
		} 
	}
}
