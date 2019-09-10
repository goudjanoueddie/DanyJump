package org.jdeveloper.danyjump;

public class VenemeuseEnemy extends GameObject {

    VenemeuseEnemy(float worldStartX,float worldStatY,char type){

        setTraversable();
        final float HEIGHT=4;
        final float WIDTh=4;
        setHeight(HEIGHT);
        setWidth(WIDTh);
        setType(type);
        setBitmapName("venemeuse");
        setWorldLocation(worldStartX,worldStatY,0);
        setRectHitbox();

    }

    public void update(long fps,float gravity){

    }
}
