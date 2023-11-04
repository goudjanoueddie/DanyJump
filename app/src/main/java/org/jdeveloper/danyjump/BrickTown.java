package org.jdeveloper.danyjump;

public class BrickTown extends GameObject {


    BrickTown(float worldStartX,float worldStartY,char type){


        setTraversable();
        final float HEIGHT=1;
        final float WIDTH=1;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        setBitmapName("bricktown");
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();



    }




    public void update(long fps,float gravity){

    }
}
