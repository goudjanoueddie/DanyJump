package org.jdeveloper.danyjump;

import android.content.Context;

public class SbotEnemy extends GameObject {

    public MachineGun bfg;

    private float waypointleft;
    private float waypointrright;
    private int currentWaypoint;
    final float MAX_X_VELOCITY=3;

    SbotEnemy(Context context, float worlStartX, float worldStartY, char type, int pixelsPerMetre){

        final int ANIMATION_FPS=8;
        final int ANIMATION_FRAME_COUNT=5;
        final String BITMAP_NAME="sbot";
        final float HEIGHT =2;
        final float WIDTH=2;

        //bfg = new MachineGun();

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

        setWorldLocation(worlStartX,worldStartY,0);
        setxVelocity(-MAX_X_VELOCITY);
        currentWaypoint=1;

    }

    public void setWaypoints(float x1,float x2){
        waypointleft=x1;
        waypointrright=x2;
    }

    public void update(long fps,float gravity){

        if(currentWaypoint ==1){

            if (getWorldLocation().x <= waypointleft){
                currentWaypoint=2;
                setxVelocity(MAX_X_VELOCITY);
                setFacing(RIGHT);

            }

        }

        if (currentWaypoint ==2){
            if(getWorldLocation().x >=waypointrright){
                currentWaypoint=1;
                setxVelocity(-MAX_X_VELOCITY);
                setFacing(LEFT);
            }
        }

       ///bfg.update(fps, gravity);


        move(fps);
        setRectHitbox();

    }


    public void pullTriggerSbotEnemy() {
        //Try and fire a shot
       bfg.shootSbotEnemy(this.getWorldLocation().x, this.getWorldLocation().y, getFacing(), getHeight());
    }



}
