package com.example.menu_test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;


import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetActivity extends Activity {

	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse httpresponse;
	HttpClient httpclient;
	List<NameValuePair> namevaluepair;
	String response = null;
	String oldPassword ;
	String newPassword ;
	String renewPassword ;
	String username;
	Button reset;
	private EditText oldpassView;
	private EditText newpassView;
	private EditText renewpassView;
	Bundle bundle;
	AnimationDrawable resetAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reset);
		
		bundle = getIntent().getExtras();
		
		oldPassword=bundle.getString("password");
		username=bundle.getString("username");
		
		oldpassView=(EditText)findViewById(R.id.oldpass);
		newpassView=(EditText)findViewById(R.id.newpass);
		renewpassView=(EditText)findViewById(R.id.renewpass);
		reset=(Button)findViewById(R.id.reset_pass);

		reset.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on click
		    	

		    	reset.setBackgroundResource(R.drawable.submit_select_list);
		    	resetAnimation= (AnimationDrawable) reset.getBackground();
		    	resetAnimation.start();
		    	
		    	
		    	
				newPassword=newpassView.getText().toString();
				renewPassword=renewpassView.getText().toString();
				String oldpass=oldpassView.getText().toString();
				
			
				
				try {
					validateUserTask task = new validateUserTask();
					
				
					if(newPassword.equals(renewPassword)&&oldPassword.equals(oldpass)){

					task.execute(new String[]{username,newPassword});
					}
					
			
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Log.i("fuck",e.toString());
				}
		    }
});
	

	}
	
	private class validateUserTask extends AsyncTask<String, Void, String> {
		  @Override
		  protected String doInBackground(String... params) {
		   // TODO Auto-generated method stub
		   ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		                 postParameters.add(new BasicNameValuePair("username", params[0] ));
		                 postParameters.add(new BasicNameValuePair("password", params[1] ));
		               
		             
		                 String res = null;
		         try {
		             response = CustomHttpClient.executeHttpPost("http://192.168.2.4/myfile/menu/reset.php", postParameters);
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
}
