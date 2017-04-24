package com.thesethree.panda.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.thesethree.panda.R;
import com.thesethree.panda.modules.news.NewsMainFragment;
import com.thesethree.panda.modules.video.home.mvp.VideoHomeFragment;
import com.thesethree.panda.modules.zhihu.home.mvp.ZhihuDailyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, View.OnClickListener{
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.bottom_navgation)
    BottomNavigationBar mBottomNavgation;
    @BindView(R.id.fl_bottom_navgation)
    FrameLayout mFlBottomNavgation;
    @BindView(R.id.userimage)
    CircleImageView mUserimage;
    @BindView(R.id.navigation_header_container)
    LinearLayout mNavigationHeaderContainer;

    private Fragment mCurrentFrag;
    private FragmentManager fm;
    private Fragment mZhihuFragment;
    private Fragment mNewsFragment;
    private Fragment mBubbleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        fm=getSupportFragmentManager();

        initView();
    }

    private void initView() {
        mZhihuFragment = new ZhihuDailyFragment();
        mBubbleFragment = new VideoHomeFragment();
        mNewsFragment = new NewsMainFragment();

        initNavigation();
    }

    private void initNavigation(){
        mBottomNavgation
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .addItem(new BottomNavigationItem(R.drawable.ic_home,getString(R.string.nav_00_title)).setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_view_headline, getString(R.string.nav_01_title)).setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_live_tv, getString(R.string.nav_02_title)).setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .setTabSelectedListener(this)
                .initialise();
    }

    public void switchContent(Fragment to) {
        if (mCurrentFrag != to) {
            if (!to.isAdded()) {// 如果to fragment没有被add则增加一个fragment
                if (mCurrentFrag != null) {
                    fm.beginTransaction().hide(mCurrentFrag).commit();
                }
                fm.beginTransaction()
                        .add(R.id.main_view, to)
                        .commit();
            } else {
                fm.beginTransaction().hide(mCurrentFrag).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
            mCurrentFrag = to;
        }
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                switchContent(mZhihuFragment);
                break;
            case 1:
                switchContent(mNewsFragment);
                break;
            case 2:
                switchContent(mBubbleFragment);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
