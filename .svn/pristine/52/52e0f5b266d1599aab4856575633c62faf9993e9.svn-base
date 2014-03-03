package com.example.globalbites.views;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SearchResultActivity extends Activity
{
	@Override 
	public void onCreate(Bundle savedInstanceState) 
	{
		handleIntent(getIntent()); 
	}
	
	@Override
	protected void onNewIntent(Intent intent) 
	{
		super.onNewIntent(intent); 
		setIntent(intent); 
		handleIntent(intent); 
	}
	
	private void handleIntent(Intent intent) 
	{
		if (Intent.ACTION_SEARCH.equals(intent.getAction()))
		{
			String query = intent.getStringExtra(SearchManager.QUERY);
			Toast.makeText(this, query, 10).show();
			Intent i = new Intent(this, RecipeListView.class); 
			i.putExtra("country", query); 
			
			startActivity(i); 
		}
	}
}
