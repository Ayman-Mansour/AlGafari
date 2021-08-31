package tech2go.example.com.algafari;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class ContactusFragment extends Fragment {
    Intent intent;
    MapView mMapView;
    private GoogleMap googleMap;

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_location, container, false);
    }*/


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Contact");

        /*ImageView imageViewLocation = (ImageView) view.findViewById(R.id.section_icon_location);
        ImageView imageViewSocial = (ImageView) view.findViewById(R.id.section_icon_social);
        ImageView imageViewMessage = (ImageView) view.findViewById(R.id.section_icon_message);
        imageViewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),LocationActivity.class);
                startActivity(intent);
            }
        });
        imageViewSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),SocialActivity.class);
                startActivity(intent);
            }
        });
        imageViewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),MessageActivity.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_fragment, container, false);
        final FloatingActionButton actionButton = (FloatingActionButton) rootView.findViewById(R.id.add_button);
        com.github.clans.fab.FloatingActionButton faceFAB = (com.github.clans.fab.FloatingActionButton) rootView.findViewById(R.id.menu_item1);
//        com.github.clans.fab.FloatingActionButton  fab = (com.github.clans.fab.FloatingActionButton) rootView.findViewById(R.id.menu_item3);
        com.github.clans.fab.FloatingActionButton messageFAB = (com.github.clans.fab.FloatingActionButton) rootView.findViewById(R.id.menu_item3);

        faceFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                final String urlFb1 = "fb://page/530387500445728";
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlFb1));

                // If a Facebook app is installed, use it. Otherwise, launch
                // a browser
                final PackageManager packageManager1 = getActivity().getPackageManager();
                List<ResolveInfo> list1 =
                        packageManager1.queryIntentActivities(intent,
                                PackageManager.MATCH_DEFAULT_ONLY);
                if (list1.size() == 0) {
                    final String urlBrowser = "https://www.facebook.com/algafarigisco/";
                    intent.setData(Uri.parse(urlBrowser));
                }

                startActivity(intent);
            }
        });

        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        messageFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),MessageActivity.class);
                startActivity(intent);
            }
        });
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

       /*         // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                googleMap.setMyLocationEnabled(true);*/

                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(15.603974, 32.533543);
                mMap.addMarker(new MarkerOptions().position(sydney).title("AlGafari CO. LTD."));
                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(15).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
               /* mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {

                        actionButton.setX(250f);
                        actionButton.setY(250f);

                        return true;
                    }
                });*/
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


   /* @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        LatLng sydney = new LatLng(15.603974, 32.533543);
        mMap.addMarker(new MarkerOptions().position(sydney).title("AlGafari CO. LTD."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }*/
}
