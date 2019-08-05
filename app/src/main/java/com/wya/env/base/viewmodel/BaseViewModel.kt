package com.wya.env.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.wya.env.base.model.BaseModel
import io.reactivex.disposables.CompositeDisposable

/**
 *     @author : xdl
 *     @time   : 2019/08/03
 *     @describe :
 */
open class BaseViewModel<M : BaseModel> : AndroidViewModel {
    private var model: M? = null
    private lateinit var compositeDisposable: CompositeDisposable

    constructor(application: Application) : this(application, null)

    constructor(application: Application, model: M?) : super(application) {
        this.model = model
        compositeDisposable = CompositeDisposable()
    }

}
