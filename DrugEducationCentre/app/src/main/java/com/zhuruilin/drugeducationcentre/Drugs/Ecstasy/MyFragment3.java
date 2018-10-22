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
import android.text.SpannableStringBuilder;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.StyleSpan;
import android.text.Html;

public class MyFragment3 extends Fragment {
    private String title;

    public MyFragment3(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content3,container,false);

        TextView txt_content = (TextView) view.findViewById(R.id.fg3_content3);
        txt_content.setText(addContent());

        txt_content = (TextView)view.findViewById(R.id.fg3_content4);
        txt_content.setText(Html.fromHtml(addContent4()));

        Log.e("HEHE", "++");

        txt_content = (TextView) view.findViewById(R.id.fg3_content5);
        txt_content.setText(addContent5());
        return view;
    }

    public String addContent5(){
        String text = "It is dangerous to drive after using ecstasy. The effects of ecstasy, such as over-confidence and poor muscle control, can affect driving ability. " +
                "People with over-confidence may take more risks when driving which increases the chances of an accident.";

        return text;
    }

    public String addContent4(){

        String text= "<p><font size = 2.7 >Giving up ecstasy after using it for a long time is challenging because the body has to get used to functioning without it. " +
                "Withdrawal symptoms should settle down after a week and will mostly disappear after a month. Symptoms include:</font></p>";

        text += "&#9785;" + " Cravings for ecstasy <br/>" +
                "&#9785;" + " Aches and pains<br/>" +
                "&#9785;" + " Exhaustion <br/>" +
                "&#9785;" + " Restless sleep <br/>" +
                "&#9785;" + " Agitation <br/>" +
                "&#9785;" +  " Trouble concentrating <br/>" +
                "&#9785;" +  " Anxiety and depression";
        //" &#8226;"


//        SpannableStringBuilder spannableString = new SpannableStringBuilder();
//        spannableString.append("Giving up ecstasy after using it for a long time is challenging because the body has to get used to functioning without it. " +
//                "Withdrawal symptoms should settle down after a week and will mostly disappear after a month. Symptoms include:");

        return text;
    }

    public SpannableStringBuilder addContent(){

        SpannableStringBuilder spannableString = new SpannableStringBuilder();

        spannableString.append("\n" + "Ecstasy + alcohol: increased risk of dehydration and consequently drinking too much water.");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);//粗体
        spannableString.setSpan(styleSpan, 0, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(colorSpan, 0, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.append("\n\n"+ "Ecstasy + ice or speed: increased risk of anxiety and reduced brain functioning due to dopamine depletion." +
                " Enormous strain on the heart and other parts of the body, which can lead to stroke.");
        colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        spannableString.setSpan(styleSpan, 91, 116, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(colorSpan, 91, 116, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.append("\n\n"+"Ecstasy + antidepressants: Drowsiness, clumsiness, restlessness and feeling drunk and dizzy.");
        colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        spannableString.setSpan(styleSpan, 282, 311, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(colorSpan, 282, 311, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;

    }
    public void setTitle(String title){
        this.title = title;
    }

}
