package org.jdeveloper.danyjump;

public class Horizontal1 extends GameObject {

    Horizontal1(float worldStartX,float worldStartY,char type){

        setTraversable();
        final float HEIGHT=1;
        final float WIDTH=1;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        setBitmapName("horizontal1");
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();
    }


    public void update(long fps,float gravity){

    }
}
