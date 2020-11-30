import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import getData.getDataFromOracle;
import getData.SportyCars;

/**
 * Create and print a Json file.
 * @author Yuhang Zhao, student#=150467199
 *
 */
public class CreateJsonObjAndArray {
		 
	    public static void main(String[] args) throws JSONException {
	    	SportyCars[] carsArray = getDataFromOracle.requestDataThroughThin();
	    	
	    	
	    	JSONArray jsonArray = new JSONArray();
	    	
	    	for(int i = 0 ; i < carsArray.length ; i++) {
	    		JSONObject jsonObj= new JSONObject(); 
			    jsonObj.put("Year", carsArray[i].getYear());
			    jsonObj.put("Make", carsArray[i].getMake());
			    jsonObj.put("Model", carsArray[i].getModel());
			    jsonObj.put("Price", carsArray[i].getPrice());
			    jsonArray.put(jsonObj);
	    	}
	    	
	    	JSONObject json = new JSONObject();
	    	json.put("cars", jsonArray);
	    	System.out.println(json);
	    }
}