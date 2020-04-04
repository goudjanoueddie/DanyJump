package org.jdeveloper.danyjump;

import java.util.Random;

public class TreeBleu extends GameObject {


    TreeBleu(float worldStartX,float worldStartY,char type){

        final float HEIGHT=6;
        final float WIDTH=6;
        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        setBitmapName("treebleu");
        setActive(false);

        Random random=new Random();

        if (random.nextInt()==0){
            setWorldLocation(worldStartX,worldStartY,-1);
        }else{
            setWorldLocation(worldStartX,worldStartY,1);
        }

    }


    public void update(long fps,float gravity){

    }
}
