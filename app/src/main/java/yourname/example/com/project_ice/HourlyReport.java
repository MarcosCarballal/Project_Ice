
package yourname.example.com.project_ice;

/**
 * Created by marco on 7/17/2017.
 */

class HourlyReport extends WeatherReport { //Is this a subclass of WeatherReport??
    public int time;
    public String summary;
    public String icon;
    public int precipIntensity;
    public int precipProbability;
    public HourlyReport() {
        super(); // Constructor

    }
}

