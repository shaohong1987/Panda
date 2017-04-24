package com.thesethree.panda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.thesethree.panda.BaseActivity;
import com.thesethree.panda.R;
import com.thesethree.panda.utils.ViewUtils;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_background)
    ImageView mIvBackGround;
    @BindView(R.id.iv_splash_image)
    ImageView mIvSplashImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        String[] images=getResources().getStringArray(R.array.splash_background);
        int index=new Random().nextInt((images.length-1))%images.length;
        Picasso.with(this)
                .load(images[index])
                .into(mIvBackGround);

        Picasso.with(this)
                .load("file://"+ ViewUtils.getAppFile(this,"images/user.png"))
                .error(ResourcesCompat.getDrawable(getResources(), R.drawable.user_image, null))
                .into(mIvSplashImage);

        //渐变动画
        AlphaAnimation animation=new AlphaAnimation(1,0);
        animation.setDuration(1500);//设置时长3秒
        mIvSplashImage.startAnimation(animation);
        //动画的事件监听事件
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束，进入主界面
                Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //如果动画需要重复
            }
        });
    }

}
