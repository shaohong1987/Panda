package com.thesethree.panda.modules.zhihu.home.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thesethree.panda.BaseFragment;
import com.thesethree.panda.R;
import com.thesethree.panda.magicrecyclerView.BaseItem;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Eric on 2017-4-20.
 */

public class ZhihuDailyFragment extends BaseFragment {

    private Unbinder mUnbinder;
    private ArrayList<BaseItem> mBaseItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.zhihulist_fragment,container,false);

        mUnbinder=ButterKnife.bind(view);

        return view;
    }

    private void initView(){
        mBaseItems = new ArrayList<>();
    }
}
