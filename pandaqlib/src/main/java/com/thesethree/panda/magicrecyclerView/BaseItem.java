package com.thesethree.panda.magicrecyclerView;

import java.io.Serializable;

import static com.thesethree.panda.magicrecyclerView.BaseRecyclerAdapter.RecyclerItemType.TYPE_NORMAL;

/**
 * Created by Eric on 2017-4-20.
 */

public class BaseItem<T> implements Serializable {
    //数据类型
    private BaseRecyclerAdapter.RecyclerItemType mItemType;
    //实际使用的数据
    private T data;

    public BaseRecyclerAdapter.RecyclerItemType getItemType() {
        return mItemType == null ? TYPE_NORMAL : mItemType;
    }

    public void setItemType(BaseRecyclerAdapter.RecyclerItemType itemType) {
        mItemType = itemType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
