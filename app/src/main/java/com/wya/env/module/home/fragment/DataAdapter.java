package com.wya.env.module.home.fragment;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import com.wya.env.R;

/**
 * Created by Administrator on 2018/6/29 0029.
 */

public class DataAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public DataAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text, item);
    }


}
