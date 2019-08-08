package com.wya.env.base.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 *     @author : xdl
 *     @time   : 2019/08/03
 *     @describe :
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    var baseViewModel: BaseViewModel? = null
    var titleText = MutableLiveData("默认标题")
    var showTitle = MutableLiveData(true)
    var backIconClick = MutableLiveData<View>()
    val showDialog = MutableLiveData<Void>()
    val dismissDialog = MutableLiveData<Void>()


    fun onBackClick(view: View) {
        backIconClick.postValue(view)
    }

    fun setTitle(title: String) {
        titleText.value = title
    }


    override fun onCleared() {
        super.onCleared()
    }


}
