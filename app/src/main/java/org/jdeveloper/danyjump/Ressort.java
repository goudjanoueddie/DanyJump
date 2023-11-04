package org.jdeveloper.danyjump;


import java.util.Random;

public class Ressort extends GameObject {

    Ressort(float worldStartX,float worldStartY,char type){

        final float HEIGHT=3;
        final float WIDTH=3;

        setWidth(WIDTH);
        setHeight(HEIGHT);
        setType(type);
        //setBitmapName("ressort");
        setBitmapName("ressortblack");
        //setBitmapName("ressortblack105");
        //setBitmapName("ressortblack110");
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
