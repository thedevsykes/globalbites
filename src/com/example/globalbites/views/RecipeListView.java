/**
 * Description of this class please 
 */

package com.example.globalbites.views;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.globalbites.AdapterRecipe;
import com.example.globalbites.NetworkUtils;
import com.example.globalbites.R;
import com.example.globalbites.food2forkApi;
import com.example.globalbites.models.Recipe;

public class RecipeListView extends food2forkApi
{
	private ArrayList<Recipe> m_recipeList = new ArrayList<Recipe>();
	private AdapterRecipe m_recipeAdapter;
	private ListView m_recipeListView; 
	private String m_country;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe_list);
		setupActionBar();
		
		Intent intent = getIntent(); 
		m_country = intent.getExtras().getString("country");
		
		if ( NetworkUtils.isNetworkConnected(this) )
		{
			//Pre-Set Search Term
			searchForRecipes(m_country);
		} else 
		{
			Intent i = new Intent(this, HomeView.class); 
			startActivity(i); 
		}
		
		m_recipeList = new ArrayList<Recipe>(); 
		m_recipeListView = (ListView) findViewById(R.id.recipe_list_view);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() 
	{
		getActionBar().setDisplayHomeAsUpEnabled(true);
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

	@Override
	public void onReturnData(JSONObject jObj) throws JSONException
	{
		super.onReturnData(jObj);
		JSONArray array = jObj.getJSONArray("recipes");
		
		for (int i = 0; i < array.length(); i++ )
		{	
			JSONObject obj = (JSONObject) array.get(i);
			
			// Note: Remove ID. It's not really required. 
			m_recipeList.add(new Recipe(obj.getString("image_url"), 
						  obj.getString("title"), 
						  obj.getString("publisher"),
						  obj.getString("source_url"),
						  obj.getString("f2f_url")));
		}
		
		m_recipeAdapter = new AdapterRecipe(this, 0, m_recipeList);
		m_recipeListView.setAdapter(m_recipeAdapter);
		
		// Set listener to the list view.
		m_recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,int position, long id) 
			{
				Intent i = new Intent(getBaseContext(), RecipeDisplayView.class); 
				Recipe recipe = m_recipeList.get(position); 
				i.putExtra("recipe", recipe);
		
				startActivity(i);
			}
		});

		jObj.toString();
	}
}
