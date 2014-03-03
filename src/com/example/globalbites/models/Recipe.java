/**
 * Recipe 
 * 
 * A model class that contains the data 
 * passed from the JSON file from Food2Fork. 
 * 
 * It's a container for the data. 
 */

package com.example.globalbites.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Recipe implements Serializable
{
	private String m_imageUrl; 
	private String m_title; 
	private String m_publisher;
	private String m_recipeUrl; 
	private String m_f2fUrl; 
	
	public Recipe(String imageUrl, String title, String publisher, String recipeUrl, 
				  String f2fURL)
	{
		this.m_imageUrl = imageUrl;
		this.m_title = title; 
		this.m_publisher = publisher; 
		this.m_recipeUrl = recipeUrl; 
		this.m_f2fUrl = f2fURL;
	}
	
	public String getTitle() 
	{
		return m_title; 
	}
	
	public String getF2FURL() 
	{
		return m_f2fUrl; 
	}
	
	public String getImageUrl()
	{
		return m_imageUrl;
	}
	
	public String getPublisher()
	{
		return m_publisher;
	}
	
	public String getRecipeUrl()
	{
		return m_recipeUrl;
	}
	
	@Override
	public String toString() 
	{
		return m_title;
	}
}
