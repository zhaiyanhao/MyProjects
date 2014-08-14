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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends Activity {

	private UserLoginTask mAuthTask = null;

	// Values for email and password at the time of the login attempt.
	private String muser;
	private String mPassword;
	private String mPassword2;
	private String mphone;
	private String memail;

	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse httpresponse;
	HttpClient httpclient;
	List<NameValuePair> namevaluepair;
	String response = null;
	Animation rotate;
	
	// UI references.
	private EditText muserlView;
	private EditText mPasswordView;
	private EditText mPasswordView2;
	private EditText mphoneView;
	private EditText memailView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_reg);

		// Set up the login form.
		muserlView = (EditText) findViewById(R.id.register_username);
		mphoneView = (EditText) findViewById(R.id.register_phone);
		memailView = (EditText) findViewById(R.id.register_email);
		muserlView.setText(muser);
		rotate= AnimationUtils.loadAnimation(this, R.anim.rotate_test);
		mPasswordView = (EditText) findViewById(R.id.register_password);
		mPasswordView2 = (EditText) findViewById(R.id.register_repassword);
		
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

		mLoginFormView = findViewById(R.id.register_form);
		mLoginStatusView = findViewById(R.id.register_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.register_status_message);

		findViewById(R.id.register_button).setOnClickListener(
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
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.reg, menu);
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
		mphoneView.setError(null);
		memailView.setError(null);
		mPasswordView2.setError(null);
		
		String user_regex = "[1-9a-zA-Z]{4,12}";
		String email_regex = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
		String phone_regex ="[0-9]{10}";
			

		// Store values at the time of the login attempt.
		muser = muserlView.getText().toString();
		mPassword = mPasswordView.getText().toString();
		mPassword2 = mPasswordView2.getText().toString();
		mphone = mphoneView.getText().toString();
		memail = memailView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid phone
		if (TextUtils.isEmpty(mphone)) {
			mphoneView.setError(getString(R.string.error_field_required));
			focusView = mphoneView;
			cancel = true;
		} else if (!(mphone.matches(phone_regex))) {
			mPasswordView.setError(getString(R.string.error_invalid_phone));
			focusView = mphoneView;
			cancel = true;
		}
		
		
		// Check for a valid email
		
		if (TextUtils.isEmpty(memail)) {
			memailView.setError(getString(R.string.error_field_required));
			focusView = memailView;
			cancel = true;
		} else if (!(memail.matches(email_regex))) {
			memailView.setError(getString(R.string.error_invalid_email));
			focusView = memailView;
			cancel = true;
		}

		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}
		
		if (TextUtils.isEmpty(mPassword2)) {
			mPasswordView2.setError(getString(R.string.error_field_required));
			focusView = mPasswordView2;
			cancel = true;
		} else if (!mPassword2.equals(mPassword)) {
			mPasswordView2.setError(getString(R.string.error_two_different_password));
			focusView = mPasswordView2;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(muser)) {
			muserlView.setError(getString(R.string.error_field_required));
			focusView = muserlView;
			cancel = true;
		}else if (!(muser.matches(user_regex))) {
			muserlView.setError(getString(R.string.error_invalid_user));
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
			mLoginStatusMessageView.setText(R.string.login_progress_register);
			showProgress(true);
			mAuthTask = new UserLoginTask();
			mAuthTask.execute(new String[]{muser,mPassword,memail,mphone});
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
			   ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
               postParameters.add(new BasicNameValuePair("username", params[0] ));
               postParameters.add(new BasicNameValuePair("password", params[1] ));
               postParameters.add(new BasicNameValuePair("email", params[2] ));
               postParameters.add(new BasicNameValuePair("phone", params[3] ));
			
               String res = null;
			try {
				 response = CustomHttpClient.executeHttpPost("http://192.168.2.4/myfile/menu/insert.php", postParameters);
	             res=response.toString();
	             res= res.replaceAll("\\s+",""); 
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

			if(result.equals("1")){
				Intent i = new Intent(RegActivity.this,MainActivity.class);
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
