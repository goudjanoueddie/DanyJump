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

  public static Button buttonLevelII=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        final Button buttonLevelI=(Button)findViewById(R.id.btnlevel1);
         buttonLevelII=(Button)findViewById(R.id.btnlevel2);

        /*GridView gridView=(GridView)findViewById(R.id.gridview);
        ButtonAdapter buttonAdapter=new ButtonAdapter(this,buttons);
        gridView.setAdapter(buttonAdapter);*/



         //valueinstring=levelManager.getCurrentlevelel();

        valueinstring=LevelManager.currentlevelel;

        switch (valueinstring){

            /*case "1":
                buttonLevelI.setEnabled(true);
                break;*/

            case"2":
                buttonLevelII.setEnabled(true);
                break;
        }
    }


    public void btnlevel1Click(View v){


        Intent i=new Intent(this,PlatformActivity.class);
        startActivity(i);
        //buttonLevelII.setEnabled(true);
        finish();

        /*
        final Button buttonLevelII=(Button)findViewById(R.id.btnlevel2);
        buttonLevelII.setEnabled(true);
        */



    }


    public void btnlevel2Click(View v){

        //LevelII levelII=new LevelII();
        Intent i=new Intent(this,PlatformActivity2.class);
        startActivity(i);
        finish();



    }


    public void buttongobackClick(View v){

        Intent i=new Intent(this,MenuActivity.class);
        startActivity(i);
        finish();
    }
}
