package yourname.example.com.project_ice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // On button press. To be implemented
        WeatherReport myReport = new WeatherReport(0.0,0.0, "TimeMachine");
    }
}
