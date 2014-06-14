package com.talkscloud.vibra;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	String msg 				= "Android : ";
	boolean vib_status 		= false;
	boolean btn_img_loaded	= false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(msg, "The onCreate() event");
		
		// Perform action on click
    	changeVibrateMode();

		
	}
	
	/** Called when the activity is about to become visible. */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(msg, "The onStart() event");
		changeVibrateMode();
	}
	
	/** Called when the activity has become visible. */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(msg, "The onResume() event");
		changeVibrateMode();
	}
	
	/** Called when another activity is taking focus. */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(msg, "The onPause() event");
	}
	
	/** Called when the activity is no longer visible. */
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(msg, "The onStop() event");
	}
	
	/** Called just before the activity is destroyed. */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(msg, "The onDestroy() event");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user clicks the Get Massage Button */
	public void changeVibrateMode() {
		
		final ImageButton  button = (ImageButton) findViewById(R.id.imageButton1);
		
		if (btn_img_loaded == false){
			button.setBackgroundResource(R.drawable.active);
		}
		
		button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
            	
            	// Get instance of Vibrator from current Context
        		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            	
            	if (vib_status == false) {
        			
        			button.setBackgroundResource(R.drawable.disabled);
        			
        			vib_status 	= true;
        			
        			// Vibrate for 500 milliseconds
        			// Sleep for 100 milliseconds
        			long[] pattern = { 0, 500, 100 };
        			// The "0" means to repeat the pattern starting at the beginning
        			// CUIDADO: If you start at the wrong index (e.g., 1) then your pattern will be off --
        			// You will vibrate for your pause times and pause for your vibrate times !
        			v.vibrate(pattern, 0);
        			
        		} else {
        			button.setBackgroundResource(R.drawable.active);
        			vib_status  = false;
        			v.cancel();
        		}
            	
                
            	Log.d(msg, "on button click");
            }
        });
		
		
	}

}
