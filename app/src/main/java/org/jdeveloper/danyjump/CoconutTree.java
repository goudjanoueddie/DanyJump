package org.jdeveloper.danyjump;

import java.util.Random;

public class CoconutTree extends GameObject {

    CoconutTree(float worldStartX,float worldStartY,char type){
        final float HEIGHT=4;
        final float WIDTH=4;
        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        setBitmapName("coconuttree");
        setActive(false);

        Random random=new Random();

        if(random.nextInt() ==0){
            setWorldLocation(worldStartX,worldStartY,1);
        }else{

            setWorldLocation(worldStartX,worldStartY,-1);
        }
    }



    public void update(long fps,float gravity){

    }
}
