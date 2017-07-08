package yourname.example.com.project_ice.WeatherReport;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

import yourname.example.com.project_ice.MainActivity;
// This class is for the call and the parsing of the JSON object provided by the DarkSky API
/**
 * Created by marcos on 7/8/2017.
 * Currently trying to mimick the behavior of http://www.studytrails.com/java/json/java-org-json/
 */
public class WeatherReport extends MainActivity {
    public WeatherReport(int CoordX, int CoordY, String Method)
    {
        if (Method.equals("TimeMachine"))
        {
            System.out.println("The called method was Time Machine");
            String url = "https://api.darksky.net/forecast/f060c1a85d245405e10edd9d1a2b5ced/" + CoordX + "," +CoordY;
            JSONObject json = new JSONObject(genreJson);
            try (String result = json.get(url);){

            }catch (JSONException e){
                System.out.println("The JSON call failed");
            }


        } else if (Method.equals("Forecast"))
        {
            System.out.println("The called method was Forecast");
        } else
        {
            System.out.println("The called method is not supported");
        }
    }
}
