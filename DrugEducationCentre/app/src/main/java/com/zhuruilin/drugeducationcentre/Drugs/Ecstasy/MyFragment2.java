package com.zhuruilin.drugeducationcentre.Drugs.Ecstasy;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zhuruilin.drugeducationcentre.R;
import android.util.Log;

public class MyFragment2 extends Fragment {
    private String title,description;

    public MyFragment2(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        //先提取ScrollView
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.ecstasy_scroll_view);

        TextView txt_content = (TextView) view.findViewById(R.id.txt_title);
        TextView txt_description = (TextView) view.findViewById(R.id.text_under_title);
        txt_content.setText(title);
        txt_description.setText(description);
        Log.e("HEHE", "++");
        return view;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void addDescription(){

    }
}
