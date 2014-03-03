/**
 * NetworkWebpageLoader 
 * 
 * Parses the HTML from the food2fork website
 * on the network thread. 
 * 
 * Proceeds to format and add the ingredients 
 * to the text view. 
 */

package com.example.globalbites;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

public class NetworkWebpageLoader extends AsyncTask<View, Integer, ArrayList<String>> 
{
	private TextView m_textView;

	@Override
	protected ArrayList<String> doInBackground(View... params) 
	{
		ArrayList<String> m_ingredients = new ArrayList<String>();

		try {

			this.m_textView = (TextView) params[0];
			URL url = new URL((String) m_textView.getTag());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			BufferedReader reader = null;

			reader = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			
			// Holds the current line read from the HTML. 
			String line = "";
			
			// Begin to parse the HTML page. 
			// Note: This is probably not the most 
			// optimised way to do this, probably worth 
			// rethinking this later, using the Pattern 
			// class more exclusively. 
			while ((line = reader.readLine()) != null) {
				// In the string look for <h5>Ingredients:,/h5>
				if (line.contains("<h5>Ingredients:</h5>")) {
					// Find the url.
					line = reader.readLine();

					if (line.contains("<ul>")) {
						line = reader.readLine();
						// Keep reading lines until we find the closing
						// brace.
						while (!line.contains("</ul>")) {
							line = reader.readLine();

							Pattern p = Pattern
									.compile("<li itemprop=\"ingredients\">(.*?)</li>");
							Matcher m = p.matcher(line);

							if (m.find()) {
								// Add the new ingredient to the 
								// array list. 
								m_ingredients.add(m.group(1));
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m_ingredients;
	}
	
	/**
	 * Formats and sets the textview to the ingredients
	 * passed. 
	 */
	protected void onPostExecute(ArrayList<String> result) 
	{
		String ingredients = "";

		for (int i = 0; i < result.size(); ++i) {
			ingredients += result.get(i) + "\n";
		}

		m_textView.setText(ingredients);
	}
}
