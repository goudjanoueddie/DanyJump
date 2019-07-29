package org.jdeveloper.danyjump;

public class TortueEnemy extends GameObject {

    TortueEnemy(float worldStartX,float worldStartY,char type){

        final float HEIGHT=2;
        final float WIDTH=2;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setBitmapName("tortues");
        setActive(false);
        setType(type);
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();


    }



    public void update(long fps, float gravity) {

    }
}
