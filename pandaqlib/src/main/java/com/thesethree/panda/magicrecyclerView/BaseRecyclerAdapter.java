package com.thesethree.panda.magicrecyclerView;

/**
 * Created by Eric on 2017-4-20.
 */

public class BaseRecyclerAdapter {




    public enum RecyclerItemType {
        //正常Item，头部视图，底部视图，标签视图
        TYPE_NORMAL(0), TYPE_HEADER(1), TYPE_FOOTER(2), TYPE_TAGS(3);

        private int iNum = 0;

        /* 构造器，记住喇，必须是私有的~ */
        private RecyclerItemType(int iNum) {
            this.iNum = iNum;
        }

        public int getiNum() {
            return iNum;
        }
    }
}
