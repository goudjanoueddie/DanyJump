package org.jdeveloper.danyjump;

import java.util.concurrent.CopyOnWriteArrayList;

public class MachineGunCanon extends GameObject {

    private int maxBullets=10;
    private int numBullets=10;
    private int nextBullet;
    private int rateOfFire=1;
    private long lastShotTime;
    private CopyOnWriteArrayList<BulletCanon> bulletsCanon;
    int speed=20;


    MachineGunCanon(){
        bulletsCanon=new CopyOnWriteArrayList<BulletCanon>();
        lastShotTime=-1;
        nextBullet=-1;
    }

    public int getNumBullets(){
        //tell the view how many bullets there are
        return numBullets;
    }


    public void update(long fps,float gravity){

        //update all the bullets
        for(BulletCanon bulletCanon: bulletsCanon){
            bulletCanon.update(fps, gravity);
        }

    }

    public int getRateOfFire(){
        return rateOfFire;
    }

    public void setFireRate(int rate){
        rateOfFire=rate;
    }


    public float getBulletX(int bulletIndex){
        if(bulletsCanon != null && bulletIndex < numBullets) {
            return bulletsCanon.get(bulletIndex).getX();
        }
        return -1f;
    }


    public float getBulletY(int bulletIndex){
        if(bulletsCanon != null) {
            return bulletsCanon.get(bulletIndex).getY();
        }
        return -1f;
    }

    public void hideBullet(int index){
        bulletsCanon.get(index).hideBullet();
    }

    public int getDirection(int index){
        return bulletsCanon.get(index).getDirection();
    }

    public void shoot(float ownerX,float ownerY,float ownerHeight){


        if(System.currentTimeMillis() - lastShotTime>1000/rateOfFire){

            nextBullet++;

            if (numBullets >=maxBullets){
                numBullets=maxBullets;
            }

            if(nextBullet == maxBullets){
                nextBullet=0;
            }

            lastShotTime = System.currentTimeMillis();
            bulletsCanon.add(nextBullet,new BulletCanon(ownerX,(ownerY+ownerHeight/3),speed));
            numBullets++;

        }

        /*while(true){
           nextBullet ++;

       }*/

    }

}
