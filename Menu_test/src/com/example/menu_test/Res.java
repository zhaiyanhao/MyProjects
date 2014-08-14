package com.example.menu_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class Res extends Fragment {
	ListView listview;
	String [] intro;
	ArrayList<Map<String,Object>> listData= new ArrayList<Map<String,Object>>();
	Context context;

	public Res() {
		// Required empty public constructor
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view= inflater.inflate(R.layout.fragment_res, container, false);
		listview = (ListView)view.findViewById(R.id.list_pic);
		intro =view.getResources().getStringArray(R.array.dish);
		context=getActivity();
		//img = new ImageView(context); 
		ItemIn();	
		
		
		SimpleAdapter adapter = new SimpleAdapter(getActivity(),listData,R.layout.menu_list_pic,  
		        new String[]{"intro_pic","intro"},new int[]{R.id.intro_pic,R.id.intro});   
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getActivity(), "clicked at positon"+position, Toast.LENGTH_SHORT).show();
				switch(position){
				case 0 :
					ImageView img = new ImageView(context);  
					img.setImageResource(R.drawable.intro1);  
					new AlertDialog.Builder(context)   
					.setView(img)  
					.setMessage("Burrito Flour tortilla, choice of cilantro-lime rice, pinto or black beans, meat (braised carnitas or barbacoa, adobo-marinated and grilled chicken or steak) or guacamole, salsa and cheese or sour cream.")
					.setPositiveButton("OK", null).create()  
					.show();  					
					break;
				case 1 :
					ImageView img2 = new ImageView(context);  
					img2.setImageResource(R.drawable.intro2);  
					new AlertDialog.Builder(context)   
					.setView(img2)  
					.setMessage("Crispy Tacos Crispy corn shells filled with meat (braised carnitas or barbacoa, adobo-marinated and grilled chicken or steak), salsa, cheese or sour cream and romaine lettuce.")
					.setPositiveButton("OK", null)  
					.show();  					
					break;
				case 2 :
					ImageView img3 = new ImageView(context);  
					img3.setImageResource(R.drawable.intro3);  
					new AlertDialog.Builder(context)   
					.setView(img3) 
					.setMessage("Soft Tacos Soft flour tortillas filled with meat (braised carnitas or barbacoa, adobo-marinated and grilled chicken or steak), salsa, cheese or sour cream and romaine lettuce.")
					.setPositiveButton("OK", null)  
					.show();  					
					break;
				case 3 :
					ImageView img4 = new ImageView(context);  
					img4.setImageResource(R.drawable.intro4);  
					new AlertDialog.Builder(context)  
					.setView(img4)
					.setMessage("Salad Chopped romaine lettuce with choice of pinto or black beans, meat (braised carnitas or barbacoa, adobo-marinated and grilled chicken or steak) or guacamole, salsa and cheese, with freshly made chipotle-honey vinaigrette.")
					.setPositiveButton("OK", null)  
					.show();  					
					break;
				case 4 :
					ImageView img5 = new ImageView(context);  
					img5.setImageResource(R.drawable.intro5);  
					new AlertDialog.Builder(context)  
					.setView(img5)
					.setMessage("Burrito Bowl Served in a bowl, choice of cilantro-lime rice, pinto or black beans, meat (braised carnitas or barbacoa, adobo-marinated and grilled chicken or steak) or guacamole, salsa and cheese or sour cream")
					.setPositiveButton("OK", null)  
					.show();  					
					break;
				
				}
				
			}
		});
		
		return view;
	}

	private void ItemIn() {
		Map<String,Object> item = new HashMap<String,Object>();  
        item.put("intro_pic", R.drawable.item1);  
        item.put("intro", intro[0]);  
        listData.add(item); 
       
        Map<String,Object> item2 = new HashMap<String,Object>();  
        item2.put("intro_pic", R.drawable.item2);  
        item2.put("intro", intro[1]);  
        listData.add(item2); 
       
        Map<String,Object> item3 = new HashMap<String,Object>();  
        item3.put("intro_pic", R.drawable.item3);  
        item3.put("intro", intro[2]);  
        listData.add(item3); 
        
        Map<String,Object> item4 = new HashMap<String,Object>();  
        item4.put("intro_pic", R.drawable.item4);  
        item4.put("intro", intro[3]);  
        listData.add(item4); 
        
        Map<String,Object> item5 = new HashMap<String,Object>();  
        item5.put("intro_pic", R.drawable.item5);  
        item5.put("intro", intro[4]);  
   
        listData.add(item5);   
		
	}


}
