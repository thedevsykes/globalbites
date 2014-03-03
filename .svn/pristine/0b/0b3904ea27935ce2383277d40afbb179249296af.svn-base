/**
 * NetworkImageLoader 
 * 
 * Creates a new job on the Network thread 
 * and pulls down the image provided by the 
 * url. It then adds this to a bitmap and
 * sets the view (ImageView) to this bitmap. 
 */

package com.example.globalbites; 

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

public class NetworkImageLoader extends AsyncTask<View, Integer, Bitmap>
{
	private ImageView m_imageView;
	private Integer m_progress;
	
	public NetworkImageLoader() 
	{
		m_imageView = null; 
		m_progress = 0; 
	}
	
	@Override
	protected Bitmap doInBackground(View... imageViews) 
	{ 
		this.m_imageView = (ImageView) imageViews[0];
		String url = (String) m_imageView.getTag(); 
		Bitmap bitmap = null;
		
		try {
			bitmap = BitmapFactory.decodeStream(
					(InputStream)new URL(url).getContent());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bitmap; 
	}
	
	@Override 
	protected void onPostExecute(Bitmap result) 
	{
		m_imageView.setImageBitmap(result);
	}
	
	public Integer getProgress() 
	{
		return m_progress; 
	}
}