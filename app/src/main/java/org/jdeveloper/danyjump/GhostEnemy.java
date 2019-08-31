package org.jdeveloper.danyjump;

import android.content.Context;

public class GhostEnemy extends GameObject {


    private float waypointX1;
    private float waypointX2;
    private int currentWaypoint;
    final float MAX_X_VELOCITY=3;

    GhostEnemy(Context context,float worldStartX,float worlStartY,char type,int pixelsPerMetre){

        final int ANIMATION_FPS=10;
        final int ANIMATION_FRAME_COUNT=10;
        final String BITMAP_NAME="ghost";
        final float HEIGHT=2;
        final float WIDTH=1;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);

        setBitmapName(BITMAP_NAME);
        setMoves(true);
        setActive(true);
        setVisible(true);

        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setAnimated(context,pixelsPerMetre,true);

        setWorldLocation(worldStartX,worlStartY,0);
        setxVelocity(-MAX_X_VELOCITY);
        currentWaypoint=1;



    }


    public void setWaypoints(float x1,float x2){
        waypointX1=x1;
        waypointX2=x2;
    }


    public void update(long fps,float gravity){

        if (currentWaypoint ==1){
            if (getWorldLocation().x <= waypointX1){
                currentWaypoint=2;
                setxVelocity(MAX_X_VELOCITY);
                setFacing(RIGHT);

            }
        }

        if (currentWaypoint ==2){

            if (getWorldLocation().x >=waypointX2){
                currentWaypoint=1;
                setxVelocity(-MAX_X_VELOCITY);
                setFacing(LEFT);

            }
        }

        move(fps);
        setRectHitbox();

    }



}
