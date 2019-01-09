package com.wya.env.module.home.fragment;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import com.wya.env.R;

/**
 * @date: 2018/6/29 13:55
 * @author: Chunjiang Mao
 * @classname: DataAdapter
 * @describe:
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
