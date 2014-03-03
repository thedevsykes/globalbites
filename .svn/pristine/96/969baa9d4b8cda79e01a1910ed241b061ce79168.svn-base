/**
 * NetworkUtils 
 * 
 * A network based utility class. 
 * This provides static methods to 
 * get information and launch jobs 
 * on a network. 
 * 
 * You can call methods as such 
 * NetworkUtils.methodName
 */
package com.example.globalbites;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils 
{
	/**
	 * Checks in the person is connected to a network
	 * (or rather the internet)
	 * @param context
	 * @return true if connected, false otherwise
	 */
	public static boolean isNetworkConnected(Context context) 
	{
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE); 
		NetworkInfo ni = cm.getActiveNetworkInfo(); 
		
		if ( ni == null ) 
		{
			return false; 
		}
		else { 
			return true; 
		}
	}
}
