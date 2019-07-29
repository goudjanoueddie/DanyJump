package org.jdeveloper.danyjump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Background {
 //from page 228 books

    Bitmap bitmap;
    Bitmap bitmapReversed;

    int width;
    int height;

    boolean reversedFirst;
    int xClip;
    float y;
    float endY;
    int z;

    float speed;
    boolean isParallax;

    Background(Context context, int yPixelsPerMetre, int screenWidth, BackgroundData data){

        int resID=context.getResources().getIdentifier(data.bitmapName,"drawable",context.getPackageName());
        bitmap= BitmapFactory.decodeResource(context.getResources(),resID);

        reversedFirst=false;

        xClip=0;//start at zero
        y=data.startY;
        endY=data.endY;
        z=data.layer;
        isParallax=data.isParallax;
        speed=data.speed;

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width1 = metrics.widthPixels;
        int height1 = metrics.heightPixels;

        screenWidth=width1;


        //Scale background to fit the screen
        //bitmap=Bitmap.createScaledBitmap(bitmap,screenWidth,data.height*yPixelsPerMetre,true);
       // bitmap=Bitmap.createScaledBitmap(bitmap,screenWidth,data.height,true);

        bitmap=Bitmap.createScaledBitmap(bitmap,screenWidth,height1,true);

        width=bitmap.getWidth();
        height=bitmap.getHeight();

        //Create a mirror of the background
        Matrix matrix=new Matrix();
        matrix.setScale(-1,1);
        bitmapReversed=Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);


    }

    Background(Context context,BackgroundData data){


        int resID=context.getResources().getIdentifier(data.bitmapName,"drawable",context.getPackageName());
        bitmap= BitmapFactory.decodeResource(context.getResources(),resID);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width1 = metrics.widthPixels;
        int height1 = metrics.heightPixels;

        bitmap=Bitmap.createScaledBitmap(bitmap,width1,height1,true);

        width=bitmap.getWidth();
        height=bitmap.getHeight();

        //Create a mirror of the background
        Matrix matrix=new Matrix();
        matrix.setScale(-1,1);
        bitmapReversed=Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);


        //screenWidth=width1;

    }


}
