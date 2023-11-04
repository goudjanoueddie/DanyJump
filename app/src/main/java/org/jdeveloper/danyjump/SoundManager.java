package org.jdeveloper.danyjump;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
//import android.media.Music;
import android.util.Log;

import java.io.IOException;

public class SoundManager {

    private SoundPool soundPool;
    int shoot = -1;
    int jump = -1;
    int teleport = -1;
    int coin_pickup = -1;
    int gun_upgrade = -1;
    int player_burn = -1;
    int ricochet = -1;
    int hit_guard = -1;
    int explode = -1;
    int extra_life = -1;
    int blip_select = -1;
    int danyjumpmain=-1;
    int key_find=-1;
    int break_brick=-1;

    public void loadSound(Context context){
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        try{
            //Create objects of the 2 required classes
            AssetManager assetManager = context.getAssets();
            AssetFileDescriptor descriptor;

            //create our fx
            descriptor = assetManager.openFd("shoot.ogg");
            shoot = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("jump.ogg");
            jump = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("teleport.ogg");
            teleport = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("coin_pickup.ogg");
            coin_pickup = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("gun_upgrade.ogg");
            gun_upgrade = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("player_burn.ogg");
            player_burn = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("ricochet.ogg");
            ricochet = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("hit_guard.ogg");
            hit_guard = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("explode.ogg");
            explode = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("extra_life.ogg");
            extra_life = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("blip_select.ogg");
            blip_select=soundPool.load(descriptor,0);

            descriptor = assetManager.openFd("danyjumpsound.ogg");
            danyjumpmain=soundPool.load(descriptor,0);

            descriptor=assetManager.openFd("key-find.ogg");
            key_find=soundPool.load(descriptor,0);

            descriptor=assetManager.openFd("brickbreak.ogg");
            break_brick=soundPool.load(descriptor,0);





        }catch(IOException e){
            //Print an error message to the console
            Log.e("error", "failed to load sound files");
        }/*finally {
            playdefaultSound();
        }*/
    }

    public void playSound(String sound){
        switch (sound){
            case "shoot":
                soundPool.play(shoot, 1, 1, 0, 0, 1);
                break;

            case "jump":
                soundPool.play(jump, 1, 1, 0, 0, 1);
                break;

            case "teleport":
                soundPool.play(teleport, 1, 1, 0, 0, 1);
                break;

            case "coin_pickup":
                soundPool.play(coin_pickup, 1, 1, 0, 0, 1);
                break;

            case "gun_upgrade":
                soundPool.play(gun_upgrade, 1, 1, 0, 0, 1);
                break;

            case "player_burn":
                soundPool.play(player_burn, 1, 1, 0, 0, 1);
                break;

            case "ricochet":
                soundPool.play(ricochet, 1, 1, 0, 0, 1);
                break;

            case "hit_guard":
                soundPool.play(hit_guard, 1, 1, 0, 0, 1);
                break;

            case "explode":
                soundPool.play(explode, 1, 1, 0, 0, 1);
                break;

            case "extra_life":
                soundPool.play(extra_life, 1, 1, 0, 0, 1);
                break;

            case "preliminar_hit":
                soundPool.play(blip_select,1,1,0,0,1);
                break;

            case "key_find":
                soundPool.play(key_find,1,1,0,0,1);
                break;

            case"break_brick":
                soundPool.play(break_brick,1,1,0,0,1);
                break;

            /*default:
                soundPool.play(danyjumpmain,1,1,0,0,1);
                break;*/


        }

    }

    public void playdefaultSound(){


        soundPool.play(danyjumpmain,1,1,0,0,1);


    }
}
