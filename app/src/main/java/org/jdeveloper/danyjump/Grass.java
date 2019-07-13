package org.jdeveloper.danyjump;

public class Grass extends GameObject {

    Grass(float worldStartX,float worldStartY,char type){
        final float HEIGHT=1;
        final float WIDTH=1;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);

        //choose a Bitmap
        setBitmapName("turf");

        //Where does the tile start
        setWordLocation(worldStartX,worldStartY,0);

    }

    public void update(long fps,float gravity){

    }
}
