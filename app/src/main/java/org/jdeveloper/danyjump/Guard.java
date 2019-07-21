package org.jdeveloper.danyjump;

import android.content.Context;

public class Guard extends GameObject {

    private float waypointX1;//on the left
    private float waypointX2;//on right
    private int currentWaypoint;
    final float MAX_X_VELOCITY=3;


    Guard(Context context,float worldStartX,float worldStartY,char type,int pixelsPerMetre){

        final int ANIMATION_FPS =8;
        final int ANIMATION_FRAME_COUNT=5;
        final String BITMAP_NAME="guard";
        final float HEIGHT=2f;
        final float WIDTH=1;

        setHeight(HEIGHT);
        setWidth(WIDTH);

        setType(type);

        setBitmapName(BITMAP_NAME);
        setMoves(true);
        setActive(true);
        setVisible(true);

        //the following line of codes animate the object
        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setAnimated(context,pixelsPerMetre,true);

        setWorldLocation(worldStartX,worldStartY,0);
        setxVelocity(-MAX_X_VELOCITY);
        currentWaypoint=1;


    }

    public void setWaypoints(float x1,float x2){
        waypointX1=x1;
        waypointX2=x2;
    }

    public void update(long fps, float gravity){

    }
}
