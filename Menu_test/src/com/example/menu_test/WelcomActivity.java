package com.example.menu_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WelcomActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		Button wel_register = (Button)findViewById(R.id.welcome_register);
		Button wel_login = (Button)findViewById(R.id.welcome_login);
		wel_register.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				 Intent i = new Intent(WelcomActivity.this, RegActivity.class);
				 startActivity(i);
				
			}
			
		});
		
		wel_login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				 Intent i = new Intent(WelcomActivity.this, LoginActivity.class);
				 startActivity(i);
				
			}
			
		});
		
	}
}
