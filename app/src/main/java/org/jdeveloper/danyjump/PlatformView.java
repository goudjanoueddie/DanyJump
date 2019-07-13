package org.jdeveloper.danyjump;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlatformView extends SurfaceView implements Runnable{

    private boolean debugging=true;
    private volatile boolean running;
    private Thread gameThread=null;

    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;

    Context context;
    long startFrameTime;
    long timeThisFrame;
    long fps;


    //engine class object
    private LevelManager lm;
    private Viewport vp;
    InputController ic;
    SoundManager soundManager;

    public PlatformView(Context context,int screenWidth, int screenHeight){

        super(context);
        this.context=context;

        //initialize drawing object
        ourHolder=getHolder();
        paint =new Paint();

        //Initialize viewport object
        vp=new Viewport(screenWidth,screenHeight);

        soundManager=new SoundManager();
        soundManager.loadSound(context);


        //load the level cave
        loadLevel("LevelCave",15,2);


    }

    public void loadLevel(String level,float px,float py){

        lm =null;
        lm=new LevelManager(context,vp.getPixelsPerMetreX(),vp.getScreenWidth(),ic,level,px,py);
        ic=new InputController(vp.getScreenWidth(),vp.getScreenHeight());

        vp.setWorldCentre(lm.gameObjects.get(lm.playerIndex).getWordLocation().x,lm.gameObjects.get(lm.playerIndex).getWordLocation().y);


    }



    @Override
    public void run() {

        while(running){
            startFrameTime=System.currentTimeMillis();
            update();
            draw();

            timeThisFrame=System.currentTimeMillis()-startFrameTime;

            if(timeThisFrame>=1){
                fps=1000/timeThisFrame;
            }
        }

    }

    private void update(){

        for(GameObject go:lm.gameObjects){
            if(go.isActive()){
                if(!vp.clipObjects(go.getWordLocation().x,go.getWordLocation().y,go.getWidth(),go.getHeight())){

                    go.setVisible(true);

                    /*if(lm.isPlaying()){
                        go.update(fps,lm.gravity);
                    }*/

                }else{
                    go.setVisible(false);
                }
            }
        }

    }

    private void draw(){

        if(ourHolder.getSurface().isValid()){

            //lock firstly the aera of memory we will be drawing to
            canvas=ourHolder.lockCanvas();


            //last frame with arbitrary color
            paint.setColor(Color.argb(255,0,0,255));
            canvas.drawColor(Color.argb(255,0,0,255));

            //Draw all the gameObjects
            Rect toScreen2d = new Rect();

            //Draw a layer at a time
            for(int layer=-1;layer<=1;layer++){
                for (GameObject go:lm.gameObjects){
                    if(go.isVisible() && go.getWordLocation().z == layer){

                        toScreen2d.set(vp.worldToScreen(go.getWordLocation().x,go.getWordLocation().y,go.getWidth()
                        ,go.getHeight()));

                        //Draw the appropriate bitmap
                        //canvas.drawBitmap(lm.bitmapsArray[lm.getBitmapIndex(go.getType())],toScreen2d.left,toScreen2d.top,paint);
                        canvas.drawBitmap(lm.bitmapsArray[lm.getBitmapIndex(go.getType())], toScreen2d.left, toScreen2d.top, paint);
                    }
                }

            }

            if(debugging){
                paint.setTextSize(16);
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setColor(Color.argb(255,255,255,255));
                canvas.drawText("fps:"+fps,10,60,paint);

                canvas.drawText("num objects"+lm.gameObjects.size(),10,80,paint);

                canvas.drawText("num clipped:"+vp.getNumClipped(),10,100,paint);

                canvas.drawText("playerX:"+lm.gameObjects.get(lm.playerIndex).getWordLocation().x,10,120,paint);

                canvas.drawText("playerY:"+lm.gameObjects.get(lm.playerIndex).getWordLocation().y,10,140,paint);

                canvas.drawText("Gravity:"+lm.gravity,10,160,paint);

                canvas.drawText("X velocity:"+lm.gameObjects.get(lm.playerIndex).getxVelocity(),10,180,paint);

                canvas.drawText("Y velocity:"+lm.gameObjects.get(lm.playerIndex).getyVelocity(),10,200,paint);

                //resetnumber of clipped objects foe each frame
                vp.resetNumClipped();
            }//end if(debugging


            //Unlock and draw the scene
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    //Clean up our thread if the game is interrupted
    public void pause(){
        running = false;

        try{
            gameThread.join();
        }catch (InterruptedException ie){
            Log.e("error","failed to pause thread");
        }

    }

    public void resume(){
        running=true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}
