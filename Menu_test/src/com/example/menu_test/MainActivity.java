package com.example.menu_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




import android.app.Activity;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends FragmentActivity {
	private DrawerLayout drawerLayout;
	private ListView listView;
//	static private SharedPreferences sharedPreference;  
	
	TextView text;
	String[] planets;
	Context context;
	private String [] title;
	ArrayList<Map<String,Object>> sideData= new ArrayList<Map<String,Object>>();
	
	
	

	Bundle bundle1 = new Bundle();
	Bundle bundle2 = new Bundle();
	Bundle bundle3 = new Bundle();

	ImageView needGone;
	private FragmentManager fragmentManager;
	private RadioGroup radioGroup;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context= this;
		setContentView(R.layout.activity_main);
		
		bundle1=getIntent().getExtras();
		bundle2=getIntent().getExtras();
		bundle3=getIntent().getExtras();
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		needGone= (ImageView)findViewById(R.id.need_gone);
		
		//transaction.replace(R.id.content_2, home);
		drawerLayout = (DrawerLayout)findViewById(R.id.container);
		
		drawerLayout.setScrimColor(Color.TRANSPARENT);
		//drawerLayout.setDrawerShadow(R.drawable.shadow, Gravity.LEFT);  
		listView=(ListView)findViewById(R.id.drawerList);
		
		title = this.getResources().getStringArray(R.array.planet);
		PutItemIn();	
		
		
		SimpleAdapter adapter = new SimpleAdapter(context,sideData,R.layout.list_detail,  
		        new String[]{"image","title"},new int[]{R.id.image,R.id.title});   
		listView.setAdapter(adapter);
		listView.setOnItemClickListener((new AdapterView.OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				switch(position){
				case 0:
					Intent toWel = new Intent(MainActivity.this,WelcomActivity.class);
					startActivity(toWel);
					break;
				}
				
			}
		}));
		

	        radioGroup = (RadioGroup)this.findViewById(R.id.rg_tab);
	        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	            @Override
	            public void onCheckedChanged(RadioGroup group, int checkedId) {
	                FragmentTransaction transaction = fragmentManager.beginTransaction();
	                needGone.setVisibility(View.GONE);
	                switch(checkedId){
	                case R.id.Home:
	                //	drawerLayout.openDrawer(listView);
	                	Fragment home= new Home();
	                	transaction.replace(R.id.content_2, home);
	                	
	                break;
	                case R.id.Res:
	                	Fragment res= new Res();
	                	
		                transaction.replace(R.id.content_2, res);
		                break;
	                case R.id.Menu:
	                	Fragment dishmenu= new DishMenu();
	                
	                	dishmenu.setArguments(bundle1);
		                transaction.replace(R.id.content_2, dishmenu);
		                
		                break;
	                case R.id.Drink:
	                	Fragment drink= new Drink();
	                	
	                	drink.setArguments(bundle2);
	                	transaction.replace(R.id.content_2, drink);
				
		                break;
	                case R.id.Info:
	                	Fragment info= new Info();
						info.setArguments(bundle3);
						transaction.replace(R.id.content_2, info);
		
	                
	                }
	              
	                transaction.commit();
	            }
	        });
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private void PutItemIn() {
 
		        Map<String,Object> item = new HashMap<String,Object>();  
		        item.put("image", R.drawable.list_log);  
		        item.put("title", "");  
		   
		        sideData.add(item);   
		        Map<String,Object> item2 = new HashMap<String,Object>();  
		        item2.put("image", R.drawable.list_home);  
		        item2.put("title", "");  
		   
		        sideData.add(item2); 
		        
		
		  
		
	}


	

}
