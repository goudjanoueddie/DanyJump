package org.jdeveloper.danyjump;

public class BackgroundData {

    String bitmapName;
    boolean isParallax;
    int layer;
    float startY;
    float endY;
    float speed;
    int height;
    int width;

    public BackgroundData(String bitmap,boolean isParallax,int layer,float startY,float endY,float speed, int height){

        this.bitmapName=bitmap;
        this.isParallax=isParallax;
        this.layer=layer;
        this.startY=startY;
        this.endY=endY;
        this.speed=speed;
        this.height=height;

    }
}
