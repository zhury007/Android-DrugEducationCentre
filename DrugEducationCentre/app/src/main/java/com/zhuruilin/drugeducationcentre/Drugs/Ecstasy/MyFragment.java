package com.zhuruilin.drugeducationcentre.Drugs.Ecstasy;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.zhuruilin.drugeducationcentre.Drugs.DrugPhoto.PhotoPagerAdapter;
import com.zhuruilin.drugeducationcentre.GlideImageLoader;
import com.zhuruilin.drugeducationcentre.R;
import android.util.Log;
import com.zhuruilin.drugeducationcentre.Drugs.DrugPhoto.DrugPhotoFragment;

import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zhuruilin.drugeducationcentre.database.UserInfo;
import java.util.ArrayList;
import java.util.List;


public class MyFragment extends Fragment {
    private String title;
    PhotoPagerAdapter photoPagerAdapter;

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private static Uri resourceIdToUri(String context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context + FOREWARD_SLASH + resourceId);
    }
    public MyFragment(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        //先提取ScrollView
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.ecstasy_scroll_view);
        //--------
        TextView txt_content = (TextView) view.findViewById(R.id.txt_title);
        txt_content.setText(title);
        //---------
        txt_content = (TextView) view.findViewById(R.id.text_under_title);
        txt_content.setText(addDescription());
        //----------
        txt_content = (TextView) view.findViewById(R.id.txt_title2);
        txt_content.setText(addTitle2());

        //-----------
        txt_content = (TextView) view.findViewById(R.id.txt_content2);
        txt_content.setText(addContent2());

        //-----
        txt_content = (TextView) view.findViewById(R.id.txt_title3);
        txt_content.setText("How is ecstasy made?");

        //------
        txt_content = (TextView) view.findViewById(R.id.txt_content3);
        txt_content.setText(addContent3());


        Banner banner = (Banner)view.findViewById(R.id.banner2);
        banner.setImageLoader(new GlideImageLoader());

        List images = new ArrayList();
        List titles = new ArrayList();
        images.add(resourceIdToUri("com.zhuruilin.drugeducationcentre", R.drawable.ecstasy_monogram).toString());
        images.add(resourceIdToUri("com.zhuruilin.drugeducationcentre", R.drawable.crushed_mdma_crystals).toString());
        images.add(resourceIdToUri("com.zhuruilin.drugeducationcentre", R.drawable.tan_mdma_crystals).toString());
        images.add(resourceIdToUri("com.zhuruilin.drugeducationcentre", R.drawable.mdma_capsules).toString());
        titles.add("Ecstasy tablets which may contain MDMA");
        titles.add("Crushed MDMA (1 gram) crystals");
        titles.add("A salt of MDMA (typically white with impurities, resulting in a tan discoloration");
        titles.add("High purity MDMA in capsules");
        banner.setImages(images);
        banner.setBannerTitles(titles);
        banner.setDelayTime(10000);
        banner.start();
        
        return view;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String addContent3(){
        return "Ecstasy comes in a tablet form and is usually swallowed. The pills come in different colours and " +
                "sizes and are often imprinted with a picture or symbol. " +
                "It can also come as capsules, powder or crystal.";
    }
    public String addContent2(){
        return "In Australia, MDMA/Ecstasy are also known as E, pills, caps, pingers, M&M, doopa, love drug, " +
                "disco biscuits, XTC, X and eccy.";
    }
    public String addTitle2(){

        return "Other names: ";
    }
    public String addDescription(){

        String description = "\"Ecstasy\" was originally a brand name for methylenedioxymethamphetamine (MDMA), " +
                "which is a stimulant drug, " +
                "which means it speeds up the messages travelling between the brain and body. " +
                "Ecstasy is usually swallowed in tablet or capsule form, but is also available as a powder and crystalline form, " +
                "which is snorted or smoked. Injecting ecstasy is not common and is more dangerous.";
        return description;
    }
}
