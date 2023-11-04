package org.jdeveloper.danyjump;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class PlatformActivity2 extends Activity {
    Display display;
    Point resolution;



    // Our object to handle the View
    private PlatformView2 platformView2;

    //Make a Singleton of this class
    private static PlatformActivity2 platformActivity2;

    PlatformActivity2(Bundle savedInstanceState){

        this.onCreate(savedInstanceState);


    }

    public PlatformActivity2(){

    }

    public static PlatformActivity2 getPlatformActivity(){

        if (platformActivity2 ==null){

            platformActivity2=new PlatformActivity2();
        }

        return platformActivity2;

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
        platformView2 = new PlatformView2(this, resolution.x, resolution.y);

        // Make our platformView the view for the Activity
        setContentView(platformView2);

    }

    // If the Activity is paused make sure to pause our thread
    @Override
    protected void onPause() {
        super.onPause();
        platformView2.pause();
    }

    // If the Activity is resumed make sure to resume our thread
    @Override
    protected void onResume() {
        super.onResume();
        platformView2.resume();
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
