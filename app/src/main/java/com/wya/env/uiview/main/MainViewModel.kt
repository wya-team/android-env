package com.wya.env.uiview.main

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wya.env.R
import com.wya.env.base.adapter.BaseAdapter
import com.wya.env.base.viewmodel.BaseViewModel
import com.wya.env.bean.AnimalsBean
import com.wya.env.bean.BaseResult
import com.wya.env.bean.ListBean
import com.wya.env.common.Constant
import com.wya.env.databinding.AnimalsItemBinding
import com.wya.env.rxbus.RxBus
import com.wya.env.rxbus.event.DismissLoadingEvent
import com.wya.env.rxbus.event.ShowLoadingEvent
import com.wya.env.util.ReadLoadDataUtil
import com.wya.env.util.ToastUtils

/**
 *     @author : xdl
 *     @time   : 2019/08/08
 *     @describe :
 */

class MainViewModel(application: Application) : BaseViewModel(application) {

    var animals = MutableLiveData<AnimalsBean>()
    private var animalList = ArrayList<ListBean>()


    var baseAdapter = MutableLiveData<BaseAdapter<ListBean>>()



    fun initTitle() {
        baseViewModel?.titleText?.value = "动物列表"
    }

    fun getAnimals() {
        RxBus.getInstance().post(ShowLoadingEvent(MainActivity::class.java))
        val value = ReadLoadDataUtil.readAssetFile("data.json")
        val type = object : TypeToken<BaseResult<AnimalsBean>>() {}.type
        val fromJson: BaseResult<AnimalsBean> = Gson().fromJson(value, type)
        val runnable = Runnable {
            run {
                Thread.sleep(2000)
                RxBus.getInstance().post(DismissLoadingEvent(MainActivity::class.java))
                animals.postValue(fromJson.data)
            }
        }
        Thread(runnable).start()
    }

    fun initRecyclerView() {
        var listener: BaseAdapter.OnItemClickListener = object : BaseAdapter.OnItemClickListener {
            override fun item(binding: ViewDataBinding, position: Int) {
                var bind: AnimalsItemBinding = binding as AnimalsItemBinding

                binding.root.setOnClickListener {
                    Log.e("test",position.toString())
                }
                bind.animalBtn.setOnClickListener {
                    ToastUtils.show(position.toString())
                    val map = HashMap<String, Any>()
                    map[Constant.ACTIVITY_CLAZZ] = MainActivity::class.java
                    map[Constant.ACTIVITY_BUNDLE] = Bundle()

                    baseViewModel?.activityInfo?.value=map
                }
            }
        }
        baseAdapter.value=BaseAdapter(animalList, R.layout.animals_item, listener)
    }


    fun updateRecyclerView(data: List<ListBean>) {
        animalList.addAll(data)
        baseAdapter.value?.notifyDataSetChanged()
    }


}