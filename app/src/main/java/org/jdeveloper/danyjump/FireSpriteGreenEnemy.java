package org.jdeveloper.danyjump;

import android.content.Context;

public class FireSpriteGreenEnemy extends GameObject {


    private float waypointhight;
    private float waypointbottom;
    private int currentWaypoint;
    final float MAX_Y_VELOCITY=7;


    FireSpriteGreenEnemy(Context context, float worldStartX, float worldStartY, char type, int pixelsPerMetre){
        final int ANIMATION_FPS=8;
        final int ANIMATION_FRAME_COUNT=1;
        final String BITMAP_NAME="firespritegreen";


        final float HEIGHT=4;
        final float WIDTH=1;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);

        setBitmapName(BITMAP_NAME);
        setMoves(true);
        setActive(true);
        setVisible(true);

        //Moving the bitmap
        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setAnimated(context,pixelsPerMetre,true);

        setWorldLocation(worldStartX,worldStartY,0);
        setyVelocity(-MAX_Y_VELOCITY);
        currentWaypoint=1;

    }




    public void setWaypoints(float x1,float x2){

        waypointhight=x1;
        waypointbottom=x2;

    }


    public void update(long fps,float gravity){

        if (currentWaypoint ==1){

            if (getWorldLocation().y <= waypointhight){
                currentWaypoint=2;
                setyVelocity(MAX_Y_VELOCITY);
            }

        }

        if (currentWaypoint ==2){

            if (getWorldLocation().y >= waypointbottom){
                currentWaypoint =1;
                setyVelocity(-MAX_Y_VELOCITY);
            }

        }

        move(fps);
        setRectHitbox();

    }
}
