package com.zhuruilin.drugeducationcentre.Drugs.Methamphetamine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhuruilin.drugeducationcentre.R;

public class MethFragment2 extends Fragment {

    public MethFragment2(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meth_content2, container, false);


        TextView txt = (TextView)view.findViewById(R.id.txt_title4);
        txt.setText("The effect of Methamphetamine.");

        txt = (TextView) view.findViewById(R.id.physical_effects);
        txt.setText(addcontent());

        txt = (TextView)view.findViewById(R.id.mental_effects);
        txt.setText(addContent2());


        return view;
    }

    public String addContent2(){
        String txt = "People using methamphetamines (like ice) can experience mental health problems while using the drug or during the 'comedown' or ‘crash’ phase. " +
                "Symptoms usually last a few days to a few weeks. " +
                "For some people mental health problems persist and develop into mental disorders in their own right.";

        return txt;
    }


    public String addcontent(){
        String txt = "The initial effects of ice often last for between 4 and 12 hours depending on how much ice is consumed. " +
                "Although the effects of ice are usually felt quickly (within minutes if it is smoked or injected, " +
                "or about 30 minutes if snorted or swallowed), " +
                "it can take 1 to 2 days to entirely leave the body.";

        return txt;
    }
}
