package yourname.example.com.project_ice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WeatherReportTest {
    @Test
    public void constructor_runs (){
        WeatherReport myWeather = new WeatherReport(0.0,0.0, "TimeMachine");
    }
}