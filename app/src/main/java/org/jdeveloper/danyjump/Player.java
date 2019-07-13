package org.jdeveloper.danyjump;

import android.content.Context;

public class Player extends GameObject {

    final float MAX_X_VELOCITY = 10;
    boolean isPressingRight = false;
    boolean isPressLeft =false;

    public boolean isFalling;
    private boolean isJumping;

    private long jumpTime;
    private long maxJumpTime = 700; //Jump 7 10 ths of second

    Player(Context context,float worldStartX,float worldStartY,int pixelsPerMetre){
        final float HEIGHT =2;
        final float WIDTH=1;

        setHeight(HEIGHT);
        setWidth(WIDTH);


        //start with this value
        setxVelocity(0);
        setyVelocity(0);
        setFacing(LEFT);
        isFalling=false;

        setMoves(true);
        setActive(true);
        setVisible(true);


        setType('p');


        setBitmapName("player");
        setWordLocation(worldStartX,worldStartY,0);
    }


    public void update(long fps,float gravity){

        if(isPressingRight){
            this.setxVelocity(MAX_X_VELOCITY);
        }else if (isPressLeft){
            this.setxVelocity(-MAX_X_VELOCITY);
        }else{
            this.setxVelocity(0);
        }

        //which way is player facing?
        if (this.getxVelocity()>0){
            setFacing(RIGHT);
        }else if (this.getxVelocity()<0){
            setFacing(LEFT);
        }

    //jumping and gravity
        if (isJumping){
            long timeJumping = System.currentTimeMillis()-jumpTime;
            if (timeJumping <maxJumpTime){
                if (timeJumping < maxJumpTime/2){
                    this.setyVelocity(-gravity);
                }else if (timeJumping >maxJumpTime/2){
                    this.setyVelocity(gravity);//going down
                }
            }else{
                isJumping=false;
            }
        }else{
            this.setyVelocity(gravity);
            isFalling=true;
        }


        //line to update the x and y coordinates if they have changed!!!
        this.move(fps);

    }//end update
}
