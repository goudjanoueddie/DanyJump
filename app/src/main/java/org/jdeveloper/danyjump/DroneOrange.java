package org.jdeveloper.danyjump;

import android.graphics.PointF;

public class DroneOrange extends GameObject {

    long lastWaypointsetTime;
    PointF currentWaypoint;

    final float MAX_VELOCITY=5;
    final float MAX_Y_VELOCITY=5;

    DroneOrange(float worldStartX,float worldStatrY,char type){

        final float HEIGHT=1;
        final float WIDTH=1;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);

        setBitmapName("droneorange");
        setMoves(true);
        setActive(true);
        setVisible(true);

        currentWaypoint=new PointF();

        setWorldLocation(worldStartX,worldStatrY,0);
        setRectHitbox();
        setFacing(RIGHT);

    }



    public void update(long fps,float gravity){

        if (currentWaypoint.x > getWorldLocation().x){
            setxVelocity(MAX_VELOCITY);
        }else if (currentWaypoint.x < getWorldLocation().x){
            setxVelocity(-MAX_VELOCITY);
        }else{
            setxVelocity(0);
        }


        if (currentWaypoint.y >= getWorldLocation().y){
            setyVelocity(MAX_Y_VELOCITY);
        }else if (currentWaypoint.y < getWorldLocation().y){
            setyVelocity(-MAX_Y_VELOCITY);
        }else {
            setyVelocity(0);
        }

        move(fps);
        setRectHitbox();

    }

    public void setWaypoint(Vector2Point5D playerLocation){

        if (System.currentTimeMillis() > lastWaypointsetTime +2000){
            lastWaypointsetTime=System.currentTimeMillis();
            currentWaypoint.x=playerLocation.x;
            currentWaypoint.y=playerLocation.y;
        }
    }
}
