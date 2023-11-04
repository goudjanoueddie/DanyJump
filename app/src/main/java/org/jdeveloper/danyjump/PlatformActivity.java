package org.jdeveloper.danyjump;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class PlatformActivity extends Activity {

    Display display;
    Point resolution;



    // Our object to handle the View
    private PlatformView platformView;

    //Make a Singleton of this class
    private static PlatformActivity platformActivity;

     PlatformActivity(Bundle savedInstanceState){

         this.onCreate(savedInstanceState);


    }

    PlatformActivity(){

    }

   public static PlatformActivity getPlatformActivity(){

        if (platformActivity ==null){

            platformActivity=new PlatformActivity();
        }

        return platformActivity;

    }



    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get a Display object to access screen details
        //Display display = getWindowManager().getDefaultDisplay();
        display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        resolution = new Point();

        display.getSize(resolution);

        // And finally set the view for our game
        platformView = new PlatformView(this, resolution.x, resolution.y);

        // Make our platformView the view for the Activity
        setContentView(platformView);

    }

    // If the Activity is paused make sure to pause our thread
    @Override
    protected void onPause() {
        super.onPause();
        platformView.pause();
    }

    // If the Activity is resumed make sure to resume our thread
    @Override
    protected void onResume() {
        super.onResume();
        platformView.resume();
    }

    public Display getDisplay(){
        return display;
    }

    public Point getResolution() {
        return resolution;
    }


    private static String getScreenResolution(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        return "{" + width + "," + height + "}";
    }
}
