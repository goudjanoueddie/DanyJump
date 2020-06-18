package org.jdeveloper.danyjump;

import java.util.Random;

public class PlageFinal extends GameObject {

    PlageFinal(float worldStartX,float worldStartY,char type){
        final float HEIGHT=5;
        final float WIDTH=6;

        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        setBitmapName("plagefinal");
        setActive(true);

        Random random=new Random();

        if(random.nextInt(2) ==0){
            setWorldLocation(worldStartX,worldStartY,-1);
            setRectHitbox();
        }else{
            setWorldLocation(worldStartX,worldStartY,-1);
            setRectHitbox();
        }



    }

    public void update(long fps, float gravity){

    }
}
