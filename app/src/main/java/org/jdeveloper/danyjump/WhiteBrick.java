package org.jdeveloper.danyjump;

public class WhiteBrick extends GameObject {

    WhiteBrick(float worldStartX,float worldStartY,char type){

        setTraversable();
        final float HEIGHT=1;
        final float WIDTH=1;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        setBitmapName("brickwhite");
        //setBitmapName("whitebrique2");
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();

    }


    public void update(long fps, float gravity) {

    }
}
