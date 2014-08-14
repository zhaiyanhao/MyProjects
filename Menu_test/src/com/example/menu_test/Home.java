package com.example.menu_test;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class Home extends Fragment {
	GoogleMap gmap;
	public Home() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View root =inflater.inflate(R.layout.fragment_home, container, false);
		try {
			gmap = ((MapFragment)getActivity().getFragmentManager().findFragmentById(R.id.map)).getMap();
			gmap.setMyLocationEnabled(true);
			gmap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.i("123123123", e.toString());
		}
		// Inflate the layout for this fragment
		return root;
	}

}
