package yourname.example.com.project_ice;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Region;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;


import static yourname.example.com.project_ice.GetHTML.getHTML;
// This class is for the call and the parsing of the JSON object provided by the DarkSky API
/**
 * Created by marcos on 7/8/2017.
 * Currently trying to mimic the behavior of http://www.studytrails.com/java/json/java-org-json/
 */
public class WeatherReport{
    private static final String TAG = "WeatherReportActivity";
    private int latitude;
    private int longitude;
    private String timezone;
    private Array hourlyReports;
    private int offset; //Offset for timezone changes? Documentation unclear
    public WeatherReport(){ // Constuctor without arguments
        latitude = 0;
        longitude = 0;
        timezone = "None";
        hourlyReports = null;
        offset = 0;
    }
    public WeatherReport(double CoordX, double CoordY, String Method) { // Constructor
        if (Method.equals("TimeMachine"))
        {
            System.out.println("The called method was Time Machine");
            // Find the start of day in Unix time to add onto the request
            long millis = System.currentTimeMillis();
            long unixTime = millis / 1000;
            String key = "";
            try {
                FileReader fr = new FileReader("app/src/main/assets/apikey.txt");
                Scanner s = new Scanner(fr);
                key = s.nextLine();

            } catch (FileNotFoundException e){
                System.exit(5);
            }

            Log.d(TAG, "The Unix time called was " + unixTime);
            String url = "https://api.darksky.net/forecast/" + key + "/"
                    + CoordX + "," +CoordY + "," + unixTime;
            String result;
            System.out.println("The url being called is " + url);
            try { // Contacts the DarkSky API
                result = getHTML(url); // Result should be a 24-hour JSON report of the past x
                // hours and the future 24 -x hours of the day predictions
                // Will have to parse the JSON object to only look at past
                // x hours. If it proves necessary to collect data from before
                // 12:00 on that date we will need multiple calls.
                Log.d(TAG,result);
                System.out.println("The result of the URL call is: " + result);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("The HTML call failed");
                WeatherReport blankReport = new WeatherReport();
                result = "";
            }
            if(result.equals("")){
                WeatherReport blankReport = new WeatherReport();
                latitude = longitude = offset = 0;
                timezone = "None";
                hourlyReports = null;
            }
            else{
                System.out.println("WeatherReport was successful");
                /* Parsing code goes here  :)
                * Should send strings to HourlyReport constructor and
                * place resulting objects in array hourlyReports*/
                try{
                    String testing = "{\"number\":3}"; // Testing JSON Parser
                    JSONObject obj = new JSONObject(result);
                    String num = obj.getString("number");
                    System.out.println(obj);
                }catch (JSONException e){
                    System.out.print("Resulting string could not be parsed into a JSONObject");
                    System.exit(0);
                }
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
            Log.d(TAG,"The called method was Forecast");
        } else
        {
            Log.d(TAG,"The called method is not supported");
        }
    }

    //region settersGetters
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Array getHourlyReports() {
        return hourlyReports;
    }

    public void setHourlyReports(Array hourlyReports) {
        this.hourlyReports = hourlyReports;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    //endregion settersGetters
}

