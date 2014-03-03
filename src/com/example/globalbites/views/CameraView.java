/**
 * Description of this class please 
 */

package com.example.globalbites.views;

import java.io.File;

import com.example.globalbites.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CameraView extends Activity implements OnClickListener {
	
	private static final int TAKE_PICTURE = 0;
    private Uri mUri;
    private Bitmap mPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
	
		TextView txt = (TextView) findViewById(R.id.picture);
		Typeface font = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		txt.setTypeface(font);
		
		TextView sh = (TextView) findViewById(R.id.share);
		Typeface shf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		sh.setTypeface(shf);
		
		TextView sn = (TextView) findViewById(R.id.snap);
		Typeface snf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		sn.setTypeface(snf);
		
		TextView rt = (TextView) findViewById(R.id.rotate);
		Typeface rtf = Typeface.createFromAsset(getAssets(), "Ackermann.otf");
		rt.setTypeface(rtf);
		
		findViewById(R.id.photo_holder).setOnClickListener(this);
        ((Button) findViewById(R.id.snap)).setOnClickListener(this);
        ((Button) findViewById(R.id.rotate)).setOnClickListener(this);
	}

	// Using rotate solves the issue of taking the picture and having it landscape or portrait.
	public void onClick(View v) {
        if (v.getId()==R.id.photo_holder) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.getType();
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out my food!");
            startActivity(Intent.createChooser(intent, "Share"));
   }
		else {
        if (v.getId()== R.id.snap) {
                Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        File f = new File(Environment.getExternalStorageDirectory(),  "photo.jpg");
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        mUri = Uri.fromFile(f);
        startActivityForResult(i, TAKE_PICTURE);
        } else {
                if (mPhoto!=null) {
                        Matrix matrix = new Matrix();
           matrix.postRotate(90);
           mPhoto = Bitmap.createBitmap(mPhoto , 0, 0, mPhoto.getWidth(), mPhoto.getHeight(), matrix, true);
           ((ImageView)findViewById(R.id.photo_holder)).setImageBitmap(mPhoto);
               }
        }}
	}
	
	// Override callback , import image and apply it to the image view
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	       switch (requestCode) {
	       case TAKE_PICTURE:
	           if (resultCode == Activity.RESULT_OK) {
	               getContentResolver().notifyChange(mUri, null);
	               ContentResolver cr = getContentResolver();
	               try {
	            	   // Underneath line, is what gets the image and sets the image taken to r.id.photo_holder
	                   mPhoto = android.provider.MediaStore.Images.Media.getBitmap(cr, mUri);
	                ((ImageView)findViewById(R.id.photo_holder)).setImageBitmap(mPhoto);
	               } catch (Exception e) {
	                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
	                  }
	             }
	       }
	}
	

}