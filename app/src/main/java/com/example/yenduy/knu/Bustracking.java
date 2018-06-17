package com.example.yenduy.knu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;


import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import static com.google.android.gms.maps.CameraUpdateFactory.newLatLng;

public class Bustracking extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busstop);



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setBuildingsEnabled(true);
        LatLng coordinates = new LatLng(37.449868, 129.165206);
        LatLng coordinates1= new LatLng(37.449868, 129.165206);


        //bus station
        mMap.addMarker(
                new MarkerOptions()
                        .position(coordinates)
                        .title("1. 삼척캠퍼스 출발")
                        .snippet("강원도 삼척시 중앙로 346")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        //station #2
        mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(37.445591, 129.164036))
                        .title("2. 상공회의소 건너편")
                        .snippet("강원 삼척시 진주로 54 ")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        //station  #3
        mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(37.4430076, 129.1637894))
                        .title("3. 신한은행")
                        .snippet("강원 삼척시 진주로 25 ")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        //station  #4
        mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(37.4402737, 129.168342))
                        .title("4. 고속터미날")
                        .snippet("강원 삼척시 중앙로 192 ")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        //station  #5
        mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(37.443897, 129.171316))
                        .title("5. 축협 2매장")
                        .snippet("강원 삼척시 척주로 66 축협 하나로마 트제 2매장")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        //station  #6
        mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(37.445702, 129.176232))
                        .title("6. 정라초등학교 앞")
                        .snippet("강원 삼척시 정상로3길 5 ")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        //station  #7
        mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(37.447396, 129.175705))
                        .title("7. 청솔1차아파트")
                        .snippet("강원도 삼척시 정상동 457-1")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        //station  #8
        mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(37.44852, 129.175289))
                        .title("8. 교동 하나로마트")
                        .snippet("강원 삼척시 정상로 78")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        //station  #9
        mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(37.450201, 129.169094))
                        .title("9. 교동현대아파트")
                        .snippet("강원도 삼척시 봉황로 147")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.bus_station))
        );

        mMap.addPolyline(new PolylineOptions().add(
                coordinates,
                new LatLng(37.445591, 129.164036),
                new LatLng(37.4430076, 129.1637894),
                new LatLng(37.4402737, 129.168342),
                new LatLng(37.443897, 129.171316),
                new LatLng(37.445702, 129.176232),
                new LatLng(37.447396, 129.175705),
                new LatLng(37.44852, 129.175289),
                new LatLng(37.450201, 129.169094),
                new LatLng(37.449868, 129.165206),
                coordinates1
        )
                .width(10)
                .color(Color.RED)

        );
        //----------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------------//
        CameraUpdate center= CameraUpdateFactory.newLatLng(coordinates);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

        mMap.moveCamera(center);
        mMap.animateCamera(zoom);



        //mMap.setMinZoomPreference(3.0f);
        //mMap.setMaxZoomPreference(5.5f);


        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney).zoomBy(10f)  );
        //mMap.moveCamera(CameraUpdateFactory.);

    }




    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, 100, 100);
        Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }



}