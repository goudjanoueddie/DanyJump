package org.jdeveloper.danyjump;

import java.util.Random;

public class TreeBlack extends GameObject {

    TreeBlack(float worldStartX,float worldStartY,char type){

        final float HEIGHT=6;
        final float WIDTH=5;

        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        setBitmapName("blacktree");
        setActive(false);

        Random random=new Random();

        if (random.nextInt() ==0){

            setWorldLocation(worldStartX,worldStartY,-1);

        }else {
            setWorldLocation(worldStartX,worldStartY,1);
        }

    }

    public void update(long fps,float gravity){

    }
}
