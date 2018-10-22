package com.zhuruilin.drugeducationcentre.Drugs.Methamphetamine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.text.style.BackgroundColorSpan;
import com.zhuruilin.drugeducationcentre.R;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;


import org.w3c.dom.Text;

public class MethFragment extends Fragment {

    private String title;
    public MethFragment(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meth_content,container,false);

        TextView txt = (TextView)view.findViewById(R.id.Description2);
        txt.setText(setContent());

        txt = (TextView)view.findViewById(R.id.txt_title2);
        txt.setText("What is Methamphetamine ?");

        //set text for appearance
        txt = (TextView) view.findViewById(R.id.Ice_appearance);
        txt.setText(setIceTxt());
        txt = (TextView) view.findViewById(R.id.base_appearance);
        txt.setText(setBaseTxt());
        txt = (TextView) view.findViewById(R.id.speed_appearance);
        txt.setText(setSpeedTxt());

        //set text for other Name tab
        txt = (TextView)view.findViewById(R.id.Ice_othername);
        txt.setText("Crystal meth, meth, shabu, \ntina, glass.");
        txt = (TextView)view.findViewById(R.id.base_othername);
        txt.setText("Pure, point, wax, meth");
        txt = (TextView)view.findViewById(R.id.speed_othername);
        txt.setText("Goey, meth\n");

        //set text for method tab
        txt = (TextView)view.findViewById(R.id.Ice_method);
        txt.setText("Smoking, injecting.");
        txt = (TextView)view.findViewById(R.id.base_method);
        txt.setText("Swallowing, injecting.");
        txt = (TextView)view.findViewById(R.id.speed_method);
        txt.setText("Snorting, swallowing, injecting.");

        txt = (TextView)view.findViewById(R.id.IcePotency_txt);
        txt.setText(icePotenctTxt());
        txt = (TextView)view.findViewById(R.id.basePotency_txt);
        txt.setText(basePotencTxt());
        txt = (TextView)view.findViewById(R.id.speedPotency_txt);
        txt.setText(speedPotencTxt());


        txt = (TextView)view.findViewById(R.id.details);
        txt.setText(addDetails());


        return view;

    }

    public String addDetails(){
        String txt = "The effects of ice differ slightly from speed and base because it is often a purer form of methamphetamine, meaning it gives a stronger and longer lasting ‘high’." +
                " Because of this, it also has more potent and serious side effects, both during use and in the 'comedown' or ‘crash’ phase after use. " +
                "This is why, compared to other forms of methamphetamine, ice has a greater potential for the user to develop dependence, psychosis," +
                " and other long-term physical and mental health problems.\n" +
                "\n" +
                "Ice is usually sold in points (0.1g) or grams and can be cut (mixed) with other substances. This reduces its purity and makes the effects for the user even more unpredictable.";
        return txt;
    }

    public SpannableStringBuilder speedPotencTxt(){
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(" LOW    MEDIUM ");

        //For LOW
        BackgroundColorSpan bgColorSpan = new BackgroundColorSpan(Color.parseColor("#B6B6B6"));
        spannableStringBuilder.setSpan(bgColorSpan, 0, 5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#353535"));
        spannableStringBuilder.setSpan(colorSpan, 0, 5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        //For MEDIUM
        bgColorSpan = new BackgroundColorSpan(Color.parseColor("#FFC300"));
        spannableStringBuilder.setSpan(bgColorSpan, 7, 15, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(colorSpan, 7, 15, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        return spannableStringBuilder;
    }

    public SpannableStringBuilder basePotencTxt(){
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(" MEDIUM   HIGHT ");
        //For HIGHT
        BackgroundColorSpan bgColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
        spannableStringBuilder.setSpan(bgColorSpan, 10, 16, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        //for MEDIUM
        bgColorSpan = new BackgroundColorSpan(Color.parseColor("#FFC300"));
        spannableStringBuilder.setSpan(bgColorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#353535"));
        spannableStringBuilder.setSpan(colorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spannableStringBuilder;

    }
    public SpannableStringBuilder icePotenctTxt(){
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(" HIGHT ");
        BackgroundColorSpan bgColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
        spannableStringBuilder.setSpan(bgColorSpan, 0, 7, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spannableStringBuilder;
    }
    public String setIceTxt(){
        String txt = "Translucent crystals,\n" +
                "Sometimes shards.";
        return txt;
    }

    public String setBaseTxt(){
        String txt = "Dampish, \"gluugy\"Substance.\n" +
                "Colour varies from white to\nbrown";
        return txt;
    }

    public String setSpeedTxt(){
        String txt ="White or off-white powder.\n";
        return txt;
    }

    public String setContent(){
        String txt = "There are different forms of methamphetamine used illegally in South Australia - the crystal form is known as ‘ice’, " +
                "the powder form is known as ‘speed’ and the paste form is known as ‘base’." +
                " The short and long-term effects of all three forms of methamphetamine are similar, but the intensity of effect may vary depending on the way it is used, the amount taken, " +
                "and its form. " +
                "Crystal methamphetamine ('Ice') has the most intense effects.";

        return txt;
    }
}
