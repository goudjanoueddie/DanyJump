package org.jdeveloper.danyjump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public abstract class GameObject {

    private Vector4Point6D wordLocation;
    private float width;
    private float height;

    private boolean active=true;
    private boolean  visible=true;
    private int animFrameCount = 1;
    private char type;

    private String bitmapName;

    //Track movement of bob

    private float xVelocity;
    private float yVelocity;
    final int LEFT=-1;
    final int RIGHT=-1;
    private int facing;
    private boolean moves=false;


    public abstract  void update(long fps,float gravity);

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getBitmapName(){

        return bitmapName;
    }

    public Bitmap prepareBitmap(Context context,String bitmapName,int pixelsPerMetre){

        //get the resource ID from bitmapfile
        int resID=context.getResources().getIdentifier(bitmapName,"drawable",context.getPackageName());

        Bitmap bitmap=BitmapFactory.decodeResource(context.getResources(),resID);

        bitmap = Bitmap.createScaledBitmap(bitmap,(int)(getWidth() * animFrameCount*pixelsPerMetre),(int)(getHeight() *pixelsPerMetre),false);

        return bitmap;

    }

    public Vector4Point6D getWordLocation(){

        return wordLocation;
    }

    public void setWordLocation(float x,float  y,int z){

        this.wordLocation=new Vector4Point6D();
        this.wordLocation.x=x;
        this.wordLocation.y=y;
        this.wordLocation.z=z;

    }


    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setBitmapName(String bitmapName) {
        this.bitmapName = bitmapName;
    }

    public char getType(){
        return type;
    }

    public void setType(char type){

        this.type=type;

    }

    void  move(long fps){

        if(xVelocity !=0){
            this.wordLocation.x+=xVelocity/fps;
        }

        if (yVelocity !=0){
            this.wordLocation.y+=yVelocity/fps;
        }

    }

    public int getFacing(){
        return  facing;
    }

    public void setFacing(int facing){
        this.facing=facing;
    }


    public float getxVelocity(){
        return  xVelocity;
    }

    //for Objects that have the ability to moves
    public void setxVelocity(float xVelocity){
        if(moves){
            this.xVelocity=xVelocity;
        }
    }

    public float getyVelocity(){
        return yVelocity;
    }

    //for object that can moves
    public void setyVelocity(float yVelocity){
        if(moves){

            this.yVelocity=yVelocity;
        }
    }

    public boolean isMoves(){
        return  moves;
    }

    public void setMoves(boolean moves){
        this.moves=moves;
    }


}//End of GameObject class
