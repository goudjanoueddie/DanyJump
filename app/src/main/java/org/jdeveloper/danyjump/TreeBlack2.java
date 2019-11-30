package org.jdeveloper.danyjump;

import java.util.Random;

public class TreeBlack2 extends GameObject {

    TreeBlack2(float worldStartX,float worldStartY,char type){

        final float HEIGHT=8;
        final float WIDTH=8;
        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        setBitmapName("treeblack2");
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
