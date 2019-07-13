package org.jdeveloper.danyjump;


import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class PlatformActivity extends Activity{

    //handle the view in this object
    private PlatformView platformView;

    @Override
    public void onCreate(Bundle saveInstance){

        super.onCreate(saveInstance);

        Display display =getWindowManager().getDefaultDisplay();

        Point resolution=new Point();
        display.getSize(resolution);


        //set the view for the game and pass screen resolution
        platformView = new PlatformView(this,resolution.x,resolution.y);
        setContentView(platformView);

    }

    @Override
    protected void onPause(){

        super.onPause();
        platformView.pause();

    }

    @Override
    protected  void onResume(){

        super.onResume();
        platformView.resume();

    }
}