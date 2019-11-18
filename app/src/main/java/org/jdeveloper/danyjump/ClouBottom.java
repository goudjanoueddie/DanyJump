package org.jdeveloper.danyjump;

public class ClouBottom extends GameObject {

    ClouBottom(float worldStartX,float worldStartY,char type){
        final float HEIGHT=2;
        final float WIDTH=1;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        //setBitmapName("cloubottom");
        setBitmapName("pointehaut");
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();

    }




    public void update(long fps,float gravity){

    }
}
