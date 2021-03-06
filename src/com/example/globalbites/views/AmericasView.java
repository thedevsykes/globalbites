/**
 * Navigation page, to access American counties
 */

package com.example.globalbites.views;

import com.example.globalbites.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class AmericasView extends Activity implements OnClickListener {
	
	private Button usa;
	private Button caribbean;
	private Button mexican;
	private Button brazillian;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_americas);
		// Show the Up button in the action bar.
		setupActionBar();
		
		usa= (Button)findViewById(R.id.usa);
		usa.setOnClickListener(this);
		
		caribbean= (Button)findViewById(R.id.caribbean);
		caribbean.setOnClickListener(this);
		
		mexican= (Button)findViewById(R.id.mexican);
		mexican.setOnClickListener(this);
		
		brazillian= (Button)findViewById(R.id.brazillian);
		brazillian.setOnClickListener(this);
		
        TextView usa = (TextView) findViewById(R.id.usa);  
        Typeface usaf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");  
        usa.setTypeface(usaf);
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
		// Note: i.putExtra is a parameter passed to the new activity. 
		//       This means that any value you put in after country
		//		 becomes what is searched for on the JSON. 
		// 		 change values accordingly to filter better recipes. 
		
		Intent i = new Intent(this, RecipeListView.class);
		
		if(v.getId() == R.id.usa)
		{
			i.putExtra("country", "American");
		}
		else if ( v.getId() == R.id.caribbean)
		{
			i.putExtra("country", "Caribbean");
		}
		else if ( v.getId() == R.id.mexican)
		{
			i.putExtra("country", "Mexican");
		}
		else if ( v.getId() == R.id.brazillian)
		{
			i.putExtra("country", "Brazil");
		}
		
		startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
