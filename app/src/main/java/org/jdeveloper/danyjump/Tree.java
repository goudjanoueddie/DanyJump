package org.jdeveloper.danyjump;

import java.util.Random;

public class Tree extends GameObject {

    Tree(float worldStartX,float worldStartY,char type){

        final float HEIGHT=4;
        final float WIDTH=2;
        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        setBitmapName("tree1");
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
