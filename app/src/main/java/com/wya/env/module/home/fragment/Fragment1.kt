package com.wya.env.module.home.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.wya.env.R
import com.wya.env.base.BaseMvpFragment
import kotlinx.android.synthetic.main.one_fragment.*
import java.util.*

/**
 * @date: 2018/7/3 13:55
 * @author: Chunjiang Mao
 * @classname: Fragment1
 * @describe: Example Fragment
 */

class Fragment1 : BaseMvpFragment<Fragment1Presenter>(), Fragment1View {

    private val data = ArrayList<String>()
    private var adapter: DataAdapter? = null

    private val fp = Fragment1Presenter()

    private val listSize = 31

    override val layoutResource: Int
        get() = R.layout.one_fragment


    private fun initData() {
        initListData()
        initRecyclerView()
    }

    private fun initListData() {
        for (i in 0 until listSize) {
            data.add("第" + i + "条数据")
        }
    }

    private fun initRecyclerView() {
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        adapter = DataAdapter(R.layout.one_item, data)
        recyclerView!!.adapter = adapter
        //刷新监听
        srl.setOnRefreshListener { refreshLayout ->
            refreshLayout.layout.postDelayed({
                srl!!.finishRefresh()//刷新完成
                srl!!.setNoMoreData(false)

            }, 2000)
        }

        //加载监听
        srl!!.setOnLoadMoreListener { refreshLayout ->
            refreshLayout.layout.postDelayed({
                if (adapter!!.itemCount >= listSize) {
                    showShort("数据全部加载完毕")
                    srl!!.finishLoadMoreWithNoMoreData()//将不会再次触发加载更多事件
                } else {
                    srl!!.finishLoadMore()
                    srl!!.setNoMoreData(false)
                }

            }, 2000)
        }

        //RecyclerView条目点击事件
        adapter!!.setOnItemClickListener { _, _, position -> showShort(position.toString() + "") }
    }

    override fun initView() {
        fp.mView = this
        initData()//初始化数据
    }

}
