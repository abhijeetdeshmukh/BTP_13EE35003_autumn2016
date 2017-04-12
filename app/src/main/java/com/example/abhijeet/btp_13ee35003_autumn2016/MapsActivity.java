package com.example.abhijeet.btp_13ee35003_autumn2016;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. I
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //  Add a marker in -- place and move the camera
        LatLng tikka = new LatLng(22.316875, 87.307263);
        mMap.addMarker(new MarkerOptions().position(tikka).title("Tikka").snippet("The most reasonable food outlet"));

        LatLng nehruMusium = new LatLng(22.319511, 87.315460);
        mMap.addMarker(new MarkerOptions().position(nehruMusium).title("Nehru Musium"));

        LatLng tSG = new LatLng(22.318779, 87.302536);
        mMap.addMarker(new MarkerOptions().position(tSG).title("Technology students Gymkhana"));

        LatLng ee = new LatLng(22.320133, 87.310914);
        mMap.addMarker(new MarkerOptions().position(ee).title("Dept.of Electrical Engineering "));

        LatLng msc = new LatLng(22.321505, 87.314567);
        mMap.addMarker(new MarkerOptions().position(msc).title("Materials Science Centre"));

        LatLng kcsc = new LatLng (22.319977, 87.313419);
        mMap.addMarker(new MarkerOptions().position(kcsc).title("Kalpana Chawla Space Technology Cell"));

        // Add a marker in "Central Library" and move the camera
        LatLng mainBuilding = new LatLng(22.319601, 87.309966);
        mMap.addMarker(new MarkerOptions().position(mainBuilding).title("Main Building"));
        mMap.moveCamera( CameraUpdateFactory.newLatLng( mainBuilding ));

        mMap.animateCamera( CameraUpdateFactory.zoomTo( 16.0f ) );
    }
}
