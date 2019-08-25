package com.example.e_waste.activity.globalfragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.e_waste.R;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.util.List;
import java.util.Objects;

public class GlobalFragment extends Fragment implements OnMapReadyCallback, PermissionsListener {
    private MapView mapView;
    private MapboxMap mapboxMap;
    private PermissionsManager permissionsManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Mapbox.getInstance(Objects.requireNonNull(getContext()), "pk.eyJ1IjoiY2FudHNsZWVwYmVmb3JlY29kZSIsImEiOiJjanpvdHNvaHcwaXVpM2JycXl6b3M3dms5In0.jAlTSz626dlDdL2wCQJgNw");
        View view = inflater.inflate(R.layout.fragment_global, container, false);
        mapView = view.findViewById(R.id.map_nearest);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        return view;
    }

    @SuppressWarnings({"MissingPermission"})
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {
        if (permissionsManager.areLocationPermissionsGranted(Objects.requireNonNull(getContext()))) {
            LocationComponent locationComponent = mapboxMap.getLocationComponent();
            locationComponent.activateLocationComponent(
                    LocationComponentActivationOptions.builder(getContext(), loadedMapStyle).build()
            );

            locationComponent.setLocationComponentEnabled(true);
            locationComponent.setCameraMode(CameraMode.TRACKING);
            locationComponent.setRenderMode(RenderMode.COMPASS);
        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(getActivity());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {
        Toast.makeText(getContext(), R.string.app_name, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {
                    enableLocationComponent(style);
                }
            });
        } else {
            Toast.makeText(getContext(), R.string.error, Toast.LENGTH_LONG).show();
            getActivity().finish();
        }
    }

    @Override
    @SuppressWarnings( {"MissingPermission"})
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {
        GlobalFragment.this.mapboxMap = mapboxMap;

        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                        enableLocationComponent(style);

                        style.addImage("marker-icon-id1",
                                BitmapFactory.decodeResource(
                                        Objects.requireNonNull(getContext()).getResources(), R.drawable.mapbox_marker_icon_default));

                        style.addImage("marker-icon-id2",
                                BitmapFactory.decodeResource(
                                        Objects.requireNonNull(getContext()).getResources(), R.drawable.mapbox_marker_icon_default));

                        style.addImage("marker-icon-id3",
                                BitmapFactory.decodeResource(
                                        Objects.requireNonNull(getContext()).getResources(), R.drawable.mapbox_marker_icon_default));

                        style.addImage("marker-icon-id4",
                                BitmapFactory.decodeResource(
                                        Objects.requireNonNull(getContext()).getResources(), R.drawable.mapbox_marker_icon_default));

                        style.addImage("marker-icon-id5",
                                BitmapFactory.decodeResource(
                                        Objects.requireNonNull(getContext()).getResources(), R.drawable.mapbox_marker_icon_default));

                        GeoJsonSource geoJsonSource1 = new GeoJsonSource("source-id1", Feature.fromGeometry(
                                Point.fromLngLat(116.868692, -1.143950)));
                        style.addSource(geoJsonSource1);

                        GeoJsonSource geoJsonSource2 = new GeoJsonSource("source-id2", Feature.fromGeometry(
                                Point.fromLngLat(116.879192, -1.145233)));
                        style.addSource(geoJsonSource2);

                        GeoJsonSource geoJsonSource3 = new GeoJsonSource("source-id3", Feature.fromGeometry(
                                Point.fromLngLat(116.877906, -1.153603)));
                        style.addSource(geoJsonSource3);

                        GeoJsonSource geoJsonSource4 = new GeoJsonSource("source-id4", Feature.fromGeometry(
                                Point.fromLngLat(116.877019, -1.146702)));
                        style.addSource(geoJsonSource4);

                        GeoJsonSource geoJsonSource5 = new GeoJsonSource("source-id5", Feature.fromGeometry(
                                Point.fromLngLat(116.870397, -1.145281)));
                        style.addSource(geoJsonSource5);

                        SymbolLayer symbolLayer1 = new SymbolLayer("layer-id1", "source-id1");
                        symbolLayer1.withProperties(
                                PropertyFactory.iconImage("marker-icon-id1")
                        );
                        style.addLayer(symbolLayer1);

                        SymbolLayer symbolLayer2 = new SymbolLayer("layer-id2", "source-id2");
                        symbolLayer2.withProperties(
                                PropertyFactory.iconImage("marker-icon-id2")
                        );
                        style.addLayer(symbolLayer2);

                        SymbolLayer symbolLayer3 = new SymbolLayer("layer-id3", "source-id3");
                        symbolLayer3.withProperties(
                                PropertyFactory.iconImage("marker-icon-id3")
                        );
                        style.addLayer(symbolLayer3);

                        SymbolLayer symbolLayer4 = new SymbolLayer("layer-id4", "source-id4");
                        symbolLayer4.withProperties(
                                PropertyFactory.iconImage("marker-icon-id4")
                        );
                        style.addLayer(symbolLayer4);

                        SymbolLayer symbolLayer5 = new SymbolLayer("layer-id5", "source-id5");
                        symbolLayer5.withProperties(
                                PropertyFactory.iconImage("marker-icon-id5")
                        );
                        style.addLayer(symbolLayer5);

                        mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(@NonNull Marker marker) {
                                Toast.makeText(getContext(), "Yas", Toast.LENGTH_LONG).show();
                                return true;
                            }
                        });
                    }
                });
    }
}
