package org.jdeveloper.danyjump;

public class Coin extends GameObject {

    Coin(float worldStartX,float worldStartY,char type){
        final float HEIGHT=.5f;
        final float WIDTH=.5f;

        setHeight(HEIGHT);
        setWidth(WIDTH);

        setType(type);

        setBitmapName("coin");
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();
    }

    public void update(long fps,float gravity){

    }
}
