package org.jdeveloper.danyjump;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ButtonAdapter extends BaseAdapter {

    private final Context mContext;
    private final Button[] buttons;


    public ButtonAdapter(Context context,Button[] buttons){

        this.mContext=context;
        this.buttons=buttons;
    }

    @Override
    public int getCount(){
        return buttons.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        TextView dummytextView=new TextView(mContext);
        dummytextView.setText(String.valueOf(position));
        return dummytextView;



    }



}
