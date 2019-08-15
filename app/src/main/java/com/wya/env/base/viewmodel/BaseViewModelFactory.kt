package com.wya.env.base.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wya.env.base.model.BaseRepository

/**
 *     @author : xdl
 *     @time   : 2019/08/14
 *     @describe :
 */
class BaseViewModelFactory private constructor(application: Application, params: BaseRepository) : ViewModelProvider.NewInstanceFactory() {
    private var application: Application? = application
    private var params: BaseRepository? = params

    companion object {

        @Volatile
        private var instance: BaseViewModelFactory? = null


        fun getInstance(application: Application, baseRepository: BaseRepository) :BaseViewModelFactory{
            if (instance == null) {
                synchronized(BaseViewModelFactory::class.java) {
                    if (instance == null) {
                        instance= BaseViewModelFactory(application,baseRepository)
                    }
                }
            }
            return instance!!
        }

    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return modelClass.getConstructor(Application::class.java, BaseRepository::class.java)
                .newInstance(application, params)
    }
}