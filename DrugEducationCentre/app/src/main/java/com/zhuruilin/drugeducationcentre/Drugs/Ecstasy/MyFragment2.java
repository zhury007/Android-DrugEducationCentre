package com.zhuruilin.drugeducationcentre.Drugs.Ecstasy;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zhuruilin.drugeducationcentre.R;
import android.util.Log;
import android.widget.TextView.BufferType;

public class MyFragment2 extends Fragment {
    private String title;

    public MyFragment2(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content2,container,false);

        TextView txt_content = (TextView) view.findViewById(R.id.txt_title2);
        txt_content.setText(title);
        txt_content = (TextView) view.findViewById(R.id.txt_description2);
        txt_content.setText("Duration of the Ecstasy?");

        txt_content = (TextView)view.findViewById(R.id.txt3);
        txt_content.setText("The effects of ecstasy are usually felt about 20 minutes to an hour after it’s taken and last for around 6 hours.");





        ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);


        Log.e("HEHE", "++");
        return view;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void addDescription(){

    }
}
