package yourname.example.com.project_ice;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import yourname.example.com.project_ice.WeatherReport.WeatherReport;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.os.Binder.getCallingPid;
import static android.os.Binder.getCallingUid;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        int permissionCheck = (checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION,
                getCallingPid(),getCallingUid())); // Determines whether the current process has
                // permission to get the currrent
        double CoordX = 37.8267; // I'm aware this is disgusting and sloppy but it wouldn't let me
        double CoordY = -122.4233; // declare these as null
        if(permissionCheck == PERMISSION_GRANTED)
        {
            Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
            CoordX = lastKnownLocation.getLatitude();
            CoordY = lastKnownLocation.getLongitude();
        }
        else
        {
            System.out.println("The Attempt to get device's location failed.");
        }
        // Get location
        /*\
        On(location_flag_press)
            setContentView(R.layout.location_setting) // Find new
        */
        boolean debugging = true; // This will control debug statements across the app. Need to
                                    // if possible to make it a global variable.
       // final ImageButton button = findViewById(R.id.locationbutton);
        WeatherReport myReport = new WeatherReport(CoordX,CoordY, "TimeMachine", debugging);
    }
}
