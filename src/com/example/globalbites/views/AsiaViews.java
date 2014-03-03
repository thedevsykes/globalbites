/**
 * Navigation page, to access Asia counties
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

public class AsiaViews extends Activity implements OnClickListener {
	
	private Button chinese;
	private Button indian;
	private Button indonesian;
	private Button korean;
	private Button thai;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asia);
		// Show the Up button in the action bar.
		setupActionBar();
		
		chinese= (Button)findViewById(R.id.chinese);
		chinese.setOnClickListener(this);
		
		indian= (Button)findViewById(R.id.indian);
		indian.setOnClickListener(this);
		
		indonesian= (Button)findViewById(R.id.indonesian);
		indonesian.setOnClickListener(this);
		
		korean= (Button)findViewById(R.id.korean);
		korean.setOnClickListener(this);
		
		thai= (Button)findViewById(R.id.thai);
		thai.setOnClickListener(this);
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() 
	{
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}


	public void onClick (View v)
	{
		Intent i = new Intent(this, RecipeListView.class);
		
		if ( v.getId() == R.id.chinese)
		{
			i.putExtra("country", "chinese");
		}
		
		else if ( v.getId() == R.id.indian)
		{
			i.putExtra("country", "indian");
		}
		
		else if ( v.getId() == R.id.indonesian)
		{
			i.putExtra("country", "indonesian");
		}
		
		else if ( v.getId() == R.id.korean)
		{
			i.putExtra("country", "korean");
		}
		
		else if ( v.getId() == R.id.thai)
		{
			i.putExtra("country", "thai");
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
