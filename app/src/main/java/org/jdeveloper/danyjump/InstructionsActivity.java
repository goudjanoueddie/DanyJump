package org.jdeveloper.danyjump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstructionsActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        final Button buttonGoBack=(Button)findViewById(R.id.buttongoback);

        buttonGoBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){

        Intent i=new Intent(this,MenuActivity.class);
        startActivity(i);
        finish();

    }


}
