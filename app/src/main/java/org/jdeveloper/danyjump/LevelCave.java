package org.jdeveloper.danyjump;

import java.util.ArrayList;

public class LevelCave extends LevelData {
    LevelCave() {
        tiles = new ArrayList<String>();
        this.tiles.add("..........p..............................................................................................................................................................................................................................");
        this.tiles.add(".........................................................................................................................................................................................................................................");
        this.tiles.add(".........................................................................................................................................................................................................................................");
        this.tiles.add(".........................................................................................................................................................................................................................................");
        this.tiles.add(".........................................................................................................................................................................................................................................");
        this.tiles.add(".........................................................................................................................................................................................................................................");
        this.tiles.add(".........................................................................................................................................................................................................................................");
        this.tiles.add(".........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("8..................................................................88....................................................................................................................................................................");
        this.tiles.add("8................................................................77......................................................................................................................................................................");
        this.tiles.add("8..............................................................66........................................................................................................................................................................");
        this.tiles.add("8.......................................................d....55..........................................................................................t...............................................................................");
        this.tiles.add("8..........................................................44............................................................................................................................................................................");
        this.tiles.add("8...............................c........................33....................w....x...l...r.....s...m.....z............................................................................................................................");
        this.tiles.add("8.............g...............c.c.c....................22................................................................................................................................................................................");
        this.tiles.add("8........................................................................................................................................................................................................................................");
        this.tiles.add("88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888");
        backgroundataList=new ArrayList<BackgroundData>();
        this.backgroundataList.add(new BackgroundData("skyline",true,-1,3,18,10,15));
        this.backgroundataList.add(new BackgroundData("grass",true,1,20,24,24,4));

    }
}


