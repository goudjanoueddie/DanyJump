package org.jdeveloper.danyjump;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

//public class LevelMain extends LevelData {

public class LevelMain extends Activity {

    //PlayActivity playActivity=new PlayActivity();

    LevelMain(){

        //PlayActivity playActivity=new PlayActivity();
        Intent i = new Intent(this, PlayActivity.class);
        startActivity(i);
        finish();
        //setContentView(R.layout.activity_play);

    }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_play);


        }

}
