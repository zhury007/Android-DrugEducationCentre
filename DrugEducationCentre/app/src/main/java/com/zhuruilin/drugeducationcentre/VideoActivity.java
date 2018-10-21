package com.zhuruilin.drugeducationcentre;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.volokh.danylo.video_player_manager.manager.PlayerItemChangeListener;
import com.volokh.danylo.video_player_manager.manager.SingleVideoPlayerManager;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.visibility_utils.calculator.DefaultSingleItemCalculatorCallback;
import com.volokh.danylo.visibility_utils.calculator.ListItemsVisibilityCalculator;
import com.volokh.danylo.visibility_utils.calculator.SingleListViewItemActiveCalculator;
import com.volokh.danylo.visibility_utils.scroll_utils.RecyclerViewItemPositionGetter;
import com.zhuruilin.drugeducationcentre.video.OnlineVideoListItem;
import com.zhuruilin.drugeducationcentre.video.VideoListItem;
import com.zhuruilin.drugeducationcentre.video.VideoWatchAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";
    public static final String FILE_PATH = "https://drug-education-centre.oss-ap-southeast-1.aliyuncs.com/";

    private RecyclerView mRecyclerView;

    //视频数据，相当于普通adapter里的datas
    private List<VideoListItem> mLists = new ArrayList<>();

    //它充当ListItemsVisibilityCalculator和列表（ListView, RecyclerView）之间的适配器（Adapter）。
    private RecyclerViewItemPositionGetter mItemsPositionGetter;

    //ListItemsVisibilityCalculator可以追踪滑动的方向并在过程中计算每个Item的可见度
    //SingleListViewItemActiveCalculator会在滑动时获取每个View的可见度百分比.
    //所以其构造方法里需要传入mLists，而mLists里的每个item实现了ListItem接口
    //的getVisibilityPercents方法，也就是返回当前item可见度的方法.
    //这样ListItemsVisibilityCalculator就可以计算当前item的可见度了.

    private final ListItemsVisibilityCalculator mVideoVisibilityCalculator =
            new SingleListViewItemActiveCalculator(new DefaultSingleItemCalculatorCallback(), mLists);


    //SingleVideoPlayerManager就是只能同时播放一个视频。
    //当一个view开始播放时，之前那个就会停止
    private final VideoPlayerManager<MetaData> mVideoPlayerManager = new SingleVideoPlayerManager(new PlayerItemChangeListener() {
        @Override
        public void onPlayerItemChanged(MetaData metaData) {
        }
    });

    private int mScrollState;
    private LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(VideoActivity.this);
        setContentView(R.layout.activity_video);
        mRecyclerView = (RecyclerView) findViewById(R.id.video_watch_list);

        //添加视频数据
        String URLtest = "http://dn-chunyu.qbox.me/fwb/static/images/home/video/video_aboutCY_A.mp4";
//        String uri="android.resource://"+getPackageName()+"/"+R.raw.ass;
//        videoView.setVideoURI(Uri.parse(uri));

        List<OnlineVideoListItem> videoList = Arrays.asList(
                new OnlineVideoListItem(mVideoPlayerManager,"It's time to stop drug driving-30 second",
                        "https://flock.bcm.com.au/wp-content/uploads/2016/02/its-time-to-stop-drug-driving-youtube-1455752253kng84.jpg",
//                        URLtest),
                        FILE_PATH + "video1.mp4"),
                new OnlineVideoListItem(mVideoPlayerManager,"It's time to stop drug driving-15 second",
                        "https://www.mac.sa.gov.au/globalassets/campaigns/drug-driving/its-time-to-stop-drug-driving/campaign-drug-driving.jpg",
//                        URLtest),
                        FILE_PATH + "video2.mp4"),
                new OnlineVideoListItem(mVideoPlayerManager,"It’s time to stop drug driving - radio 1",
                        "http://nnimgt-a.akamaihd.net/transform/v1/crop/frm/Y82NNyLS839S9YQGMMc9vG/b4e29ae6-0366-4e48-8895-133218be7062.jpg/r0_0_749_965_w1200_h678_fmax.jpg",
//                        URLtest),
                        FILE_PATH + "video3.mp4"),
                new OnlineVideoListItem(mVideoPlayerManager,"Driving High - The science of driving on drugs",
                        "https://www.mac.sa.gov.au/globalassets/banners/dusk_road_mac_banner_image.jpg",
//                        URLtest)
                        FILE_PATH + "video4.mp4")

        );

        for (OnlineVideoListItem video:videoList
             ) {
            mLists.add(video);
        }
        
//        mLists.add(new OnlineVideoListItem(mVideoPlayerManager,
//                "测试",
//                "http://photocdn.sohu.com/20150709/mp21991057_1436419939431_1_th.jpeg",
//                URL
//        ));


        mRecyclerView.setLayoutManager(mLayoutManager);
        VideoWatchAdapter adapter = new VideoWatchAdapter(mLists);
        mRecyclerView.setAdapter(adapter);
        //////////////////////////////////////////////

        //这里是文档上默认的写法，直接复制下来。
        //查看了下源码其中VisibilityCalculator.onScrollStateIdle的这
        //个方法又调用了方法calculateMostVisibleItem，用来计算滑动状态改变时
        //的最大可见度的item.这个方法的计算方法是这样的：当view无论是向上还是
        //向下滚动时，在滚动的过程中，计算可见度最大的item。当滚动状态为空闲时
        //此时最后一个计算得出的可见度最大的item就是当前可见度最大的item
        //而onScroll方法是处理item滚出屏幕后的计算,用于发现新的活动item
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
                mScrollState = scrollState;
                if (scrollState == RecyclerView.SCROLL_STATE_IDLE && !mLists.isEmpty()) {

                    mVideoVisibilityCalculator.onScrollStateIdle(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition());
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!mLists.isEmpty()) {
                    mVideoVisibilityCalculator.onScroll(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition() - mLayoutManager.findFirstVisibleItemPosition() + 1,
                            mScrollState);
                }
            }
        });

        mItemsPositionGetter = new RecyclerViewItemPositionGetter(mLayoutManager, mRecyclerView);

    }

    //文档上的默认实现，复制下来
    //onResume()中调用方法，使屏幕亮起时启动对View的可见度的计算。
    @Override
    public void onResume() {
        super.onResume();
        if (!mLists.isEmpty()) {
            // need to call this method from list view handler in order to have filled list

            mRecyclerView.post(new Runnable() {
                @Override
                public void run() {

                    mVideoVisibilityCalculator.onScrollStateIdle(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition());

                }
            });
        }
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onStop() {
        super.onStop();
        mVideoPlayerManager.resetMediaPlayer(); // 页面不显示时, 释放播放器
    }


}
