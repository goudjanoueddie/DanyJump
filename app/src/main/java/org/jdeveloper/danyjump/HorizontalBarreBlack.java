package org.jdeveloper.danyjump;

import android.content.Context;

public class HorizontalBarreBlack extends  GameObject{

    private float waypointX1;
    private float waypointX2;
    private int currentWaypoint;
    final float MAX_X_VELOCITY=3;


        HorizontalBarreBlack(Context context,float worldStartX,float worldStartY,char type,int pixelsPerMetre){

            setTraversable();
            final float HEIGHT=1;
            final float WIDTH=3;
            setHeight(HEIGHT);
            setWidth(WIDTH);
            setType(type);
            setBitmapName("horizontalbarreblack");
            setWorldLocation(worldStartX,worldStartY,0);
            setRectHitbox();

            setMoves(true);
            setActive(true);
            setVisible(true);


            setAnimated(context,pixelsPerMetre,true);

            setWorldLocation(worldStartX,worldStartY,0);
            setxVelocity(-MAX_X_VELOCITY);
            currentWaypoint=1;

        }

        public void setWaypoints(float x1,float x2){

            waypointX1=x1;
            waypointX2=x2;

        }


    public void update(long fps,float gravity) {

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





