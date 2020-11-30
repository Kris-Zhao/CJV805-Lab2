import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * ReadRemoteJsonObjWithArray class is to read and parse the remote cars.json file using the org.json JSON API. Print the 
 * parsed data in the console.
 * @author Yuhang Zhao, student#=150467199
 *
 */
public class ReadRemoteJsonObjWithArray {

	public static void main(String[] args) {

		// read JSON by calling RESTful web service


		try {
			
			JSONObject json = readJsonFromUrl("https://matrix.senecacollege.ca/~yzhao248/cars.json");
			
			System.out.println(json.toString());
			
			System.out.println();
			System.out.println("\nSporty cars:");
			System.out.println("-------------------------");
			
			JSONArray jsonArray = json.getJSONArray("cars");
			
			// Iterate through JSONArray and display each JSONObjects
			int count = jsonArray.length(); // get totalCount of all jsonObjects
			for(int i=0 ; i< count; i++){   // iterate through jsonArray 
				JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position 
				System.out.println("JSON Object : car" + (i+1));
				System.out.println(" Year: " + jsonObject.getString("Year"));
				System.out.println(" Make: " + jsonObject.getString("Make"));
				System.out.println(" Model: " + jsonObject.getString("Model"));
				System.out.println(" Price: " + jsonObject.getString("Price"));
				System.out.println();
			}
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		System.out.println("Requested URL:" + url);
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = read(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		}finally {
			is.close();
		}
	}
	
	private static String read(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
}