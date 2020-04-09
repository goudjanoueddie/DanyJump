package org.jdeveloper.danyjump;

import android.content.Context;

public class GorilleEnemy extends GameObject {

    private float waypointleft;
    private float waypointright;
    private int currentWaypoint;
    final float MAX_X_VELOCITY=6;

    GorilleEnemy(Context context, float worldStartX, float worldStartY, char type, int pixelsPerMetre){

        final int ANIMATION_FPS=8;
        final int ANIMATION_FRAME_COUNT=8;
        final String BITMAP_NAME="gorille";
        final float HEIGHT=2;
        final float WIDTH=2;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);

        setBitmapName(BITMAP_NAME);
        setMoves(true);
        setActive(true);
        setVisible(true);

        //Moving enemy
        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setAnimated(context,pixelsPerMetre,true);

        setWorldLocation(worldStartX,worldStartY,0);
        setxVelocity(-MAX_X_VELOCITY);
        currentWaypoint=1;

    }

    public void setWaypoints(float x1,float x2){

        waypointleft=x1;
        waypointright=x2;

    }

    public void update(long fps,float gravity){


        if(currentWaypoint ==1){

            if (getWorldLocation().x <= waypointleft){
                currentWaypoint=2;
                setxVelocity(MAX_X_VELOCITY);
                setFacing(RIGHT);
            }
        }

        if(currentWaypoint ==2){

            if (getWorldLocation().x >=waypointright){

                currentWaypoint=1;
                setxVelocity(-MAX_X_VELOCITY);
                setFacing(LEFT);
            }
        }

        move(fps);
        setRectHitbox();

    }
}
