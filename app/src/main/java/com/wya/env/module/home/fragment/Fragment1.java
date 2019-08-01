package com.wya.env.module.home.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wya.env.R;
import com.wya.env.base.fragment.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @date: 2018/7/3 13:55
 * @author: Chunjiang Mao
 * @classname: Fragment1
 * @describe: Example Fragment
 */

public class Fragment1 extends BaseMvpFragment<Fragment1Presenter> implements Fragment1View {
    
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.srl)
    SmartRefreshLayout smartRefreshLayout;
    private List<String> data = new ArrayList<>();
    private DataAdapter adapter;
    
    private Fragment1Presenter fp = new Fragment1Presenter();
    
    private int listSize = 31;
    
    @Override
    public void onFragmentVisibleChange(boolean isVisible) {
      /*  fp.mView=this;
        if (isVisible) {
            initData();//初始化数据
        }*/
    }
    
    private void initData() {
        //        if (!isFirst) {
        initListData();
        //            isFirst = true;
        //        }
        //初始化RecyclerView
        initRecyclerView();
    }
    
    private void initListData() {
        for (int i = 0; i < listSize; i++) {
            data.add("第" + i + "条数据");
        }
    }
    
    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new DataAdapter(R.layout.one_item, data);
        recyclerView.setAdapter(adapter);
        //刷新监听
        smartRefreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.getLayout().postDelayed(() -> {
            smartRefreshLayout.finishRefresh();//刷新完成
            smartRefreshLayout.setNoMoreData(false);
            
        }, 2000));
        
        //加载监听
        smartRefreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.getLayout().postDelayed(() -> {
            if (adapter.getItemCount() >= listSize) {
                showShort("数据全部加载完毕");
                smartRefreshLayout.finishLoadMoreWithNoMoreData();//将不会再次触发加载更多事件
            } else {
                smartRefreshLayout.finishLoadMore();
                smartRefreshLayout.setNoMoreData(false);
            }
            
        }, 2000));
        
        //RecyclerView条目点击事件
        adapter.setOnItemClickListener((adapter, view, position) -> showShort(position + ""));
    }
    
    @Override
    protected int getLayoutResource() {
        return R.layout.one_fragment;
    }
    
    @Override
    protected void initView() {
        fp.mView = this;
        initData();//初始化数据
    }
    
}
