package org.jdeveloper.danyjump;

import java.util.Random;

public class Stalagmite extends GameObject {

    Stalagmite(float worldStartX,float worldStartY,char type){
        final float HEIGHT=3;
        final float WIDTH=2;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        setBitmapName("stalacmite");
        setActive(false);
        Random random=new Random();

        if (random.nextInt(2) == 0){
            setWorldLocation(worldStartX,worldStartY,-1);
        }else{
            setWorldLocation(worldStartX,worldStartY,1);
        }
    }


    public void update(long fps,float gravity){

    }
}
