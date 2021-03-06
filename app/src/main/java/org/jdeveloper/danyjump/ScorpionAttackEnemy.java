package org.jdeveloper.danyjump;

import android.content.Context;

public class ScorpionAttackEnemy extends GameObject {

    private float waypointX1;//on the left
    private float waypointX2;//on right
    private int currentWaypoint;
    final float MAX_X_VELOCITY=12;


    ScorpionAttackEnemy(Context context, float worldStartX, float worldStartY, char type, int pixelsPerMetre){

        final int ANIMATION_FPS =8;
        final int ANIMATION_FRAME_COUNT=8;
        final String BITMAP_NAME="scorpionattack";
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
