package org.jdeveloper.danyjump;

import android.content.Context;

public class Fire extends GameObject {

    Fire(Context context, float worldStartX, float worldStartY, char type, int pixelsPerMetre){
        final int ANIMATION_FPS=3;
        final int ANIMATION_FRAME_COUNT=3;
        final String BITMAP_NAME="fire";

        final float HEIGHT=1;
        final float WIDTh=1;

        setHeight(HEIGHT);
        setWidth(WIDTh);
        setType(type);
        setMoves(false);
        setActive(true);
        setVisible(true);

        //put a bitmap
        setBitmapName(BITMAP_NAME);
        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setBitmapName(BITMAP_NAME);
        setAnimated(context,pixelsPerMetre,true);
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();

    }

    public void update(long fps, float gravity) {

    }
}

