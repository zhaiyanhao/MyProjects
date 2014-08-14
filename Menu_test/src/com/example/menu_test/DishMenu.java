package com.example.menu_test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.example.menu_test.CustomHttpClient;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DishMenu extends Fragment {

	String username;
	Button submitMenu;
	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse httpresponse;
	HttpClient httpclient;
	List<NameValuePair> namevaluepair;
	String response = null;
	Bundle bundle;
	Animation rotate;
	RadioGroup radio_flavor;
	RadioGroup radio_rice;
	RadioGroup radio_bean;
	RadioGroup radio_meat;
	RadioGroup radio_ingredient;
	RadioGroup radio_source;
	AnimationDrawable loginAnimation;
	String [] order_menu = new String[6];
	
	public DishMenu() {
	
	}


	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		bundle = getArguments();
		View root =  inflater.inflate(R.layout.fragment_menu, container, false);
		username = bundle.getString("username");
		submitMenu=(Button)root.findViewById(R.id.menu_submit);
		//rotate= AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_test);
		radio_flavor = (RadioGroup)root.findViewById(R.id.radio_flavor);
		radio_rice = (RadioGroup)root.findViewById(R.id.radio_rice);
		radio_bean = (RadioGroup)root.findViewById(R.id.radio_bean);
		radio_meat = (RadioGroup)root.findViewById(R.id.radio_meat);
		radio_ingredient = (RadioGroup)root.findViewById(R.id.radio_ingredient);
		radio_source = (RadioGroup)root.findViewById(R.id.radio_source);
		
		
//flavor set
		radio_flavor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                case R.id.bowl:
                	order_menu[0]="bowl";                	
                break;
                case R.id.burrito:
                	order_menu[0]="burrito";
	            break;
                case R.id.tacos:
                	order_menu[0]="tacos";         
	            break;      
                }
            }
		});
		
//rice set
		radio_rice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                case R.id.whiterice:
                	order_menu[1]="white_rice";                	
                break;
                case R.id.friedrice:
                	order_menu[1]="fried_rice";
	            break;      
                }
            }
		});
		
//bean set
		radio_bean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                case R.id.blackbean:
                	order_menu[2]="black_bean";                	
                break;
                case R.id.pintobean:
                	order_menu[2]="pinto_bean";
	            break;
      
                }
            }
		});
//meat set
		radio_meat.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                case R.id.chicken:
                	order_menu[3]="chicken";                	
                break;
                case R.id.steak:
                	order_menu[3]="steak";
	            break;
                case R.id.pork:
                	order_menu[3]="pork";
	            break; 
                }
            }
		});	
//ingredient set
		radio_ingredient.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                case R.id.tomato:
                	order_menu[4]="tomato";                	
                break;
                case R.id.chili_corn:
                	order_menu[4]="chili_corn";
	            break;
                case R.id.greenchili:
                	order_menu[4]="greenchili";
	            break; 
                case R.id.redchili:
                	order_menu[4]="redchili";
	            break; 
                }
            }
		});

//source set
		radio_source.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                case R.id.sourcream:
                	order_menu[5]="sourcream";                	
                break;
                case R.id.cuacamole:
                	order_menu[5]="cuacamole";
	            break;
                }
            }
		});
		
		
		submitMenu.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		    	
/*		    	AnimationSet animset = new AnimationSet(false);
				animset.addAnimation(rotate);
				v.startAnimation(animset);
				animset.setAnimationListener(new AnimationListener(){
					public void onAnimationStart(Animation animation) {  
				        // TODO Auto-generated method stub  
				          
				    }  
				      
				 
				    public void onAnimationRepeat(Animation animation) {  
				        // TODO Auto-generated method stub  
				          
				    }  
				      
				 
				    public void onAnimationEnd(Animation animation) {  
				        // TODO Auto-generated method stub  
				    	 try {
								validateUserTask task = new validateUserTask();
								 String uname = bundle.getString("username");

								 task.execute(new String[]{uname,order_menu[0],order_menu[1],order_menu[2],order_menu[3],order_menu[4],order_menu[5]});
								 Toast.makeText(getActivity(), "Menu order success", Toast.LENGTH_LONG).show();
							 } catch (Exception e) {
								// TODO Auto-generated catch block
								Log.i("fuck",e.toString());
							}
				    }  
				});*/
		        // Perform action on click
		    	
		    	submitMenu.setBackgroundResource(R.drawable.drink_submit_select);
		    	loginAnimation= (AnimationDrawable) submitMenu.getBackground();
				//
		    
				loginAnimation.start();
			
				
		    	try {
					validateUserTask task = new validateUserTask();
					 String uname = bundle.getString("username");

					 task.execute(new String[]{uname,order_menu[0],order_menu[1],order_menu[2],order_menu[3],order_menu[4],order_menu[5]});
					 Toast.makeText(getActivity(), "Menu order success", Toast.LENGTH_LONG).show();
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					Log.i("fuck",e.toString());
				}
		    }
});

		
		return root;
}
	private class validateUserTask extends AsyncTask<String, Void, String> {
		  @Override
		  protected String doInBackground(String... params) {
		   // TODO Auto-generated method stub
		   ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		                 postParameters.add(new BasicNameValuePair("username", params[0] ));
		                 postParameters.add(new BasicNameValuePair("flavor", params[1] ));
		                 postParameters.add(new BasicNameValuePair("rice", params[2] ));
		                 postParameters.add(new BasicNameValuePair("bean", params[3] ));
		                 postParameters.add(new BasicNameValuePair("meat", params[4] ));
		                 postParameters.add(new BasicNameValuePair("ingredient", params[5] ));
		                 postParameters.add(new BasicNameValuePair("source", params[6] ));
		             
		                 String res = null;
		         try {
		             response = CustomHttpClient.executeHttpPost("http://192.168.2.4/myfile/menu/ordermenu.php", postParameters);
		             res=response.toString();
		             res= res.replaceAll("\\s+",""); 
		             
		         } 
		         catch (Exception e) {
		        	 Log.i("back",e.toString());
					}
		         
		   return res;
		  }//close doInBackground
		  
		  
		  protected void onPostExecute(String result) {
			    if(result.equals("1")){
			    	
			     //navigate to Main Menu
			    /*Intent i = new Intent(LoginActivity.this, MainMenuActivity.class);
			     startActivity(i);*/
			    
			    }
			  //  else{
			  //   tv.setText("Sorry!! Incorrect Username or Password"); 
			 //   }   
			   }//close onPostExecute
			    }// close validateUserTask 

	
}




