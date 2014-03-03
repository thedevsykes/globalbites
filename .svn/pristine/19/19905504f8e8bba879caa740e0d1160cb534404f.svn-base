/**
 * Navigation page, to accessw counties
 */

package com.example.globalbites.views;

import com.example.globalbites.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CountriesView extends Activity implements OnClickListener {

	private Button asia;
	private Button europe;
	private Button americas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_countries);
		// Show the Up button in the action bar.
		setupActionBar();

		asia = (Button) findViewById(R.id.asia);
		asia.setOnClickListener(this);

		europe = (Button) findViewById(R.id.europe);
		europe.setOnClickListener(this);

		// middleEast= (Button)findViewById(R.id.middle_east);
		// middleEast.setOnClickListener(this);

		americas = (Button) findViewById(R.id.americas);
		americas.setOnClickListener(this);

		TextView txt = (TextView) findViewById(R.id.asia);
		Typeface font = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		txt.setTypeface(font);

		TextView eu = (TextView) findViewById(R.id.europe);
		Typeface euf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		eu.setTypeface(euf);

		// TextView me = (TextView) findViewById(R.id.middle_east);
		// Typeface mef = Typeface.createFromAsset(getAssets(),
		// "Ackermann.otf");
		// me.setTypeface(mef);

		TextView am = (TextView) findViewById(R.id.americas);
		Typeface amf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		am.setTypeface(amf);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.asia) {
			Intent i = new Intent(this, AsiaViews.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_in_left,
					R.anim.slide_out_left);
		} else {
			if (v.getId() == R.id.europe) {
				Intent i = new Intent(this, EuropeViews.class);
				startActivity(i);
				overridePendingTransition(R.anim.slide_in_left,
						R.anim.slide_out_left);
			}

			if (v.getId() == R.id.americas) {
				Intent i = new Intent(this, AmericasView.class);
				startActivity(i);
				overridePendingTransition(R.anim.slide_in_left,
						R.anim.slide_out_left);
			}
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
