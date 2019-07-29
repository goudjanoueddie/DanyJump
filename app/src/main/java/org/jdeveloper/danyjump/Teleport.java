package org.jdeveloper.danyjump;

public class Teleport extends GameObject {

    Location target;

    Teleport(float worldStartX,float worldStartY,char type,Location target){

        final float HEIGHT=4;
        final float WIDTH=4;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        setBitmapName("door");

        this.target=new Location(target.level,target.x,target.y);
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();

    }

    public Location getTarget(){
        return target;
    }

    public void update(long fps, float gravity) {
    }
}
