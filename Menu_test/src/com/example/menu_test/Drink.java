package com.example.menu_test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Activities that
 * contain this fragment must implement the
 * {@link Drink.OnFragmentInteractionListener} interface to handle interaction
 * events.
 * 
 */
public class Drink extends Fragment {

	String username;
	Button submit;
	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse httpresponse;
	HttpClient httpclient;
	List<NameValuePair> namevaluepair;
	String response = null;
	Bundle bundle;
	Animation rotate;
	RadioGroup radio_drink;
	AnimationDrawable loginAnimation;
	String drink_select;

	public Drink() {
		// Required empty public constructor
	}



	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View root = inflater.inflate(R.layout.fragment_drink, container, false);
		bundle = getArguments();
	
		username = bundle.getString("username");
		submit=(Button)root.findViewById(R.id.submit_drink);
		//rotate= AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_test);
		radio_drink = (RadioGroup)root.findViewById(R.id.radio_drink);
		
		radio_drink.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                case R.id.margarita:
                	drink_select="margarita";                	
                break;
                case R.id.coke:
                	drink_select="coke";
	            break;
                case R.id.spirit:
                	drink_select="spirit";         
	            break;      
                }
            }
		});
		
		submit.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on click
		    	
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
							 String uname = username;

							 task.execute(new String[]{uname,drink_select});
							 Toast.makeText(getActivity(), "Menu order success", Toast.LENGTH_LONG).show();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							Log.i("fuck",e.toString());
						}
				    }  
				});*/
				
		    	submit.setBackgroundResource(R.drawable.menu_submit_select);
		    	loginAnimation= (AnimationDrawable) submit.getBackground();
				loginAnimation.start();
				
				

				 try {
					validateUserTask task = new validateUserTask();
					 String uname = username;

					 task.execute(new String[]{uname,drink_select});
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
		                 postParameters.add(new BasicNameValuePair("drink", params[1] ));
		               
		             
		                 String res = null;
		         try {
		             response = CustomHttpClient.executeHttpPost("http://192.168.2.4/myfile/menu/orderdrink.php", postParameters);
		             res=response.toString();
		             res= res.replaceAll("\\s+",""); 
		             
		         } 
		         catch (Exception e) {
		        	 Log.i("back",e.toString());
					}
		         
		   return res;
		  }//close doInBackground
		  
		  
protected void onPostExecute(String result) {
			  
			     //navigate to Main Menu
			    /*Intent i = new Intent(LoginActivity.this, MainMenuActivity.class);
			     startActivity(i);*/
			    
			    }
			  //  else{
			  //   tv.setText("Sorry!! Incorrect Username or Password"); 
			 //   }   
			   }//close onPostExecute
			    }// close validateUserTask 
	




