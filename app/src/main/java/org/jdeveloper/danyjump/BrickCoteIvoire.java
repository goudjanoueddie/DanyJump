package org.jdeveloper.danyjump;

public class BrickCoteIvoire extends GameObject {


    BrickCoteIvoire(float worldStartX,float worldStartY,char type){

        setTraversable();
        final float HEIGHT=1;
        final float WIDTH=1;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        setBitmapName("brickcotedivoire");
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();


    }


    public void update(long fps,float gravity){

    }
}
