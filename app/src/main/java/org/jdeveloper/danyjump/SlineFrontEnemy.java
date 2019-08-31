package org.jdeveloper.danyjump;

import android.content.Context;

public class SlineFrontEnemy extends GameObject {

    private float waypointleft;
    private float waypointright;
    private int currentWaypoint;
    final float MAX_X_VELOCITY=3;
    /*private int hitByBulletSlineFrontEnemy = 3;
    private int numberOfBullet=0;*/

    SlineFrontEnemy(Context context,float worldStartX,float worldStartY,char type,int pixelsPerMetre){

        final int ANIMATION_FPS=8;
        final int ANIMATION_FRAME_COUNT=4;
        final String BITMAP_NAME="slimefront";
        final float HEIGHT=3f;
        final float WIDTH=3;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);

        setBitmapName(BITMAP_NAME);
        setMoves(true);
        setActive(true);
        setVisible(true);

        //Animate the bitmap
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




    public void update(long fps, float gravity) {

        if (currentWaypoint ==1){//left way point
            if (getWorldLocation().x <= waypointleft){
                currentWaypoint=2;
                setxVelocity(MAX_X_VELOCITY);
                setFacing(RIGHT);
            }
        }

        if (currentWaypoint == 2){//right
            if(getWorldLocation().x >= waypointright){
                currentWaypoint=1;
                setxVelocity(-MAX_X_VELOCITY);
                setFacing(LEFT);
            }

        }

        move(fps);
        setRectHitbox();

    }

    /*
    private int getHitByBulletSlineFrontEnemy(){
        return hitByBulletSlineFrontEnemy;
    }

    private int getNumberOfBullet(){
        return numberOfBullet;
    }

    */
}

