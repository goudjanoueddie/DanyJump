package org.jdeveloper.danyjump;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends Activity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

         imageView=(ImageView)findViewById(R.id.imageCube);
        //imageView.setRotation(imageView.getRotation() +90);

        final Button buttonInstructions=(Button)findViewById(R.id.btnInstructions);
        //buttonInstructions.setOnClickListener(btinstructions());

    }

    /*@Override
    public void run() {

        try {
            while (true) {
                imageView.setRotation(imageView.getRotation() +90);
            }
        } finally {
            //System.out.println("Fin demon");
        }



    }*/

    public void btnClick(View v){

    }

    public void btinstructions(View v){
        Intent i=new Intent(this,InstructionsActivity.class);
        startActivity(i);
        finish();

    }
}
