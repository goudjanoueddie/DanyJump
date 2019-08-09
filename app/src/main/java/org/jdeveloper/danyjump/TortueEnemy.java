package org.jdeveloper.danyjump;

public class TortueEnemy extends GameObject {

    TortueEnemy(float worldStartX,float worldStartY,char type){

        final float HEIGHT=2f;
        final float WIDTH=2;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setBitmapName("tortues");
        setActive(true);
        setType(type);
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();
        setTraversable();


    }



    public void update(long fps, float gravity) {

    }
}
