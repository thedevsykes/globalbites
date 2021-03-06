/**
 * All code for 'home screen' of application
 */

package com.example.globalbites.views;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.globalbites.NetworkUtils;
import com.example.globalbites.R;
import com.example.globalbites.food2forkApi;

@SuppressLint("CutPasteId")
public class HomeView extends food2forkApi implements OnClickListener {
	private CharSequence mTitle;
	private Button asia;
	private Button europe;
	private Button americas;
	
	// recipes JSONArray
	JSONArray recipes = null;
	
	// Hashmap for ListView
	ArrayList<HashMap<String, String>> recipieList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		asia = (Button) findViewById(R.id.asia);
		asia.setOnClickListener(this);

		europe = (Button) findViewById(R.id.europe);
		europe.setOnClickListener(this);

		americas = (Button) findViewById(R.id.americas);
		americas.setOnClickListener(this);

		TextView txt = (TextView) findViewById(R.id.aboutButton);
		Typeface font = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		txt.setTypeface(font);

		TextView as = (TextView) findViewById(R.id.asia);
		Typeface asf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		as.setTypeface(asf);

		TextView eu = (TextView) findViewById(R.id.europe);
		Typeface euf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		eu.setTypeface(euf);

		TextView am = (TextView) findViewById(R.id.americas);
		Typeface amf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		am.setTypeface(amf);
		
		recipieList = new ArrayList<HashMap<String, String>>();
		
		if ( !NetworkUtils.isNetworkConnected(this) )
		{
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			// Setting Dialog Title
			alertDialog.setTitle("No Network Connection");
			// Setting Dialog Message
			alertDialog.setMessage("No network connection. Please enable your internet");
			// Showing Alert Message
			alertDialog.show();
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.options_menu, menu);
		
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView(); 
		
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		
		return true;
	}

	//Buttons for home UI
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.aboutButton) {
			Intent i = new Intent(this, AboutView.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_in_left,
					R.anim.slide_out_left);
		} else if (v.getId() == R.id.asia) {
			Intent i = new Intent(this, AsiaViews.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_in_left,
					R.anim.slide_out_left);
		} else  if (v.getId() == R.id.europe) {
			Intent i = new Intent(this, EuropeViews.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_in_left,
					R.anim.slide_out_left);
		} else  if (v.getId() == R.id.americas) {
			Intent i = new Intent(this, AmericasView.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_in_left,
					R.anim.slide_out_left);
		} else  if (v.getId() == R.id.camera) {
			Intent i = new Intent(this, CameraView.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_in_left,
					R.anim.slide_out_left);
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
	
//	@Override
//	public void onReturnData(JSONObject jObj) throws JSONException
//	{
//		super.onReturnData(jObj);
//		System.out.println(jObj.getInt("count")+" Recipes Found");
//		AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//		// Setting Dialog Title
//		alertDialog.setTitle("Alert Dialog");
//		// Setting Dialog Message
//		alertDialog.setMessage(jObj.getInt("count")+" Recipes Found");
//		// Showing Alert Message
//		alertDialog.show();
//	}

}

	
