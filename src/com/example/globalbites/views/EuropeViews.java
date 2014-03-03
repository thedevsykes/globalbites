/**
 * Navigation page, to access European counties
 */

package com.example.globalbites.views;

import com.example.globalbites.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class EuropeViews extends Activity implements OnClickListener{

	private Button english;
	private Button french;
	private Button german;
	private Button greek;
	private Button italian;
	private Button polish;
	private Button spanish;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_europe);
		// Show the Up button in the action bar.
		setupActionBar();
		
		english= (Button)findViewById(R.id.english);
		english.setOnClickListener(this);
		
		french= (Button)findViewById(R.id.french);
		french.setOnClickListener(this);
		
		german= (Button)findViewById(R.id.german);
		german.setOnClickListener(this);
		
		greek= (Button)findViewById(R.id.greek);
		greek.setOnClickListener(this);
		
		italian= (Button)findViewById(R.id.italian);
		italian.setOnClickListener(this);
		
		polish= (Button)findViewById(R.id.polish);
		polish.setOnClickListener(this);
		
		spanish= (Button)findViewById(R.id.spanish);
		spanish.setOnClickListener(this);
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() 
	{
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	
	
	@Override
	public void onClick(View v) 
	{
		Intent i = new Intent(this, RecipeListView.class);
		
		if(v.getId() == R.id.english)
		{
			i.putExtra("country", "english");
		}
		else if ( v.getId() == R.id.french)
		{
			i.putExtra("country", "french");
		}
		else if ( v.getId() == R.id.german)
		{
			i.putExtra("country", "german");
		}
		else if ( v.getId() == R.id.greek)
		{
			i.putExtra("country", "greek");
		}
		else if ( v.getId() == R.id.italian)
		{
			i.putExtra("country", "italian");
		}
		else if ( v.getId() == R.id.polish)
		{
			i.putExtra("country", "polish");
		}
		else if ( v.getId() == R.id.spanish)
		{
			i.putExtra("country", "spanish");
		}
		
		startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
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
