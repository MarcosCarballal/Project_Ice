package yourname.example.com.project_ice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yourname.example.com.project_ice.WeatherReport.WeatherReport;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean debugging = true;
        WeatherReport myReport = new WeatherReport(0,0, "TimeMachine", debugging);
    }
}
