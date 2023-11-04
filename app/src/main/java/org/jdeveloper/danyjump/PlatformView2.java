package org.jdeveloper.danyjump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class PlatformView2 extends SurfaceView implements Runnable {

    private boolean debugging = true;
    private volatile boolean running;
    private Thread gameThread = null;

    // For drawing
    private Paint paint;

    // Canvas could initially be local.
    // But later we will use it outside of the draw() method
    private Canvas canvas;
    private SurfaceHolder ourHolder;


    Context context;

    // Our new engine classes
    private LevelManager lm;
    private Viewport vp;
    InputController ic;
    SoundManager sm;
    private PlayerState ps;

    long startFrameTime;
    long timeThisFrame;
    long fps;

    /*private int hitByBulletSlineFrontEnemy = 3;
    private int hitByBulletScorpionAttackEnemy=5;*/

    private int hitByBulletSlineFrontEnemy=2;
    private int hitByBulletGhostEnemy=2;

    private int hitByBulletDroneOrange=2;
    private int hitByBulletRatEnemy=2;
    private int hitByBulletvampireEnemy=2;
    private int hitByBulletBdRagomGreenEnemy=2;
    private int hitByBulletDroneGreen=2;
    private int hitByBulletGorilleEnemy=2;
    private int hitByBulletDroneBleuSoldier=2;

    private int hitByBulletDroneRouge=3;
    private int hitByBulletDroneBlack=3;
    private int hitByBulletScorpionAttackEnemy=3;

    private int hitByBulletDroneYellow=4;
    private int hitByBulletDroneMarron=4;
    private int hitByBulletTomatoRedEnemy=4;
    private int hitByBulletEnemyDrone=8;


    private int numberOfBullet=0;

    PlatformView2(Context context, int screenWidth, int screenHeight) {
        super(context);
        this.context = context;

        // Initialize our drawing objects
        ourHolder = getHolder();
        paint = new Paint();

        // Initialize the viewport
        vp = new Viewport(screenWidth, screenHeight);

        sm = new SoundManager();
        sm.loadSound(context);


        ps=new PlayerState();

        //sm.playdefaultSound();

        //loadLevel("LevelCave", 10, 2);
        loadLevel("LevelII", 10, 2);
        //loadLevel("LevelII", 10, 2);

        //loadLevel("LevelIII", 10, 2);

       //loadLevel("LevelIV", 10 , 2);

        //loadLevel("LevelV", 10 , 2);
        //loadLevel("LevelVI", 10 , 2);

        //loadLevel("LevelVII", 10 , 2);

        //loadLevel("LevelVII", 3 , 40);

       //loadLevel("LevelVII", 207 , 37);

        //loadLevel("LevelVII", 793 , 41);

       //loadLevel("LevelVII", 987 , 41);
        //loadLevel("LevelVII", 416 , 30);

        //loadLevel("LevelVII", 200 , 30);
      // loadLevel("LevelVII",53,23);

        //loadLevel("LevelVII",391,14);
        //loadLevel("LevelVII",764,19);

        //loadLevel("LevelVII",3,40);
        //loadLevel("LevelVIII",10,2);

       // loadLevel("LevelVIII",10,35);

        //loadLevel("LevelVIII",206,43);

       //loadLevel("LevelVIII",226,36);

        //loadLevel("LevelVIII",260,36);

        //loadLevel("LevelVIII",403,41);

       // loadLevel("LevelVIII",648,45);

       //loadLevel("LevelVIII",786,43);

        //loadLevel("LevelVIII",919,35);

        //loadLevel("LevelVIII",776,29);

        //loadLevel("LevelVIII",634,30);

       //loadLevel("LevelVIII",550,27);

        //loadLevel("LevelVIII",388,26);

       // loadLevel("LevelVIII",245,26);

        //loadLevel("LevelVIII",183,25);

        //loadLevel("LevelVIII",32,25);

        //loadLevel("LevelVIII",229,10);

       // loadLevel("LevelIX", 60, 14);

        //loadLevel("LevelIX", 88, 43);

        //loadLevel("LevelIX", 85, 28);

        //loadLevel("LevelIX", 196, 20);

       //loadLevel("LevelIX", 482, 39);

        //loadLevel("LevelIX", 413, 22);

        //loadLevel("LevelIX", 411, 13);

        //loadLevel("LevelIX", 505, 11);

       //loadLevel("LevelIX", 516, 24);

        //loadLevel("LevelIX", 697, 26);

        //loadLevel("LevelIX", 846, 20);

        //loadLevel("LevelIX", 747, 32);

        //loadLevel("LevelIX", 898, 36);

       // loadLevel("LevelX", 4 ,38);

        //loadLevel("LevelX", 128,34);

        //loadLevel("LevelX", 144,44);

       //loadLevel("LevelX", 346,38);

        //loadLevel("LevelX", 423,41);

       // loadLevel("LevelX", 472,41);

        //loadLevel("LevelX", 723,41);

        //loadLevel("LevelX", 861,44);

        //loadLevel("LevelX", 957,39);

        //loadLevel("LevelX", 890,32);

        //loadLevel("LevelX", 795,32);

       // loadLevel("LevelX", 725,29);

       //loadLevel("LevelX", 561,29);

        //loadLevel("LevelX", 293,29);

        //loadLevel("LevelX", 317,27);

        //loadLevel("LevelX", 20,14);

        //loadLevel("LevelX", 194,12);

        //loadLevel("LevelX", 322,15);

        //loadLevel("LevelX", 572,16);

        //loadLevel("LevelMain",10, 2);


        /*

        Ÿ =^ = Jaune
        ℧ = A = Marron
        μ = - = Rouge
        ( = 8 = Noir
        ɚ = + = BulletEnenmy
        | = B =DroneBleu
        θ = δ= DroeGreen
        D= # = DroneOrange
        *
        * */



    }

    public void
    loadLevel(String level, float px, float py) {
        // Make the LevelManager null
        // As this method can be called at any time
        // Including when LevelManager is not null.
        lm = null;

        // Create a new LevelManager
        // Passing in a Context, screen details, level name and player location
        lm = new LevelManager(context, vp.getPixelsPerMetreX(), vp.getScreenWidth(), ic, level, px, py);
        ic = new InputController(vp.getScreenWidth(), vp.getScreenHeight());

        PointF location=new PointF(px,py);
        ps.saveLocation(location);

        //set the players location as the world centre of the viewport
        vp.setWorldCentre(lm.gameObjects.get(lm.playerIndex)
                        .getWorldLocation().x,
                lm.gameObjects.get(lm.playerIndex)
                        .getWorldLocation().y);


        //sm.playdefaultSound();

    }

    @Override
    public void run() {

        while (running) {
            startFrameTime = System.currentTimeMillis();

            update();

            draw();

            // Calculate the fps this frame
            // We can then use the result to
            // time animations and more.
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame >= 1) {
                fps = 1000 / timeThisFrame;
            }


        }
    }

    private void update() {

        for (GameObject go : lm.gameObjects) {


            if (go.isActive()) {

                //sm.playdefaultSound();
                // Clip anything off-screen
                if (!vp.clipObjects(go.getWorldLocation().x, go.getWorldLocation().y, go.getWidth(), go.getHeight())) {

                    //sm.playdefaultSound();

                    // Set visible flag to true
                    go.setVisible(true);

                    // check collisions with player
                    int hit = lm.player.checkCollisions(go.getHitbox());

                    //if (hit > 0) {
                    if (hit !=0){
                        //collision! Now deal with different types

                        switch (go.getType()) {

                            case 'c'://Coin
                                sm.playSound("coin_pickup");
                                go.setActive(false);
                                go.setVisible(false);
                                ps.gotCredit();

                                //restore state that was removed by collision detection
                                if(hit!=2){
                                    lm.player.restorePreviousVelocity();
                                }

                                break;

                            case 'u'://Gun upgrade
                                sm.playSound("gun_upgrade");
                                go.setActive(false);
                                go.setVisible(false);
                                lm.player.bfg.upgradeRateOfFire();
                                ps.increaseFireRate();

                                if(hit!=2){
                                    lm.player.restorePreviousVelocity();
                                }

                                break;


                            case 'e':
                                //extralife
                                go.setActive(false);
                                go.setVisible(false);
                                sm.playSound("extra_life");
                                ps.addLife();

                                if (hit !=2){
                                    lm.player.restorePreviousVelocity();
                                }

                                break;

                            case 'd':
                                PointF location;
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case 'D':
                                PointF playerLocation;
                                sm.playSound("player_burn");
                                ps.loseLife();
                                playerLocation=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(playerLocation.x);
                                lm.player.setWorldLocationY(playerLocation.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 'g':
                                //Hit by guard
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 'f':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 't':
                                Teleport teleport=(Teleport)go;
                                Location t=teleport.getTarget();
                                loadLevel(t.level,t.x,t.y);;
                                sm.playSound("teleport");
                                break;

                            case 'b':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);

                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-20);
                                lm.player.setWorldLocationY(location.y);
                                /*lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);*/

                                lm.player.setxVelocity(0);
                                break;

                            case 'h':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                //lm.player.setWorldLocationY(location.y + 60);
                                lm.player.setWorldLocationY(lm.player.getWorldLocation().y+60);
                                //lm.player.setWorldLocationX(lm.player.getWorldLocation().x - 100);
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x - 20);
                                lm.player.setxVelocity(0);
                                break;


                            case 'j':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                //lm.player.setWorldLocationY(location.y + 60);
                                lm.player.setWorldLocationY(lm.player.getWorldLocation().y+60);
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x - 100);
                                lm.player.setxVelocity(0);
                                break;


                            case 'o':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                lm.player.setxVelocity(0);
                                break;

                            case 'k':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                lm.player.setxVelocity(0);
                                break;

                            case 'n':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-200);
                                lm.player.setxVelocity(0);
                                break;

                            case 'V':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                //lm.player.setWorldLocationX(lm.player.getWorldLocation().x-200);
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-50);
                                lm.player.setxVelocity(0);
                                break;

                            case 'K': //trouver cle
                                go.setActive(false);
                                go.setVisible(false);
                                sm.playSound("key_find");
                                break;

                            case '@':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-300);
                                lm.player.setxVelocity(0);
                                break;


                            case 'y':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case 'O':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationX(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case 'L':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationX(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case 'M':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationX(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 'a':

                                if (hit ==2){
                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);

                                }else /*if(hit ==1)*/{

                                    ps.loseLife();
                                    sm.playSound("player_burn");

                                    if (lm.player.getFacing() ==-1){
                                        lm.player.setWorldLocationX(lm.player.getWorldLocation().x+50);
                                    }else{

                                        lm.player.setWorldLocationX(lm.player.getWorldLocation().x-50);
                                    }

                                    /*ps.loseLife();
                                    sm.playSound("player_burn");

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-50);*/
                                    lm.player.setxVelocity(0);
                                }

                                break;

                            case 'm':

                                if (hit == 2){
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x+35);

                            }
                            break;

                            case 'R':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationX(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 'H':

                                if(hit ==2){
                                    go.setWorldLocation(-100, -100, 0);
                                }
                                break;


                            case 'T':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-300);
                                lm.player.setxVelocity(0);
                                break;

                            case 'G':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationX(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 'I':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                lm.player.setxVelocity(0);

                                break;


                            case 'U':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                lm.player.setxVelocity(0);
                                break;

                            case '-':
                                if(hit ==3){

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);

                                }

                                break;

                            case '$':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationX(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 'Γ':

                                //lm.player.setWorldLocationY(lm.player.getWorldLocation().y+30);

                                if (hit == 2){

                                    lm.player.setWorldLocationY(lm.player.getWorldLocation().y-10);
                                    //lm.player.setWorldLocationX(lm.player.getWorldLocation().x+30);

                                }
                                break;

                            case 'θ':
                                //Hit by DroneGreen
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case '*':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                if(lm.player.getFacing() ==-1){

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x+100);
                                }else{

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                }
                                //lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                lm.player.setxVelocity(0);


                                break;



                            case 'π':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                lm.player.setWorldLocationX(lm.player.getWorldLocation().x-20);
                                lm.player.setWorldLocationY(lm.player.getWorldLocation().y-10);
                                lm.player.setxVelocity(0);

                                break;

                            case 'Ψ':
                                if (hit ==2){

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);

                                }else{

                                    ps.loseLife();
                                    sm.playSound("player_burn");
                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-20);
                                    lm.player.setxVelocity(0);

                                }

                                break;

                             case 'Ω':

                                 if (hit ==2){

                                     lm.player.setWorldLocationX(go.getWorldLocation().x);

                                 }

                                break;


                            case 'η':

                                sm.playSound("player_burn");
                                ps.loseLife();

                                if(lm.player.getFacing() ==-1){

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x+100);
                                }else{

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                }

                                lm.player.setxVelocity(0);

                                break;


                            case 'ξ':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                /*lm.player.setWorldLocationX(lm.player.getWorldLocation().x-20);
                                lm.player.setWorldLocationY(lm.player.getWorldLocation().y-10);
                                lm.player.setxVelocity(0);*/

                                location = new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case 'Σ':

                                sm.playSound("player_burn");
                                ps.loseLife();

                                if(lm.player.getFacing() ==-1){

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x+50);
                                    lm.player.setWorldLocationY(lm.player.getWorldLocation().y+10);

                                }else{

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-50);
                                    lm.player.setWorldLocationY(lm.player.getWorldLocation().y-10);

                                }

                                lm.player.setxVelocity(0);



                                break;

                            case 'μ':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);

                                break;

                            case '|':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case '(':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case '<':


                                sm.playSound("player_burn");
                                ps.loseLife();

                                if(lm.player.getFacing() ==-1){

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x+50);

                                }else{

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-50);

                                }

                                break;


                            case '>'://>:FireSPritePurpleEnemy

                                sm.playSound("player_burn");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case '«'://>:FireSPriteGreenEnemy

                                sm.playSound("player_burn");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case '†'://DogEnemyMarron
                                sm.playSound("player_burn");
                                ps.loseLife();
                                if(lm.player.getFacing() ==-1){

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x+50);

                                }else{

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-50);

                                }
                                lm.player.setxVelocity(0);
                                break;

                            case '¥':

                                if (hit == 2){
                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-40);
                                    lm.player.setWorldLocationY(lm.player.getWorldLocation().y+5);

                                }
                                break;

                            case 'Û':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case'Ÿ':
                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;


                            case '℧':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);

                                break;

                            case 'ϑ':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                if(lm.player.getFacing() ==-1){

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x+45);

                                }else{

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-45);

                                }
                                lm.player.setxVelocity(0);

                                break;

                            case 'ϰ':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                if(lm.player.getFacing() ==-1){

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x+100);
                                }else{

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                }
                                //lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                lm.player.setxVelocity(0);


                                break;

                            case 'Ђ':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                if(lm.player.getFacing() ==-1){

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x+100);
                                }else{

                                    lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                }
                                //lm.player.setWorldLocationX(lm.player.getWorldLocation().x-100);
                                lm.player.setxVelocity(0);


                                break;


                            case 'ϱ':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);


                                break;

                            case 'ɚ':

                                sm.playSound("player_burn");
                                ps.loseLife();
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);

                                break;

                            case 'Ѓ':

                                if (hit == 2){

                                    if(lm.player.getFacing() ==-1){

                                        go.setWorldLocationY(go.getWorldLocation().y + 1);
                                        go.setWorldLocationY(go.getWorldLocation().y - 1);
                                        lm.player.setWorldLocationY(lm.player.getWorldLocation().y-5);
                                        lm.player.setWorldLocationX(lm.player.getWorldLocation().x-7);


                                    }else{

                                        go.setWorldLocationY(go.getWorldLocation().y + 1);
                                        go.setWorldLocationY(go.getWorldLocation().y - 1);
                                        lm.player.setWorldLocationY(lm.player.getWorldLocation().y-5);
                                        lm.player.setWorldLocationX(lm.player.getWorldLocation().x+7);


                                    }



                                }
                                break;







                            default:// Probably a regular tile
                                /*lm.player.setxVelocity(0);
                                lm.player.setPressingRight(false);*/
                               /* if (hit == 1) {// Left or right
                                    /*lm.player.setxVelocity(0);
                                    lm.player.setPressingRight(false);*/

                                  /*  switch (go.getType()){

                                        case 'a':
                                            ps.loseLife();
                                            sm.playSound("player_burn");
                                            location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                            lm.player.setWorldLocationX(location.x);
                                            lm.player.setWorldLocationX(location.y);
                                            break;
                                    }


                                }*/

                                /*if (hit == 2) {// Feet
                                    lm.player.isFalling = false;

                                    switch (go.getType()){
                                        case 'm':
                                            lm.player.setWorldLocationX(lm.player.getWorldLocation().x+35);
                                            break;

                                        case 'a':
                                            sm.playSound("explode");
                                            go.setWorldLocation(-100, -100, 0);
                                            break;

                                    }

                                }*/


                                break;

                        }
                    }



                    if (hit == 2) {// Feet
                        lm.player.isFalling = false;



                    }








                    //Check bullet collisions
                    for (int i=0;i<lm.player.bfg.getNumBullets();i++) {

                        //Make a hitbox out of the current bullet
                        RectHitbox r = new RectHitbox();
                        r.setLeft(lm.player.bfg.getBulletX(i));
                        r.setTop(lm.player.bfg.getBulletY(i));
                        r.setRight(lm.player.bfg.getBulletX(i) + .1f);
                        r.setBottom(lm.player.bfg.getBulletY(i) + .1f);

                        if (go.getHitbox().intersects(r)) {
                            //Collision detected;hide bullet until a new appear

                            lm.player.bfg.hideBullet(i);

                            //According the type of object we hit
                            if (go.getType() != 'g' && go.getType() != 'd' && go.getType() != 'b' && go.getType() != 'j' && go.getType() != 'o' && go.getType() != 'k' && go.getType()!='n' && go.getType()!='+' && go.getType()!='@' && go.getType()!='O' && go.getType()!='M' && go.getType() !='D' && go.getType()!='a' && go.getType() !='R' && go.getType() !='B' && go.getType()!='I' && go.getType()!='G' && go.getType()!='T' && go.getType()!='*' && go.getType() !='θ' && go.getType() !='η' && go.getType() !='Σ' && go.getType() !='μ' && go.getType() !='|' && go.getType() !='(' && go.getType()!='Ÿ' && go.getType()!='℧' && go.getType()!='ɚ') {//if  it is different of enemy

                                sm.playSound("ricochet");
                            } else if (go.getType() == 'g') {
                                go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i))); //faire reculer le garde patrouillant de 2 pixels environ
                                sm.playSound("hit_guard");
                            } else if (go.getType() == 'd') {
                                //destroy the drone play sound explode
                                sm.playSound("explode");
                                //remove the drone image on viewport
                                go.setWorldLocation(-100, -100, 0);
                            } else if (go.getType() == 'b') {

                                //start by play sound explode
                                sm.playSound("explode");
                                //remove the TomatoEnemy on viewport
                                go.setWorldLocation(-100, -100, 0);

                            } else if (go.getType() == 'j') {



                                numberOfBullet += 1;
                                if (numberOfBullet < hitByBulletSlineFrontEnemy) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");
                                } else {
                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet = 0;

                                }




                            } else if (go.getType() == 'o') {

                                sm.playSound("explode");
                                go.setWorldLocation(-100, -100, 0);

                            } else if (go.getType() == 'k') {

                                sm.playSound("explode");
                                go.setWorldLocation(-100, -100, 0);

                            }else if(go.getType() =='n'){
                                numberOfBullet += 1;
                                if (numberOfBullet < hitByBulletScorpionAttackEnemy) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");
                                } else {
                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet = 0;

                                }
                            }else if (go.getType() =='+'){

                                sm.playSound("explode");
                                go.setWorldLocation(-100,-100,0);

                            }else if (go.getType() =='@'){

                                numberOfBullet += 1;
                                if (numberOfBullet <hitByBulletGhostEnemy){

                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }
                                else{
                                    sm.playSound("explode");
                                    go.setWorldLocation(-100,-100,0);
                                    numberOfBullet=0;


                                }

                            }else if (go.getType() =='O'){

                                sm.playSound("explode");
                                go.setWorldLocation(-100, -100, 0);

                            }

                            else if(go.getType() =='M'){
                                numberOfBullet += 1;
                                if (numberOfBullet < hitByBulletTomatoRedEnemy) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");
                                } else {
                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet = 0;

                                }
                            }

                            else if (go.getType()=='D'){

                                numberOfBullet += 1;
                                if (numberOfBullet < hitByBulletDroneOrange) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");
                                } else {
                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet = 0;

                                }


                            }

                            else if(go.getType() =='a'){
                                //go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i))); //faire reculer le garde patrouillant de 2 pixels environ
                                PointF location;
                                ps.loseLife();
                                //sm.playSound("hit_guard");
                                sm.playSound("player_burn");
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationX(location.y);
                                lm.player.setxVelocity(0);
                            }

                            else if (go.getType() =='R'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletRatEnemy){
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");
                                }else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet = 0;

                                }



                            }

                            else if(go.getType() =='B'){


                                sm.playSound("break_brick");
                                go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                //go.setWorldLocation(go.getWorldLocation().x + 2,go.getWorldLocation().y,0);

                            }

                            else if (go.getType() =='I'){

                                sm.playSound("explode");
                                go.setWorldLocation(-100, -100, 0);

                                /*go.setType('b');
                                TomatoEnemy tomatoEnemy= (TomatoEnemy)go;
                                tomatoEnemy.setVisible(true);
                                tomatoEnemy.setActive(true);*/


                                /*go.setType('b');
                                go.setVisible(true);
                                go.setActive(true);*/
                            } else if (go.getType() =='T'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletvampireEnemy) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }


                            }else if (go.getType() =='G'){

                                PointF location;
                                ps.loseLife();
                                sm.playSound("player_burn");
                                location=new PointF(ps.loadLocation().x,ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationX(location.y);
                                lm.player.setxVelocity(0);

                            }else if(go.getType() == '*'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletBdRagomGreenEnemy) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            } else if (go.getType() == 'θ'){

                                numberOfBullet += 1;
                                if (numberOfBullet < hitByBulletDroneGreen) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");
                                } else {
                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet = 0;

                                }

                            }else if(go.getType() == 'η'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletBdRagomGreenEnemy) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            }else if(go.getType() == 'Σ'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletGorilleEnemy) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            }else if(go.getType() == 'μ'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletDroneRouge) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            }else if(go.getType() == '|'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletDroneBleuSoldier) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            }else if(go.getType() == '('){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletDroneBlack) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            }else if (go.getType() == 'Ÿ'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletDroneYellow) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            }else if(go.getType() =='℧'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletDroneMarron) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            }else if(go.getType() =='ɚ'){

                                numberOfBullet +=1;
                                if (numberOfBullet < hitByBulletEnemyDrone) {
                                    go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.bfg.getDirection(i)));
                                    sm.playSound("preliminar_hit");

                                }  else{

                                    sm.playSound("explode");
                                    go.setWorldLocation(-100, -100, 0);
                                    numberOfBullet=0;

                                }

                            }
                        }
                    }

                    if (lm.isPlaying()) {
                        // Run any un-clipped updates
                        go.update(fps, lm.gravity);

                        if (go.getType() =='d'){

                            Drone d =(Drone)go;
                            d.setWaypoint(lm.player.getWorldLocation());

                        }else if(go.getType() =='D'){

                            DroneOrange droneOrange=(DroneOrange)go;
                            droneOrange.setWaypoint(lm.player.getWorldLocation());

                        }else if (go.getType() == 'θ'){

                            DroneGreen droneGreen=(DroneGreen)go;
                            droneGreen.setWaypoint(lm.player.getWorldLocation());


                        }else if(go.getType() =='μ'){

                            DroneRouge droneRouge=(DroneRouge)go;
                            droneRouge.setWaypoint(lm.player.getWorldLocation());

                        }else if(go.getType() =='|'){


                            DroneBleuSoldier droneBleuSoldier=(DroneBleuSoldier)go;
                            droneBleuSoldier.setWaypoint(lm.player.getWorldLocation());

                        }else if(go.getType() =='('){


                            DroneBlack droneBlack=(DroneBlack)go;
                            droneBlack.setWaypoint(lm.player.getWorldLocation());

                        }else if (go.getType() == 'Ÿ'){

                            DroneYellow droneYellow=(DroneYellow)go;
                            droneYellow.setWaypoint(lm.player.getWorldLocation());

                        }else if (go.getType() == '℧'){

                            DroneMarron droneMarron=(DroneMarron)go;
                            droneMarron.setWaypoint(lm.player.getWorldLocation());

                        }else if(go.getType() =='ɚ'){

                            BulletEnemyDrone bulletEnemyDrone=(BulletEnemyDrone)go;
                            bulletEnemyDrone.setWaypoint(lm.player.getWorldLocation());


                        }


                    }

                } else {
                    // Set visible flag to false
                    go.setVisible(false);
                    // Now draw() can ignore them
                }
            }

        }


        if (lm.isPlaying()) {
            //Reset the players location as the world centre of the viewport
            //if game is playing
            vp.setWorldCentre(lm.gameObjects.get(lm.playerIndex)
                            .getWorldLocation().x,
                    lm.gameObjects.get(lm.playerIndex)
                            .getWorldLocation().y);

            //Player fallen out of the map?
            if(lm.player.getWorldLocation().x<0 || lm.player.getWorldLocation().x >lm.mapWidth ||lm.player.getWorldLocation().y >lm.mapHeight){

                sm.playSound("player_burn");;
                ps.loseLife();
                PointF location=new PointF(ps.loadLocation().x,ps.loadLocation().y);

                lm.player.setWorldLocationX(location.x);
                lm.player.setWorldLocationY(location.y);
                lm.player.setxVelocity(0);

                //is over the game ?
                if (ps.getLives() ==0){
                    ps=new PlayerState();
                    loadLevel("LevelI",1,15);
                }


            }
        }




    }//end  update method

    private void draw() {

        if (ourHolder.getSurface().isValid()) {
            //First we lock the area of memory we will be drawing to
            canvas = ourHolder.lockCanvas();

            // Rub out the last frame with arbitrary color
            paint.setColor(Color.argb(255, 0, 0, 255));
            canvas.drawColor(Color.argb(255, 0, 0, 255));

            //Draw parallax backgrounds from-1 to -3
            drawBackground(0,-3);

            // Draw all the GameObjects
            Rect toScreen2d = new Rect();

            // Draw a layer at a time
            for (int layer = -1; layer <= 1; layer++) {

                for (GameObject go : lm.gameObjects) {
                    if (go.isVisible() && go.getWorldLocation().z == layer) { //Only draw if visible and this layer

                        toScreen2d.set(vp.worldToScreen
                                (go.getWorldLocation().x,
                                        go.getWorldLocation().y,
                                        go.getWidth(),
                                        go.getHeight()));

                        if (go.isAnimated()) {
                            // Get the next frame of the bitmap
                            // Rotate if necessary
                            if (go.getFacing() == 1) {
                                // Rotate
                                // We could pre-compute this during load level
                                Matrix flipper = new Matrix();
                                flipper.preScale(-1, 1);
                                Rect r = go.getRectToDraw(System.currentTimeMillis());
                                Bitmap b = Bitmap.createBitmap(lm.bitmapsArray[lm.getBitmapIndex(go.getType())],
                                        r.left,
                                        r.top,
                                        r.width(),
                                        r.height(),
                                        flipper,
                                        true);

                                canvas.drawBitmap(b,
                                        toScreen2d.left,
                                        toScreen2d.top, paint);

                            } else {

                                // draw it the regular way round
                                canvas.drawBitmap(lm.bitmapsArray[lm.getBitmapIndex(go.getType())],
                                        go.getRectToDraw(System.currentTimeMillis()),
                                        toScreen2d, paint);
                            }


                        } else { // Just draw the whole bitmap
                            canvas.drawBitmap(lm.bitmapsArray[lm.getBitmapIndex(go.getType())],
                                    toScreen2d.left,
                                    toScreen2d.top, paint);
                        }
                    }
                }
            }

            //draw the bullet
            //paint.setColor(Color.argb(255,255,255,255));
            paint.setColor(Color.argb(255,255,0,0));
            for (int i=0;i<lm.player.bfg.getNumBullets();i++){
                toScreen2d.set(vp.worldToScreen(lm.player.bfg.getBulletX(i),lm.player.bfg.getBulletY(i),.25f,.10f)); //.25 and .05 are the width and height of bullet
                canvas.drawRect(toScreen2d,paint);
            }

            //draw Bullet SbotEnemy
            /*paint.setColor(Color.argb(255,255,255,255));
            for (int i=0;i<lm.sbotEnemy.bfg.getNumBullets();i++){
                toScreen2d.set(vp.worldToScreen(lm.sbotEnemy.bfg.getBulletX(i),lm.sbotEnemy.bfg.getBulletY(i),.25f,.15f));
            }*/


            //draw Bullet Canon
            /*paint.setColor(Color.argb(255,255,255,255));
            for (int i=0;i<lm.canon.machineGunCanon.getNumBullets();i++){
                toScreen2d.set(vp.worldToScreen(lm.canon.machineGunCanon.getBulletX(i),lm.canon.machineGunCanon.getBulletY(i),.25f,.25f));
            }*/



            //Draw parallax backgrounds from -1 to -3
            drawBackground(4,0);

            // Text for debugging
            if (debugging) {
                paint.setTextSize(16);
                paint.setTextAlign(Paint.Align.LEFT);
                //paint.setColor(Color.argb(255, 255, 255, 255));
                paint.setColor(Color.argb(255, 25, 25, 112));
                canvas.drawText("fps:" + fps, 10, 60, paint);
                canvas.drawText("num objects:" + lm.gameObjects.size(), 10, 80, paint);
                canvas.drawText("num clipped:" + vp.getNumClipped(), 10, 100, paint);
                canvas.drawText("playerX:" + lm.gameObjects.get(lm.playerIndex).getWorldLocation().x, 10, 120, paint);
                canvas.drawText("playerY:" + lm.gameObjects.get(lm.playerIndex).getWorldLocation().y, 10, 140, paint);

                canvas.drawText("Gravity:" + lm.gravity, 10, 160, paint);
                canvas.drawText("X velocity:" + lm.gameObjects.get(lm.playerIndex).getxVelocity(), 10, 180, paint);
                canvas.drawText("Y velocity:" + lm.gameObjects.get(lm.playerIndex).getyVelocity(), 10, 200, paint);

                //for reset the number of clipped objects each frame
                vp.resetNumClipped();

            }

            //draw buttons
            //paint.setColor(Color.argb(80, 255, 255, 255));
            paint.setColor(Color.argb(100, 25, 25, 112));
            ArrayList<Rect> buttonsToDraw;
            buttonsToDraw = ic.getButtons();

            for (Rect rect : buttonsToDraw) {
                RectF rf = new RectF(rect.left, rect.top, rect.right, rect.bottom);
                canvas.drawRoundRect(rf, 15f, 15f, paint);
            }

            //draw paused text
            if (!this.lm.isPlaying()) {
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setColor(Color.argb(255, 255, 255, 255));

                paint.setTextSize(120);
                canvas.drawText("Paused", vp.getScreenWidth() / 2, vp.getScreenHeight() / 2, paint);

            }

            // Unlock and draw the scene
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (lm != null) {
            ic.handleInput(motionEvent, lm, sm, vp);
        }
        //invalidate();
        return true;
    }

    // Clean up our thread if the game is interrupted or the player quits
    public void pause() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("error", "failed to pause thread");
        }
    }

    // Make a new thread and start it
    // Execution moves to our run method
    public void resume() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void drawBackground(int start, int stop) {

        Rect fromRect1 = new Rect();
        Rect toRect1 = new Rect();
        Rect fromRect2 = new Rect();
        Rect toRect2 = new Rect();

        for (Background bg : lm.backgrounds) {

            if (bg.z < start && bg.z > stop) {
                // Is this layer in the viewport?
                // Clip anything off-screen
                if (!vp.clipObjects(-1, bg.y, 1000, bg.height)) {

                    float floatstartY = ((vp.getyCentre() - ((vp.getViewportWorldCentreY() - bg.y) * vp.getPixelsPerMetreY())));
                    int startY = (int) floatstartY;

                    float floatendY = ((vp.getyCentre() - ((vp.getViewportWorldCentreY() - bg.endY) * vp.getPixelsPerMetreY())));
                    int endY = (int) floatendY;

                    //define what portion of bitmaps to capture and what coordinates to draw them at
                    fromRect1 = new Rect(0, 0, bg.width - bg.xClip, bg.height);
                    toRect1 = new Rect(bg.xClip, startY, bg.width, endY);

                    fromRect2 = new Rect(bg.width - bg.xClip, 0, bg.width, bg.height);
                    toRect2 = new Rect(0, startY, bg.xClip, endY);
                }

                //draw backgrounds
                if (!bg.reversedFirst) {

                    canvas.drawBitmap(bg.bitmap, fromRect1, toRect1, paint);
                    canvas.drawBitmap(bg.bitmapReversed, fromRect2, toRect2, paint);
                } else {
                    canvas.drawBitmap(bg.bitmap, fromRect2, toRect2, paint);
                    canvas.drawBitmap(bg.bitmapReversed, fromRect1, toRect1, paint);
                }


                bg.xClip -= lm.player.getxVelocity() / (20 / bg.speed);
                if (bg.xClip >= bg.width) {
                    bg.xClip = 0;
                    bg.reversedFirst = !bg.reversedFirst;
                } else if (bg.xClip <= 0) {
                    bg.xClip = bg.width;
                    bg.reversedFirst = !bg.reversedFirst;

                }
            }
        }
    }

}// End of PlatformView
