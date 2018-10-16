package com.zhuruilin.drugeducationcentre.Drugs.Ecstasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import android.view.View;

import com.zhuruilin.drugeducationcentre.R;



public class DrugFragment extends AppCompatActivity implements RadioGroup.OnClickListener,
        ViewPager.OnPageChangeListener{

    //UI Objects
    private TextView txt_topbar;
    private RadioGroup radioGroup;
    private RadioButton rb_description;
    private RadioButton rb_effect;
    private RadioButton rb_reason;
    private RadioButton rb_law;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_description.setChecked(true);

    }

    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.title);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rb_description = (RadioButton) findViewById(R.id.rb_description);
        rb_effect = (RadioButton) findViewById(R.id.rb_effect);
        rb_reason = (RadioButton) findViewById(R.id.rb_reason);
        rb_law = (RadioButton) findViewById(R.id.rb_law);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.rb_description:
                        System.out.println("rb_description actived");
                        return;

                    case R.id.rb_effect:
                        System.out.println("rb_effect actived");

                        return;
                    case R.id.rb_reason:
                        System.out.println("rb_reason actived");

                        return;
                    case R.id.rb_law:
                        System.out.println("rb_law actived");

                        return;
                }
            }

        });


        vpager = (ViewPager) findViewById(R.id.viewPager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onClick(View v){}

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_description.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_effect.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_reason.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_law.setChecked(true);
                    break;
            }
        }
    }


}
