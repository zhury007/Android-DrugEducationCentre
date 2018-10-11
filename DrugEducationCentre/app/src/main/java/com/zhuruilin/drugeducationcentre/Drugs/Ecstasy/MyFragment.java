package com.zhuruilin.drugeducationcentre.Drugs.Ecstasy;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;
import com.zhuruilin.drugeducationcentre.R;
import android.util.Log;



public class MyFragment extends Fragment {
    private String content;

    public MyFragment(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText(content);
        Log.e("HEHE", "如来神掌++");
        return view;
    }

    public void setContent(String content){
        this.content = content;
    }
}
