package com.wya.env.base

/**
 * @date: 2018/7/3 13:49
 * @author: Chunjiang Mao
 * @classname: BasePresent
 * @describe: 基类P层
 */

open class BasePresent<T : BaseView> {
    var mView: T? = null
}
