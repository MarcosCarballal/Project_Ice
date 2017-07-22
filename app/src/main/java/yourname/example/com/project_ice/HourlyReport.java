package yourname.example.com.project_ice;

/**
 * Created by marco on 7/17/2017.
 */

class HourlyReport extends WeatherReport { //Is this a subclass of WeatherReport??
    public int UnixTime;
    public String summary;
    public String icon;
    public float precipIntensity;
    public float precipProbability;
    public float temperature;
    public float dewPoint;
    public float humidity;
    public float WindSpeed;
    public float windGust;
    public float windBearing;
    public float cloudCover;
    public float ozone;
    public HourlyReport(String unparsedHourlyContent) {


    }
}
