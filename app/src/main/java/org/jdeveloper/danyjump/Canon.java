package org.jdeveloper.danyjump;

public class Canon extends GameObject {

    public MachineGunCanon machineGunCanon;

    Canon(final float worldStartX, final float worldStartY, char type){
        setTraversable();
        final float HEIGHT=2;
        final float WIDTH=2;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        setBitmapName("canon");
        setWorldLocation(worldStartX,worldStartY,0);
        setRectHitbox();

        machineGunCanon=new MachineGunCanon();

        final Runnable task=new Runnable() {
            @Override
            public void run() {
                machineGunCanon.shoot(worldStartX,worldStartY,getHeight());
            }
        };

        /*final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);*/


    }


    public void update(long fps,float gravity){

        machineGunCanon.update(fps,gravity);

    }
}
