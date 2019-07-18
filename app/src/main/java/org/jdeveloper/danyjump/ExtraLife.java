package org.jdeveloper.danyjump;

public class ExtraLife extends GameObject {

    ExtraLife(float worldStartX,float worldStartY,char type){

        final float HEIGHT=.8f;
        final float WIDTH=.65f;

        setHeight(HEIGHT);
        setWidth(WIDTH);

        setType(type);

        setBitmapName("life");

        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();

    }


    public void update(long fps,float gravity){

    }
}
