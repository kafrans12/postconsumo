package com.example.katherine.postconsumo;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Retrofit retrofit;
    LatLng coordenada,col;
    private List lista;
    public  static final String TAG = "Punto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (status == ConnectionResult.SUCCESS) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }
        else{
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }
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

        retrofit = new Retrofit.Builder().baseUrl("http://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SitiosService service = retrofit.create(SitiosService.class);
        Call<List<Punto>> sitioRespuestaCall = service.obtenerListadeSitios();

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN); //Sets the type of map tiles that should be displayed
        UiSettings uiSettings = mMap.getUiSettings(); //Settings for the user interface of a GoogleMap.
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setAllGesturesEnabled(true);

        // Add a marker in Colombia and move the camera


        col = new LatLng(4.0000000, -72.0000000);
        float zoomLevel = 5;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(col, zoomLevel));

        sitioRespuestaCall.enqueue(new Callback<List<Punto>>(){


            @Override
            public void onResponse(Call<List<Punto>> call, Response<List<Punto>> response) {

                if(response.isSuccessful()) {
                    lista = response.body();
                    recorrer();

                }
                else{
                    Log.e(TAG,"onResponse: " + response.errorBody());
                }


            }

            @Override
            public void onFailure(Call<List<Punto>> call, Throwable t) {
                Log.e(TAG,"onFailure: " + t.getMessage());
            }
        });
    }


    public void recorrer() {

        for(int i=0; i < lista.size(); i++){

            Punto e = (Punto) lista.get(i);
            //Log.i(TAG,"Nombre: " + e.getNombre() );

            String lat = (e.getLatitud());
            Log.i(TAG,"Vocero: " + e.getVocero() + " - latitud: " +lat);

            double latitud = Double.parseDouble(e.getLatitud());
            double longitud = Double.parseDouble(e.getLongitud());
            String vocero =(e.getVocero());
            String municipio = (e.getMunicipio());
            String categoria = (e.getCategoria());
            String subcat = (e.getSubcategoria());

            coordenada = new LatLng(latitud, longitud);

            dibujarMarcador(vocero, municipio, categoria,subcat);


        }

    }


    public void dibujarMarcador ( String vocero, String municipio, String categoria, String subcat){

        mMap.addMarker(new MarkerOptions().position(coordenada).title("Vocero: " + vocero + " Municipio: " + municipio ).snippet(categoria+" "+subcat)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


    }


}

