package org.jdeveloper.danyjump;

import android.content.Context;

public class VampireEnemy extends GameObject {


    private float waypointX1;
    private float waypointX2;
    private int currentWaypoint;
    final float MAX_X_VELOCITY=4;

    VampireEnemy(Context context, float worldStartX, float worldStartY, char type, int pixelsPerMetre){

        final int ANIMATION_FPS=4;
        final int ANIMATION_FRAME_COUNT=4;
        final String BITMAP_NAME="vampire";

        final float HEIGHT=2;
        final float WIDTH=2;

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

        setWorldLocation(worldStartX,worldStartY,0);
        setxVelocity(-MAX_X_VELOCITY);
        currentWaypoint=1;


    }

    public void setWaypoints(float X1, float X2){
        waypointX1=X1;
        waypointX2=X2;
    }

    public void update(long fps,float gravity){

        if (currentWaypoint ==1){//Heading left
            if (getWorldLocation().x <= waypointX1){
                currentWaypoint=2;
                setxVelocity(MAX_X_VELOCITY);
                setFacing(RIGHT);
            }

        }

        if (currentWaypoint ==2){//Heading right
            if (getWorldLocation().x >= waypointX2){
                currentWaypoint =1;
                setxVelocity(-MAX_X_VELOCITY);
                setFacing(LEFT);
            }

        }
        move(fps);
        setRectHitbox();


    }
}
