package org.jdeveloper.danyjump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.ArrayList;

public class LevelManager {

    private String level;
    int mapWidth;
    int mapHeight;

    Player player;
    int playerIndex;

    SbotEnemy sbotEnemy;
    int sbotIndex;

    Canon canon;
    int canonIndex;

    private boolean playing;
    float gravity;

    LevelData levelData;
    ArrayList<GameObject> gameObjects;

    ArrayList<Rect> currentButtons;
    Bitmap[] bitmapsArray;

    ArrayList<Background> backgrounds;

    public LevelManager(Context context, int pixelsPerMetre, int screenWidth, InputController ic, String level, float px, float py) {
        this.level = level;

        switch (level) {
            case "LevelCave":
                levelData = new LevelCave();
                break;

            case "LevelI":
                levelData = new LevelI();
                break;

            case "LevelII":
                levelData = new LevelII();
                break;

            case "LevelIII":
                levelData=new LevelIII();
                break;

            case "LevelIV":
                levelData=new LevelIV();
                break;

            case "LevelV":
                levelData=new LevelV();
                break;


            case "LevelVI":
                levelData=new LevelVI();
                break;

            case "LevelVII":
                levelData=new LevelVII();
                break;





            /*case "LevelVII":
                levelData=new LevelVII();
                break;*/


            // We can add extra levels here

        }

        // To hold all our GameObjects
        gameObjects = new ArrayList<>();

        // To hold 1 of every Bitmap
        bitmapsArray = new Bitmap[100];

        // Load all the GameObjects and Bitmaps
        loadMapData(context, pixelsPerMetre, px, py);

        //Load background
        loadBackgrounds(context,pixelsPerMetre,screenWidth);


        //handle  the guard patrol
        setWaypoints();
        //playing = true;
    }

    public void switchPlayingStatus() {
        playing = !playing;
        if (playing) {
            gravity = 6;
        } else {
            gravity = 0;
        }
    }


    public boolean isPlaying() {
        return playing;
    }


    // Each index Corresponds to a bitmap
    public Bitmap getBitmap(char blockType) {

        int index;
        switch (blockType) {
            case '.':
                index = 0;
                break;

            case '1'://turf
                index = 1;
                break;

            case 'p'://player
                index = 2;
                break;

            case 'c'://coin
                index=3;
                break;

            case 'u':
                index=4;
                break;

            case 'e':
                index=5;
                break;


            case 'd':
                index=6;
                break;

            case 'g':
                index=7;
                break;

            case 'f':
                index=8;
                break;

            case '2':
                index=9;
                break;

            case '3':
                index=10;
                break;

            case '4':
                index=11;
                break;

            case '5':
                index=12;
                break;

            case '6':
                index=13;
                break;

            case '7':
                index=14;
                break;

            case '8':
                index=15;
                break;

            case 'w':
                index=16;
                break;

            case 'x':
                index=17;
                break;

            case 'l':
                index=18;
                break;

            case 'r':
                index=19;
                break;

            case 's':
                index=20;
                break;

            case 'm':
                index=21;
                break;

            case 'z':
                index =22;
                break;

            case 't':
                index=23;
                break;

            case 'a':
                index=24;
                break;

            case 'b':
                index=25;
                break;

            case 'h':
                index=26;
                break;

            case 'i':
                index=27;
                break;

            case 'j':
                index=28;
                break;

            case 'k':
                index=29;
                break;

            case 'n':
                index=30;
                break;

            case 'o':
                index=31;
                break;

            case 'q':
                index=32;
                break;

            case '9':
                index=33;
                break;

            case 'v':
                index =34;
                break;

            case 'y':
                index=35;
                break;

            case '+':
                index=36;
                break;

            case '@':
                index=37;
                break;

            case 'C':
                index=38;
                break;

            case 'V':
                index=39;
                break;

            case 'Y':
                index=40;
                break;

            case 'B':
                index=41;
                break;

            case 'K':
                index=42;
                break;

            case 'F':
                index=43;
                break;

            case 'O':
                index=44;
                break;

            case 'L':
                index=45;
                break;

            case 'M':
                index=46;
                break;

            case 'A':
                index=47;
                break;

            case 'P':
                index=48;
                break;

            case 'W':
                index=49;
                break;

            case 'D':
                index=50;
                break;

            case 'R':
                index=51;
                break;

            case 'G':
                index=52;
                break;

            case 'T':
                index=53;
                break;

            case 'H':
                index=54;
                break;

            case 'J':
                index=55;
                break;

            case 'Q':
                index=56;
                break;

            case 'N':
                index=57;
                break;

            case 'E':
                index=58;
                break;

            case '#':
                index=59;
                break;

            case 'I':
                index=60;
                break;

            case '%':
                index=61;
                break;

            case 'S':
                index=62;
                break;

            case 'U':
                index=63;
                break;

            case '&':
                index=64;
                break;

            case '-':
                index=65;
                break;

            case '*':
                index=66;
                break;

            case '!':
                index=67;
                break;

            case '$':
                index=68;
                break;

            case'/':
                index=69;
                break;


            case 'ß':
                index=70;
                break;

            case 'Γ':
                index=71;
                break;

            case 'θ':
                index=72;
                break;

            case 'π':
                index=73;
                break;

            case 'ξ':
                index=74;
                break;

            case 'α':
                index = 75;
                break;

            case 'δ':
                index=76;
                break;

            case '^':
                index=77;
                break;

            case 'φ':
                index=78;
                break;

            case'?':
                index=79;
                break;

            case 'Ⲁ':
                index=80;
                break;

            case 'Φ':
                index=81;
                break;


            case 'Ψ':
                index=82;
                break;

            case 'Ω':
                index=83;
                break;

            case 'η':
                index=84;
                break;

            case 'λ':
                index=85;
                break;



            default:
                index = 0;
                break;
        }

        return bitmapsArray[index];
    }

    // This method allows each GameObject which 'knows'
    // its type to get the correct index to its Bitmap
    // in the Bitmap array.
    public int getBitmapIndex(char blockType) {

        int index;
        switch (blockType) {
            case '.':
                index = 0;
                break;

            case '1':
                index = 1;
                break;

            case 'p':
                index = 2;
                break;


            case 'c':
                index=3;
                break;

            case 'u':
                index=4;
                break;

            case 'e':
                index=5;
                break;

            case 'd':
                index=6;
                break;

            case 'g':
                index=7;
                break;

            case 'f':
                index=8;
                break;

            case '2':
                index=9;
                break;


            case '3':
                index=10;
                break;

            case '4':
                index=11;
                break;

            case '5':
                index=12;
                break;

            case '6':
                index=13;
                break;

            case '7':
                index=14;
                break;

            case '8':
                index=15;
                break;


            case 'w':
                index=16;
                break;

            case 'x':
                index=17;
                break;

            case 'l':
                index=18;
                break;

            case 'r':
                index=19;
                break;

            case 's':
                index=20;
                break;

            case 'm':
                index=21;
                break;

            case 'z':
                index =22;
                break;


            case 't':
                index=23;
                break;


            case 'a'   :
                index=24;
                break;

            case 'b':
                index=25;
                break;

            case 'h':
                index=26;
                break;


            case 'i':
                index=27;
                break;

            case 'j':
                index=28;
                break;


            case 'k':
                index=29;
                break;


            case 'n':
                index=30;
                break;

            case 'o':
                index=31;
                break;

            case 'q':
                index=32;
                break;


            case '9':
                index=33;
                break;


            case 'v':
                index =34;
                break;


            case 'y':
                index=35;
                break;


            case '+':
                index=36;
                break;


            case '@':
                index=37;
                break;

            case 'C':
                index=38;
                break;

            case 'V':
                index=39;
                break;

            case 'Y':
                index=40;
                break;

            case 'B':
                index=41;
                break;


            case 'K':
                index=42;
                break;

            case 'F':
                index=43;
                break;

            case 'O':
                index=44;
                break;


            case 'L':
                index=45;
                break;

            case 'M':
                index=46;
                break;

            case 'A':
                index=47;
                break;

            case 'P':
                index=48;
                break;

            case 'W':
                index=49;
                break;


            case 'D':
                index=50;
                break;


            case 'R':
                index=51;
                break;

            case 'G':
                index=52;
                break;

            case 'T':
                index=53;
                break;

            case 'H':
                index=54;
                break;

            case 'J':
                index=55;
                break;

            case 'Q':
                index=56;
                break;

            case 'N':
                index=57;
                break;

            case 'E':
                index=58;
                break;

            case '#':
                index=59;
                break;

            case 'I':
                index=60;
                break;

            case '%':
                index=61;
                break;

            case 'S':
                index=62;
                break;


            case 'U':
                index=63;
                break;

            case '&':
                index=64;
                break;

            case'-':
                index=65;
                break;

            case '*':
                index=66;
                break;


            case '!':
                index=67;
                break;

            case '$':
                index=68;
                break;

            case'/':
                index=69;
                break;

            case 'ß':
                index=70;
                break;

            case 'Γ':
                index=71;
                break;

            case 'θ':
                index=72;
                break;

            case 'π':
                index=73;
                break;

            case 'ξ':
                index=74;
                break;


            case 'α':
                index = 75;
                break;

            case 'δ':
                index=76;
                break;

            case '^':
                index=77;
                break;

            case 'φ':
                index=78;
                break;

            case'?':
                index=79;
                break;

            case 'Ⲁ':
                index=80;
                break;

            case 'Φ':
                index=81;
                break;

            case 'Ψ':
                index=82;
                break;

            case 'Ω':
                index=83;
                break;

            case 'η':
                index=84;
                break;

            case 'λ':
                index=85;
                break;




            default:
                index = 0;
                break;
        }

        return index;
    }

    // For now we just load all the grass tiles
    // and the player. Soon we will have many GameObjects
    void loadMapData(Context context, int pixelsPerMetre, float px, float py) {

        char c;

        //Keep track of where we load our game objects
        int currentIndex = -1;
        int teleportIndex=-1;
        int sbotEnemyIndex=-1;
        int canonIndex=-1;

        // how wide and high is the map? Viewport needs to know
        mapHeight = levelData.tiles.size();
        mapWidth = levelData.tiles.get(0).length();

        for (int i = 0; i < levelData.tiles.size(); i++) {
            for (int j = 0; j < levelData.tiles.get(i).length(); j++) {

                c = levelData.tiles.get(i).charAt(j);
                if (c != '.') {// Don't want to load the empty spaces
                    currentIndex++;
                    //sbotEnemyIndex++;
                    switch (c) {

                        case '1':
                            // Add a tile to the gameObjects
                            gameObjects.add(new Grass(j, i, c));
                            break;

                        case 'p':// a player
                            // Add a player to the gameObjects
                            gameObjects.add(new Player
                                    (context, px, py, pixelsPerMetre));

                            // We want the index of the player
                            playerIndex = currentIndex;
                            // We want a reference to the player object
                            player = (Player) gameObjects.get(playerIndex);

                            break;

                        case 'c'://add coin
                            gameObjects.add(new Coin(j,i,c));
                            break;

                        case 'u'://add machine gun
                            gameObjects.add(new MachineUpgrade(j,i,c));
                            break;

                        case 'e'://Add an extra life to the gameObjects
                            gameObjects.add(new ExtraLife(j,i,c));
                            break;

                        case 'd'://add the drone
                            gameObjects.add(new Drone(j,i,c));
                            break;

                        case 'g':
                            //Add guard
                            gameObjects.add(new Guard(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'f'://Add fire to gameobjects
                            gameObjects.add(new Fire(context,j,i,c,pixelsPerMetre));
                            break;

                        case '2':
                            gameObjects.add(new Snow(j,i,c));
                            break;

                        case '3':
                            gameObjects.add(new Brick(j,i,c));
                            break;

                        case '4':
                            gameObjects.add(new Coal(j,i,c));
                            break;

                        case '5':
                            gameObjects.add(new Concrete(j,i,c));
                            break;

                        case '6':
                            gameObjects.add(new Scorched(j,i,c));
                            break;

                        case '7':
                            gameObjects.add(new Stone(j,i,c));
                            break;

                        case '8':
                            gameObjects.add(new DarkBrick(j,i,c));
                            break;

                        case 'w':
                            gameObjects.add(new Tree(j,i,c));
                            break;

                        case 'x':
                            gameObjects.add(new Tree2(j,i,c));
                            break;

                        case 'l':
                            gameObjects.add(new Lampost(j,i,c));
                            break;

                        case'r':
                            gameObjects.add(new Stalactite(j,i,c));
                            break;

                        case 's':
                            gameObjects.add(new Stalagmite(j,i,c));
                            break;

                        case 'm':
                            gameObjects.add(new Cart(j,i,c));
                            break;

                        case 'z':
                            gameObjects.add(new Boulders(j,i,c));
                            break;

                        case 't':
                            //Add a teleport to the gameObjects
                            teleportIndex++;
                            gameObjects.add(new Teleport(j,i,c,levelData.locations.get(teleportIndex)));
                            break;

                        case 'a':
                            gameObjects.add(new TortueEnemy(j,i,c));
                            break;

                        case 'b':
                            gameObjects.add(new TomatoEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'h':
                            gameObjects.add(new GuardBlackEnemy(context,j,i,c,pixelsPerMetre));
                            break;


                        case 'i':
                            gameObjects.add(new TreeGreen(j,i,c));
                            break;

                        case 'j':
                            gameObjects.add(new SlineFrontEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'k':

                           // sbotEnemyIndex++;
                            gameObjects.add(new SbotEnemy(context,j,i,c,pixelsPerMetre));
                            // We want the index of the sbotEnemy
                            /*sbotIndex = sbotEnemyIndex;
                            sbotEnemy = (SbotEnemy) gameObjects.get(sbotIndex);*/
                            break;


                        case 'n':
                            gameObjects.add(new ScorpionAttackEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'o':
                            gameObjects.add(new ZombieEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'q':
                            gameObjects.add(new CoconutTree(j,i,c));
                            break;

                        case '9':
                            gameObjects.add(new WhiteBrick(j,i,c));
                            break;

                        case 'v':
                            gameObjects.add(new BlueBrick(j,i,c));
                            break;

                        case 'y':
                            gameObjects.add(new CampFireEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case '+':
                            gameObjects.add(new LegoBrick(j,i,c));
                            break;

                        case '@':
                            gameObjects.add(new GhostEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'C':
                            gameObjects.add(new Canon(j,i,c));

                            /*// We want the index of the canon
                            canonIndex ++;
                            // We want a reference to the Canon object
                            canon = (Canon) gameObjects.get(canonIndex);*/
                            break;

                        case 'V':
                            gameObjects.add(new VenemeuseEnemy(j,i,c));
                            break;

                        case 'Y':
                            gameObjects.add(new YellowBrick(j,i,c));
                            break;

                        case 'B':
                            gameObjects.add(new BreakBrick(j,i,c));
                            break;

                        case 'K':
                            gameObjects.add(new KeyToOpenDoor(j,i,c));
                            break;

                        case 'F':
                            gameObjects.add(new ForestTree(j,i,c));
                            break;

                        case 'O':
                            gameObjects.add(new BirdsEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'L':
                            gameObjects.add(new TomatoYellowEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'M':
                            gameObjects.add(new TomatoRedEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'A':
                            gameObjects.add(new MarronBrick(j,i,c));
                            break;

                        case 'P':
                            gameObjects.add(new PieuvreBrick(j,i,c));
                            break;

                        case 'W':
                            gameObjects.add(new WhiteBrick2(j,i,c));
                            break;

                        case 'D':
                            gameObjects.add(new DroneOrange(j,i,c));
                            break;

                        case 'R':
                            gameObjects.add(new RatEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'G':
                            gameObjects.add(new GnobotsEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'T':
                            gameObjects.add(new VampireEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'H':
                            gameObjects.add(new Horizontal1(j,i,c));
                            break;

                        case 'J':
                            gameObjects.add(new BananaTree(j,i,c));
                            break;


                        case 'Q':
                            gameObjects.add(new CoconutOrangeTree(j,i,c));
                            break;

                        case 'N':
                            gameObjects.add(new NoelBrick(j,i,c));
                            break;

                        case 'E':
                            gameObjects.add(new FullWhiteBrick(j,i,c));
                            break;

                        case '#':
                            gameObjects.add(new OrangeBrick(j,i,c));
                            break;

                        case 'I':
                            gameObjects.add(new BlobEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case '%':
                            gameObjects.add(new CoconutGreen(j,i,c));
                            break;

                        case 'S':
                            gameObjects.add(new ChauveSourisEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'U':
                            gameObjects.add(new ClouBottom(j,i,c));
                            break;

                        case '&':
                            gameObjects.add(new BrickParis(j,i,c));
                            break;

                        case '-':
                            gameObjects.add(new RedBrick(j,i,c));
                            break;

                        case '*':
                            gameObjects.add(new BdRagomGreenEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case '!':
                            gameObjects.add(new TreeRed(j,i,c));
                            break;

                        case '$':
                            gameObjects.add(new CrowmanEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case'/':
                            gameObjects.add(new TreeBlack(j,i,c));
                            break;

                        case 'ß':
                            gameObjects.add(new TreeBlack2(j,i,c));
                            break;

                        case 'Γ':
                            gameObjects.add(new Helicoptere(j,i,c));
                            break;

                        case 'θ':
                            gameObjects.add(new DroneGreen(j,i,c));
                            break;

                        case 'π':
                            gameObjects.add( new FireSpriteRedEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'ξ':
                            gameObjects.add(new FireSpriteBlueEnemy(context,j,i,c,pixelsPerMetre));
                            break;


                        case 'α':
                            gameObjects.add(new GreenBrick(j,i,c));
                            break;

                        case 'δ':
                            gameObjects.add(new GreenBrickFonce(j,i,c));
                            break;

                        case '^':
                            gameObjects.add( new BrickJaune(j,i,c));
                            break;

                        case 'φ':
                            gameObjects.add(new BrickSolar(j,i,c));
                            break;

                        case'?':
                            gameObjects.add(new ForestTree2(j,i,c));
                            break;

                        case 'Ⲁ':
                            gameObjects.add(new TreeX3(j,i,c));
                            break;

                        case 'Φ':
                            gameObjects.add(new CoconutBlackTree(j,i,c));
                            break;

                        case 'Ψ':
                            gameObjects.add(new ChickenEnemy(context,j,i,c,pixelsPerMetre));
                            break;

                        case 'Ω':
                            gameObjects.add(new Horizontal(context,j,i,c,pixelsPerMetre));
                            break;


                        case 'η':
                             gameObjects.add(new BdRagomBlueEnemy(context,j,i,c,pixelsPerMetre));
                             break;

                        case 'λ':
                            gameObjects.add(new VerticalBarreBlack(context,j,i,c,pixelsPerMetre));
                            break;








                    }

                    // If the bitmap isn't prepared yet
                    if (bitmapsArray[getBitmapIndex(c)] == null) {
                        // Prepare it now and put it in the bitmapsArrayList
                        bitmapsArray[getBitmapIndex(c)] =
                                gameObjects.get(currentIndex).
                                        prepareBitmap(context,
                                                gameObjects.get(currentIndex).
                                                        getBitmapName(),
                                                pixelsPerMetre);

                    }
                }
            }
        }
    }//end loadMapData

    public void setWaypoints(){

        //Loop through game object to find Guards
        for (GameObject guard:this.gameObjects){

            if (guard.getType()=='g'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<5;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-5).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<5;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +5).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            Guard g=(Guard) guard;
                            g.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if guard
//*******************************************************************************************************************************************************************************************************************************

            if (guard.getType() =='b'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    if (tile.getWorldLocation().y == guard.getWorldLocation().y+2){

                        if (tile.getWorldLocation().x == guard.getWorldLocation().x){

                            for (int i=0;i<4;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1=gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{

                                    waypointX1=gameObjects.get(startTileIndex - 4 ).getWorldLocation().x;
                                }
                            }//end get left waypoint



                            for (int i=0;i<4;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            TomatoEnemy tomatoEnemy=(TomatoEnemy)guard;
                            tomatoEnemy.setWaypoints(waypointX1,waypointX2);

                        }
                    }
                }

            }//end if TomatoEnemy

//*************************************************************************************************************************************************************************************************************************

            if (guard.getType() =='h'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    if (tile.getWorldLocation().y == guard.getWorldLocation().y+2){

                        if (tile.getWorldLocation().x == guard.getWorldLocation().x){

                            for (int i=0;i<4;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1=gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{

                                    waypointX1=gameObjects.get(startTileIndex - 4 ).getWorldLocation().x;
                                }
                            }//end get left waypoint



                            for (int i=0;i<4;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            GuardBlackEnemy guardBlackEnemy=(GuardBlackEnemy)guard;
                            guardBlackEnemy.setWaypoints(waypointX1,waypointX2);

                        }
                    }
                }

            }//end if TomatoEnemy

            //****************************************************************************************************************************************************************************************


            if (guard.getType() =='j'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    if (tile.getWorldLocation().y == guard.getWorldLocation().y+2){

                        if (tile.getWorldLocation().x == guard.getWorldLocation().x){

                            for (int i=0;i<4;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1=gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{

                                    waypointX1=gameObjects.get(startTileIndex - 4 ).getWorldLocation().x;
                                }
                            }//end get left waypoint



                            for (int i=0;i<4;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            SlineFrontEnemy slineFrontEnemy=(SlineFrontEnemy)guard;
                            slineFrontEnemy.setWaypoints(waypointX1,waypointX2);

                        }
                    }
                }

            }//end if SlineFrontEnemy

      //*************************************************************************************************************************************************************************************************

            if (guard.getType() =='k'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    if (tile.getWorldLocation().y == guard.getWorldLocation().y+2){

                        if (tile.getWorldLocation().x == guard.getWorldLocation().x){

                            for (int i=0;i<5;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1=gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{

                                    waypointX1=gameObjects.get(startTileIndex - 5 ).getWorldLocation().x;
                                }
                            }//end get left waypoint



                            for (int i=0;i<5;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +5).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            SbotEnemy sbotEnemy=(SbotEnemy)guard;
                            sbotEnemy.setWaypoints(waypointX1,waypointX2);

                        }
                    }
                }

            }//End if SbotEnemy


   //***********************************************************************************************************************************************************************************************


            if (guard.getType() =='n'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    if (tile.getWorldLocation().y == guard.getWorldLocation().y+2){

                        if (tile.getWorldLocation().x == guard.getWorldLocation().x){

                            for (int i=0;i<8;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1=gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{

                                    waypointX1=gameObjects.get(startTileIndex - 8 ).getWorldLocation().x;
                                }
                            }//end get left waypoint



                            for (int i=0;i<8;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +8).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            ScorpionAttackEnemy scorpionAttackEnemy=(ScorpionAttackEnemy)guard;
                            scorpionAttackEnemy.setWaypoints(waypointX1,waypointX2);

                        }
                    }
                }

            }//End if scorpionAttackEnemy

            //***********************************************************************************************************************************************************************************************


            if (guard.getType() =='o'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    if (tile.getWorldLocation().y == guard.getWorldLocation().y+2){

                        if (tile.getWorldLocation().x == guard.getWorldLocation().x){

                            for (int i=0;i<6;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1=gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{

                                    waypointX1=gameObjects.get(startTileIndex - 6 ).getWorldLocation().x;
                                }
                            }//end get left waypoint



                            for (int i=0;i<6;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex + 6).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            ZombieEnemy zombieEnemy=(ZombieEnemy)guard;
                            zombieEnemy.setWaypoints(waypointX1,waypointX2);

                        }
                    }
                }

            }//end if zombie


//*****************************************************************************************************************************************************************************************************

            if (guard.getType()=='y'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<10;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-10).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<11;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +10).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            CampFireEnemy campFire=(CampFireEnemy) guard;
                            campFire.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if Camp fire Enemy

//********************************************************************************************************************************************************************************************************


            if (guard.getType()=='@'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<10;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-10).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<10;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +10).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            GhostEnemy ghostEnemy=(GhostEnemy) guard;
                            ghostEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if Ghost Enemy

//******************************************************************************************************************************************************************************************************************************


            if (guard.getType()=='O'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<3;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-3).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<3;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +3).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            BirdsEnemy birdsEnemy=(BirdsEnemy) guard;
                            birdsEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }


 //***************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='L'){


                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<14;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-14).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<14;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +14).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            TomatoYellowEnemy tomatoYellowEnemy=(TomatoYellowEnemy) guard;
                            tomatoYellowEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if YellowRedEnemy



//*******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='M'){


                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<14;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-14).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<14;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +14).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            TomatoRedEnemy tomatoRedEnemy=(TomatoRedEnemy) guard;
                            tomatoRedEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }

//*******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='R'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<4;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-4).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<4;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            RatEnemy g=(RatEnemy) guard;
                            g.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if RatEnemy


//******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='G'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<14;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-14).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<4;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +14).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            GnobotsEnemy g=(GnobotsEnemy) guard;
                            g.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if GnobotsEnemy
        //******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='T'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<4;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-4).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<4;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            VampireEnemy  g=(VampireEnemy) guard;
                            g.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if VampireEnemy

//******************************************************************************************************************************************************************************************************************************************************


            if (guard.getType()=='I'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<5;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-5).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<5;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +5).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            BlobEnemy  g=(BlobEnemy) guard;
                            g.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if BlobEnemy

//******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='S'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<5;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-5).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<5;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +5).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            ChauveSourisEnemy chauveSourisEnemy=(ChauveSourisEnemy) guard;
                            chauveSourisEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if chauveSourisEnemy

//******************************************************************************************************************************************************************************************************************************************************


            if (guard.getType()=='*'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<8;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-8).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<8;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +8).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            BdRagomGreenEnemy bdRagomGreenEnemy=(BdRagomGreenEnemy) guard;
                            bdRagomGreenEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if bdRagomGreenEnemy

//******************************************************************************************************************************************************************************************************************************************************


            if (guard.getType()=='$'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<13;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-13).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<13;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +13).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            CrowmanEnemy crowmanEnemy=(CrowmanEnemy) guard;
                            crowmanEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if bdRagomGreenEnemy
// ******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='π'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    if (tile.getWorldLocation().y == guard.getWorldLocation().y+3){

                        for (int i=0;i<4;i++){
                            if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                //set the high waypoint
                                waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().y-3;
                                break;
                            }else{
                                waypointX1=gameObjects.get(startTileIndex-4).getWorldLocation().y-3;
                            }
                        }//end get left waypoint


                        for (int i=0;i<4;i++){//right for loop
                            if(!gameObjects.get(startTileIndex + i).isTraversable()){

                                waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().y+1;
                                break;//leave right for loop
                            }else{
                                waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().y+1;
                            }

                        }//end get right waypoint

                        FireSpriteRedEnemy fireSpriteRedEnemy=(FireSpriteRedEnemy) guard;
                        fireSpriteRedEnemy.setWaypoints(waypointX1,waypointX2);

                    }


                }

            }//end if FireSpriteRedEnemy
// ******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='Ψ'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<4;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-4).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<5;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            ChickenEnemy chickenEnemy=(ChickenEnemy) guard;
                            chickenEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if ChickenEnemy
//******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='Ω'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    //if (tile.getWorldLocation().x == guard.getWorldLocation().x + 3){
                    if (tile.getWorldLocation().x == guard.getWorldLocation().x ){

                            for (int i=0;i<4;i++){
                                if (gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x-4;
                                    break;
                                }else{

                                    waypointX1=gameObjects.get(startTileIndex-4).getWorldLocation().x-4;
                                    //break;
                                }
                            }//end get left waypoint


                            for (int i=0;i<4;i++){//right for loop
                                if(gameObjects.get(startTileIndex + i).isTraversable()){

                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x+4;
                                    break;//leave right for loop
                                }else{

                                    waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().x+4;

                                    //break;
                                }

                            }//end get right waypoint


                            Horizontal horizontal=(Horizontal) guard;
                            horizontal.setWaypoints(waypointX1,waypointX2);

                        }



                }

            }//end if HorizontalBarre

        //******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='ξ'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                    if (tile.getWorldLocation().y == guard.getWorldLocation().y+3){

                        for (int i=0;i<4;i++){
                            if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                //set the high waypoint
                                waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().y-3;
                                break;
                            }else{
                                waypointX1=gameObjects.get(startTileIndex-4).getWorldLocation().y-3;
                            }
                        }//end get left waypoint


                        for (int i=0;i<4;i++){//right for loop
                            if(!gameObjects.get(startTileIndex + i).isTraversable()){

                                waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().y+1;
                                break;//leave right for loop
                            }else{
                                waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().y+1;
                            }

                        }//end get right waypoint

                        FireSpriteBlueEnemy fireSpriteBlueEnemy=(FireSpriteBlueEnemy) guard;
                        fireSpriteBlueEnemy.setWaypoints(waypointX1,waypointX2);

                    }


                }

            }

//******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='η'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y +2){

                        if (tile.getWorldLocation().x ==guard.getWorldLocation().x){

                            for (int i=0;i<8;i++){
                                if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                    //set the left waypoint
                                    waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().x;
                                    break;
                                }else{
                                    waypointX1=gameObjects.get(startTileIndex-8).getWorldLocation().x;
                                }
                            }//end get left waypoint


                            for (int i=0;i<8;i++){//right for loop
                                if(!gameObjects.get(startTileIndex + i).isTraversable()){
                                    waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().x;
                                    break;//leave right for loop
                                }else{
                                    waypointX2 = gameObjects.get(startTileIndex +8).getWorldLocation().x;
                                }

                            }//end get right waypoint

                            BdRagomBlueEnemy bdRagomBlueEnemy=(BdRagomBlueEnemy) guard;
                            bdRagomBlueEnemy.setWaypoints(waypointX1,waypointX2);

                        }

                    }

                }

            }//end if bdRagomBlueEnemy



//*******************************************************************************************************************************************************************************************************************************************************

            if (guard.getType()=='λ'){

                int startTileIndex=-1;
                int startGuardIndex=0;
                float waypointX1=-1;
                float waypointX2=-1;

                for (GameObject tile:this.gameObjects){
                    startTileIndex++;

                  // if (tile.getWorldLocation().y == guard.getWorldLocation().y+3){
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y){

                        for (int i=0;i<4;i++){
                            if (!gameObjects.get(startTileIndex-i).isTraversable()){

                                //set the high waypoint
                                waypointX1 =gameObjects.get(startTileIndex-(i+1)).getWorldLocation().y-6;
                                break;
                            }else{
                                waypointX1=gameObjects.get(startTileIndex-4).getWorldLocation().y-6;
                            }
                        }//end get left waypoint


                        for (int i=0;i<4;i++){//right for loop
                            if(!gameObjects.get(startTileIndex + i).isTraversable()){

                                waypointX2=gameObjects.get(startTileIndex+(i-1)).getWorldLocation().y+6;
                                break;//leave right for loop
                            }else{
                                waypointX2 = gameObjects.get(startTileIndex +4).getWorldLocation().y+6;
                            }

                        }//end get right waypoint

                        VerticalBarreBlack verticalBarreBlack=(VerticalBarreBlack) guard;
                        verticalBarreBlack.setWaypoints(waypointX1,waypointX2);

                    }


                }

            }

//*******************************************************************************************************************************************************************************************************************************************************


        }//end for
    }//End set waypoints method

    private void loadBackgrounds(Context context,int pixelsPerMetre,int screenWidth){

        backgrounds=new ArrayList<Background>();
        for (BackgroundData bgData:levelData.backgroundataList){

            backgrounds.add(new Background(context,pixelsPerMetre,screenWidth,bgData));

           // backgrounds.add(new Background(context,bgData));
        }
    }


}
