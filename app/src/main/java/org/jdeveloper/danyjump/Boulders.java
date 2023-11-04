package org.jdeveloper.danyjump;

import java.util.Random;

public class Boulders extends GameObject {

    Boulders(float worldStartX,float worldStartY,char type){
        final float HEIGHT=2;
        final float WIDTH=5;

        setHeight(HEIGHT);
        setWidth(WIDTH);

        setType(type);
        setBitmapName("boulder");
        setActive(false);

        //Randomly set tre either in front or just behin the plyer -1 or 1
        Random rand=new Random();
        if(rand.nextInt(2)==0){
            setWorldLocation(worldStartX,worldStartY,-1);
        }else{
            setWorldLocation(worldStartX,worldStartY,1);
        }
    }

    public void update(long fps, float gravity) {

    }
}
