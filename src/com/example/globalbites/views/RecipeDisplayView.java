/**
 * Description please! 
 */

package com.example.globalbites.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.globalbites.NetworkImageLoader;
import com.example.globalbites.NetworkUtils;
import com.example.globalbites.NetworkWebpageLoader;
import com.example.globalbites.R;
import com.example.globalbites.models.Recipe;

public class RecipeDisplayView extends Activity
{
	private Recipe m_displayRecipe;  
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recipe_display_activity);
		setupActionBar();

		Bundle extras = getIntent().getExtras(); 
		m_displayRecipe = (Recipe) extras.getSerializable("recipe");
		
		
		TextView recipeTitle =  (TextView) this.findViewById(R.id.recipe_title);
		recipeTitle.setText(m_displayRecipe.getTitle());

		TextView recipeUrl = (TextView) this.findViewById(R.id.recipe_url); 
		recipeUrl.setClickable(true); 
		recipeUrl.setMovementMethod(LinkMovementMethod.getInstance());
		String urlRecipe = "<a href='"+m_displayRecipe.getRecipeUrl()+"'>"+getString(R.string.recipe_link_text)+"</a>";
		recipeUrl.setText(Html.fromHtml(urlRecipe));
		
	
		// Image Downloader. 
		
		if ( NetworkUtils.isNetworkConnected(this) )
		{
			// Add image form the web.
			ImageView i = (ImageView)findViewById(R.id.food_image);
			String urlImage = m_displayRecipe.getImageUrl(); 
			i.setTag(urlImage);
			
			NetworkImageLoader task = new NetworkImageLoader(); 
			task.execute(i);
			
			TextView ingredients =  (TextView)findViewById(R.id.ingredients);
			String f2fUrl = m_displayRecipe.getF2FURL();
			ingredients.setTag(f2fUrl);
			
			// Ingredients Downloader. 
			NetworkWebpageLoader page = new NetworkWebpageLoader(); 
			page.execute(ingredients);	//Pre-Set Search Term
	
		} else 
		{
			Intent i = new Intent(this, HomeView.class); 
			startActivity(i); 
		}
		
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
}