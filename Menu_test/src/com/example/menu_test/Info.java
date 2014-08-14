package com.example.menu_test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */

public class Info extends Fragment {
	
	Animation rotate;
	String username;
	String email_info;
	String phone_info;
	String password;
	Button change;
	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse httpresponse;
	HttpClient httpclient;
	List<NameValuePair> namevaluepair;
	String response = null;
	String[] getResult =new String[2];
	
	TextView userView;
	TextView emailView;
	TextView phoneView;
	Bundle bundle;	
/*	private Runnable mRunnable;
	Handler mHandler;*/
	
	public Info() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View root = inflater.inflate(R.layout.fragment_info, container, false);
		bundle = getArguments();
			
	     username = bundle.getString("username");
	     password = bundle.getString("password");
	     email_info = bundle.getString("email") ;
	 	phone_info = bundle.getString("phone");
		rotate= AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_test);
			userView=(TextView)root.findViewById(R.id.info_username); 
			emailView=(TextView)root.findViewById(R.id.info_email);
			phoneView=(TextView)root.findViewById(R.id.info_phone);
			change =(Button)root.findViewById(R.id.change_info);
			 userView.setText(username);
			 emailView.setText(email_info);
			 phoneView.setText(phone_info);
			 
/*			 mHandler= new Handler() {
				  @Override
				  public void handleMessage(Message msg) {
				   super.handleMessage(msg);
				   //3sºóÖ´ÐÐ´úÂë
				  }
				 };
			 
			 mRunnable= new Runnable() {
				  @Override
				  public void run() {
				   mHandler.sendEmptyMessage(1);
				  }
				 };*/
		
			 change.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					AnimationSet animset = new AnimationSet(false);
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
					    	Intent i = new Intent(getActivity(),ResetActivity.class);
							i.putExtra("username", username);
							i.putExtra("password", password);
							startActivity(i); 
					    }  
					});
					
					
				}
				 
			 });
		
/*		 try {
			validateUserTask task = new validateUserTask();
			 String uname = username;

			 task.execute(new String[]{uname});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.i("1111111111",e.toString());
		}*/

		return  root; 
		
	}
	/*private class validateUserTask extends AsyncTask<String, Void, String> {
		  @Override
		  protected String doInBackground(String... params) {
		   // TODO Auto-generated method stub
		   ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		                 postParameters.add(new BasicNameValuePair("username", params[0] ));
		                 
 
		                 String res = null;
		         try {
		             response = CustomHttpClient.executeHttpPost("http://192.168.2.4/myfile/menu/request_info.php", postParameters);
		             res=response.toString();
		             res= res.replaceAll("\\s+",""); 
		             
		         } 
		         catch (Exception e) {
		        	 Log.i("back",e.toString());
					}
		         
		   return res;
		  }//close doInBackground
		  
		  
protected void onPostExecute(String result) {
					getResult = result.split(" ");
					email_info=getResult[0];
					phone_info=getResult[1];

			 
			   }//close onPostExecute
			    }// close validateUserTask 
*/
}
