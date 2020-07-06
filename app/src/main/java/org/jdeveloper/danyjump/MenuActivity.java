package org.jdeveloper.danyjump;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

//import android.support.v4.app.FragmentManager;


public class MenuActivity extends FragmentActivity {

    ImageView imageView;

    public static MenuActivity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity=this;

        setContentView(R.layout.activity_menu);

         imageView=(ImageView)findViewById(R.id.imageCube);
        //imageView.setRotation(imageView.getRotation() +90);

        final Button buttonInstructions=(Button)findViewById(R.id.btnInstructions);
        final Button bttonPlay=(Button)findViewById(R.id.btnplay);
        final Button buttonLeave=(Button)findViewById(R.id.btnquit);
        //buttonInstructions.setOnClickListener(btinstructions());

    }



    public void btnClick(View v){

    }

    public void btinstructions(View v){
        Intent i=new Intent(this,InstructionsActivity.class);
        startActivity(i);
        finish();

    }

    public void btnPlayClick(View v){

        Intent i=new Intent(this,PlatformActivity.class);
        startActivity(i);
        finish();



    }

    public void btnLeaveClick(View v){
        showAlertDialog();
    }

    private void showAlertDialog() {

       /* FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);*/

        //DialogFragment dialogFragment = new FireMissilesDialogFragment();


        /*DialogFragment dialogFragment = new OwnDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"TEST");*/



        FragmentManager fm = getSupportFragmentManager();
        OwnDialogFragment alertDialog = OwnDialogFragment.newInstance("LEAVE DANYJUMP");
        alertDialog.setCancelable(false);
        alertDialog.show(fm, "fragment_alert");
    }


    public static void CloseApp(){
        activity.finish();
    }


}
