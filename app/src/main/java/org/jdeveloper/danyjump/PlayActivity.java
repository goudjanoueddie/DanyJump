package org.jdeveloper.danyjump;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class PlayActivity extends Activity {

    private  Button[] buttons=null;
    private LevelManager levelManager=new LevelManager();
    private static  String valueinstring=null;

    public static String currentLevel="1";

    //private Button buttonLevelII;
  public static Button buttonLevelII=null;
    public static Button buttonLevelIII=null;

  //private static PlayActivity playActivity;
    private static  PlayActivity playActivity=new PlayActivity();

  public PlayActivity(){


  }

  public static PlayActivity getPlayActivity(){

      return playActivity;
  }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        final Button buttonLevelI=(Button)findViewById(R.id.btnlevel1);
        buttonLevelII=(Button)findViewById(R.id.btnlevel2);
        //this.buttonLevelII=buttonLevelII;
        buttonLevelIII=(Button)findViewById(R.id.btnlevel3);

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstance){

        super.onSaveInstanceState(savedInstance);
        savedInstance.putString("myCurrentString",currentLevel);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstance){

      super.onRestoreInstanceState(savedInstance);

      String myCurrentLevel=savedInstance.getString("myCurrentString");

        switch(myCurrentLevel){

                case "2":
                    buttonLevelII.setEnabled(true);
                break;
        }

    }


    public void btnlevel1Click(View v){


        Intent i=new Intent(this,PlatformActivity.class);
        startActivity(i);
        //buttonLevelII.setEnabled(true);
        //finish();

        /*
        final Button buttonLevelII=(Button)findViewById(R.id.btnlevel2);*/
       // buttonLevelII.setEnabled(true);




    }


    public void btnlevel2Click(View v){

        //LevelII levelII=new LevelII();
        Intent i=new Intent(this,PlatformActivity2.class);
        startActivity(i);

        //finish();



    }


    public void buttongobackClick(View v){

        Intent i=new Intent(this,MenuActivity.class);
        startActivity(i);

        finish();
    }

    public Button getButtonLevelII(){

       //buttonLevelII=(Button)findViewById(R.id.btnlevel2);
      //buttonLevelII=new Button(getApplicationContext());
      return buttonLevelII;
    }


    @Override
    protected void onPause(){

      super.onPause();

    }

}//end PlayActivity class
