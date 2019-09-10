package org.jdeveloper.danyjump;

public class BulletCanon {

    private float x;
    private float y;
    private float xVelocity;
    private int direction;

    BulletCanon(float x,float y,int speed,int direction){

        this.direction=direction;
        this.x=x;
        this.y=y;
        this.xVelocity=speed * direction;

    }

    BulletCanon(float x,float y,int speed){

        this.x=x;
        this.y=y;
        this.xVelocity=speed;

    }

    public int getDirection(){
        return direction;
    }

    public void update(long fps,float gravity){
        x +=xVelocity/fps;
    }

    public void hideBullet(){
        this.x=-100;
        this.xVelocity=0;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }


}
