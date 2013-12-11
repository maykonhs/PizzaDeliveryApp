package br.com.lojapp.pizzadelivery.activity;

import com.lojapp.pizzadelivery.R;
import com.lojapp.pizzadelivery.R.layout;
import com.lojapp.pizzadelivery.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;

public class SplashActivity extends FragmentActivity implements Runnable {

	private TextView appName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);

		appName = (TextView) findViewById(R.id.tv_app_name);

		Typeface face = Typeface.createFromAsset(getAssets(), "alberto.ttf");

		appName.setTypeface(face);

		Handler h = new Handler();
		h.postDelayed(this, 3000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	public void run() {

		startActivity(new Intent(this, MainActivity.class));
		this.finish();

	}

}
