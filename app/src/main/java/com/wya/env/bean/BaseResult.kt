package com.wya.env.bean

/**
 * @date: 2018/7/3 13:50
 * @author: Chunjiang Mao
 * @classname: BaseResult
 * @describe:
 */

class BaseResult<T> {
    var status: Int = 0
    var msg: String? = null
    var data: T? = null
}
