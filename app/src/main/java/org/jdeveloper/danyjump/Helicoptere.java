package org.jdeveloper.danyjump;

import java.util.Random;

public class Helicoptere extends GameObject {

    Helicoptere(float worldStartX,float worldStartY,char type){

        final float HEIGHT=3;
        final float WIDTH=3;

        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        setBitmapName("helicoptere");
        setActive(true);

        Random random=new Random();

        if(random.nextInt(2) ==0){
            setWorldLocation(worldStartX,worldStartY,-1);
            setRectHitbox();
        }else{
            setWorldLocation(worldStartX,worldStartY,1);
            setRectHitbox();
        }



    }

    public void update(long fps, float gravity){

    }
}
