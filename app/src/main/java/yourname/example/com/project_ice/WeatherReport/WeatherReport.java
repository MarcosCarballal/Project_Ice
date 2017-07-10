package yourname.example.com.project_ice.WeatherReport;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


import yourname.example.com.project_ice.GetHTML;
import yourname.example.com.project_ice.MainActivity;

import static yourname.example.com.project_ice.GetHTML.getHTML;
// This class is for the call and the parsing of the JSON object provided by the DarkSky API
/**
 * Created by marcos on 7/8/2017.
 * Currently trying to mimic the behavior of http://www.studytrails.com/java/json/java-org-json/
 */
public class WeatherReport extends MainActivity {
    public WeatherReport(double CoordX, double CoordY, String Method, boolean debugging) { // Constructor
        if (Method.equals("TimeMachine"))
        {
            System.out.println("The called method was Time Machine");
            String url = "https://api.darksky.net/forecast/f060c1a85d245405e10edd9d1a2b5ced/"
                    + CoordX + "," +CoordY; // Was told not to embed private key into Java code but
                                            // can't quite find how to implement it otherwise.
            String result;
            try {
                result = getHTML(url); // THIS STILL DOESN'T WORK
                if (debugging) System.out.println(result);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("The HTML call failed");
            }


           /* JSONArray result = null;
            try {
                result = json.getJSONArray(url);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (debugging) {System.out.println(result);}
            */
        } else if (Method.equals("Forecast"))
        {
            System.out.println("The called method was Forecast");
        } else
        {
            System.out.println("The called method is not supported");
        }
    }
}
