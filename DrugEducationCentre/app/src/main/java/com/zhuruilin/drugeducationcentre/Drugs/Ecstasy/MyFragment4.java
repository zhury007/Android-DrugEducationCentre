package com.zhuruilin.drugeducationcentre.Drugs.Ecstasy;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;
import com.zhuruilin.drugeducationcentre.R;
import com.zhuruilin.drugeducationcentre.view.AnimatedExpandableListView;
import com.zhuruilin.drugeducationcentre.view.DemoAdapter;
import android.app.Activity;
import android.widget.ExpandableListView;

public class MyFragment4 extends Fragment {
    private AnimatedExpandableListView mExpandableListView;
    private String[] mItemNameArr;
    private String title;

    public MyFragment4(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content4,container,false);

        TextView txt_content = (TextView)view.findViewById(R.id.fg4_content);
        txt_content.setText(addContent());


        mExpandableListView = (AnimatedExpandableListView) view.findViewById(R.id.expandablelistview);
        //去除分割线
        mExpandableListView.setDivider(null);

        initData();  //初始化数据
        initAdapter(view);  //初始化适配器
        initListener();  //初始化监听器

        return view;
    }

//    private void initView() {
////        mExpandableListView = (AnimatedExpandableListView) findViewById(R.id.expandablelistview);
////        //去除分割线
////        mExpandableListView.setDivider(null);
////    }

    private void initData() {
        //条目名字的string数组
        mItemNameArr = getResources().getStringArray(R.array.item_name);
    }

    private void initAdapter(View view) {
        DemoAdapter adapter = new DemoAdapter(view.getContext(),mItemNameArr);
        mExpandableListView.setAdapter(adapter);

        //设置所有条目全部展开
//        for (int i = 0; i < mItemNameArr.length; i++) {
//            mExpandableListView.expandGroup(i);
//        }

    }


    private void initListener() {
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                //设置扩展动画
                if (mExpandableListView.isGroupExpanded(groupPosition)) {
                    mExpandableListView.collapseGroupWithAnimation(groupPosition);
                } else {
                    mExpandableListView.expandGroupWithAnimation(groupPosition);
                }

                return true;
            }
        });
    }


    public String addContent(){
        String txt = "It is illegal to make, keep, use, sell or give away ecstasy. Under the section 47 of the Road Traffic Act 1961, " +
                "it is an offence to drive or attempt to drive a motor vehicle under the influence of a drug." +
                " Drugs in your system make driving extremely dangerous because they impair coordination, " +
                "reduce reaction time, and affect your vision and ability to judge distance and speed.";
        return txt;
    }
    public void setTitle(String title){
        this.title = title;
    }




}
