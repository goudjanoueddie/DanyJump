package org.jdeveloper.danyjump;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class OwnDialogFragment extends DialogFragment {


    public OwnDialogFragment(){

        //Empty constructor is required

    }

    public static  OwnDialogFragment newInstance(String title){

        OwnDialogFragment fragment=new OwnDialogFragment();
        Bundle arguments=new Bundle();
        arguments.putString("title",title);
        fragment.setArguments(arguments);
        return fragment;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstances){

        String title=getArguments().getString("title");
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage("Do you want to Leave");

        //alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //on Success

               //MenuActivity.class.finish();

                MenuActivity.activity.CloseApp();





            }
        });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (dialog != null ) {
                    dialog.dismiss();
                }


            }
        });



        return alertDialogBuilder.create();
    }




}
