package com.example.menu_test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.example.menu_test.CustomHttpClient;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private UserLoginTask mAuthTask = null;

	// Values for email and password at the time of the login attempt.
	private String muser=null;
	private String mPassword;
	private String memail;
	private String mphone;

	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse httpresponse;
	HttpClient httpclient;
	List<NameValuePair> namevaluepair;
	String response = null;
	String[] getResult =new String[3];
	Animation rotate;
	
	Button login;
	// UI references.
	private EditText muserlView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		rotate= AnimationUtils.loadAnimation(this, R.anim.rotate_test);
		// Set up the login form.
		muserlView = (EditText) findViewById(R.id.login_user);
		muserlView.setText(muser);
		login=(Button)findViewById(R.id.sign_in_button);
		mPasswordView = (EditText) findViewById(R.id.login_password);
		mPasswordView
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							attemptLogin();
							return true;
						}
						return false;
					}
				});

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		login.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						
						AnimationSet animset = new AnimationSet(false);
						animset.addAnimation(rotate);
						view.startAnimation(animset);
						animset.setAnimationListener(new AnimationListener(){
							public void onAnimationStart(Animation animation) {  
						        // TODO Auto-generated method stub  
						          
						    }  
						      
						 
						    public void onAnimationRepeat(Animation animation) {  
						        // TODO Auto-generated method stub  
						          
						    }  
						      
						 
						    public void onAnimationEnd(Animation animation) {  
						        // TODO Auto-generated method stub  
						    	attemptLogin();
						    }  
						});
				/*		login.setBackgroundResource(R.drawable.progresslist);
						AnimationDrawable loginAnimation = (AnimationDrawable) login.getBackground();
						loginAnimation.start();
					
						attemptLogin();*/
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
		if (mAuthTask != null) {
			return;
		}

		// Reset errors.
		muserlView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		muser = muserlView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(muser)) {
			muserlView.setError(getString(R.string.error_field_required));
			focusView = muserlView;
			cancel = true;
		} 

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			mLoginStatusMessageView.setText(R.string.login_progress_signing_in);
			showProgress(true);
			mAuthTask = new UserLoginTask();
			mAuthTask.execute(new String[]{muser,mPassword});
		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
	
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class UserLoginTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			// TODO: attempt authentication against a network service.
			   ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
               postParameters.add(new BasicNameValuePair("username", params[0] ));
               postParameters.add(new BasicNameValuePair("password", params[1] ));
			
               String res = null;
			try {
				 response = CustomHttpClient.executeHttpPost("http://192.168.2.4/myfile/menu/index.php", postParameters);
	             res=response.toString();
	            // res= res.replaceAll("\\s+",""); 
				Thread.sleep(2000);
			} catch (Exception e) {
			 Log.i("fuck", e.toString());
			}

			return res;
		}

		@Override
		protected void onPostExecute(String result) {
		mAuthTask = null;
			showProgress(false);
				try {
					getResult=result.split("\\s");
					memail = getResult[1];
					mphone = getResult[2];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(result.contains("1")){
				Intent i = new Intent(LoginActivity.this,MainActivity.class);
				i.putExtra("username", muser);
				i.putExtra("email", memail);
				i.putExtra("phone", mphone);
				i.putExtra("password", mPassword);
				startActivity(i);
			} else {
				mPasswordView
						.setError(getString(R.string.error_incorrect_password));
				mPasswordView.requestFocus();
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}
}
