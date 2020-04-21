package org.jdeveloper.danyjump;


import java.util.Random;

public class FuseBack extends GameObject {


    FuseBack(float worldStartX,float worldStartY,char type){

        final float HEIGHT=2;
        final float WIDTH=3;

        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        setBitmapName("fuseback");
        setActive(true);

        Random rand =new Random();

        if(rand.nextInt(2) ==0){
            setWorldLocation(worldStartX,worldStartY,-1);
            setRectHitbox();
        }else{
            setWorldLocation(worldStartX,worldStartY,1);
            setRectHitbox();
        }

    }


    public void update(long fps, float gravity) {

    }


}
