/**
 * HTTP Call
 */

package com.example.globalbites;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.AsyncTask;

public class food2forkApi extends Activity 
{
	private String apiKey = "93dcbd4653ba9ae39ed0ea80aa804614";
	private String result;

	public void searchForRecipes(String searchTerm) 
	{
		String url = "http://food2fork.com/api/search?key=" + apiKey + "&q="
				+ searchTerm;
		new GetRecipes().execute(url);
	}

	public void onReturnData(JSONObject jObj) throws JSONException 
	{
		System.out.println("Number of Recipes Found = " + jObj.getInt("count"));
	}
	
	public String getResult() 
	{
		return result; 
	}

	class GetRecipes extends AsyncTask<String, String, String> 
	{
		@Override
		protected String doInBackground(String... uri) 
		{
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response;
			String responseString = null;
			try {
				response = httpclient.execute(new HttpGet(uri[0]));
				StatusLine statusLine = response.getStatusLine();
				if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					response.getEntity().writeTo(out);
					out.close();
					responseString = out.toString();
				} else {
					// Closes the connection.
					response.getEntity().getContent().close();
					throw new IOException(statusLine.getReasonPhrase());
				}
			} catch (ClientProtocolException e) {
				// TODO Handle problems..
			} catch (IOException e) {
				// TODO Handle problems..
			}
			return responseString;
		}

		@Override
		public void onPostExecute(String result) 
		{
			super.onPostExecute(result);
			// Do anything with response..
			// System.out.println(result);
			try {
				JSONObject jObj = new JSONObject(result);
				food2forkApi.this.onReturnData(jObj);
				result = "OK";
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
