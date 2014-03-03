/**
 * AdapterRecipe
 * 
 * This class adapts the recipe list 
 * pulled from the food2fork api 
 * and dynamically fills the list view. 
 */

package com.example.globalbites;

import java.util.ArrayList;

import com.example.globalbites.models.Recipe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterRecipe extends ArrayAdapter<Recipe>
{
	private ArrayList<Recipe> m_recipeList; 
	private static LayoutInflater m_inflater = null;
	
	public AdapterRecipe(Activity activity, int textViewResourceId, ArrayList<Recipe> recipeList) 
	{
		super(activity, textViewResourceId, recipeList);
		
		this.m_recipeList = recipeList;
		m_inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public int getCount() 
	{
		return m_recipeList.size(); 
	}
	
	public Recipe getItem(Recipe recipe) 
	{
		return recipe; 
	}
	
	public long getItemId(int position) 
	{
		return position;
	}
	
	public static class ViewHolder 
	{
		public TextView display_name;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View vi = convertView; 
		final ViewHolder holder; 
		
		if ( convertView == null )
		{
			vi = m_inflater.inflate(R.layout.activity_recipe_list, null);
			holder = new ViewHolder(); 
			
			holder.display_name = (TextView) vi.findViewById(R.id.display_title);
			
			vi.setTag(holder);
		} else 
		{
			holder = (ViewHolder) vi.getTag(); 
		}
		
		holder.display_name.setText(m_recipeList.get(position).getTitle());

		return vi;
	}
}
