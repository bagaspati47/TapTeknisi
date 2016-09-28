package com.projekhalamanlangitblogspot.dokterpc2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ZoomControls;

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
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng gigantic = new LatLng(-6.2586043,107.147593);
        mMap.addMarker(new MarkerOptions().position(gigantic).title("Gigantic Computindo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gigantic));


        // Add a marker in Sydney and move the camera
        LatLng enter = new LatLng(-6.1368589,106.8219525);
        mMap.addMarker(new MarkerOptions().position(enter).title("Enter Komputer"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(enter));

        // Add a marker in Sydney and move the camera
        LatLng quantum = new LatLng(-6.1355571,106.8220828);
        mMap.addMarker(new MarkerOptions().position(quantum).title("Quantum Komputer"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(quantum));
    }

}
