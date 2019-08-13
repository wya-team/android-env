package com.wya.env.bean

/**
 * @date: 2018/7/3 13:50
 * @author: Chunjiang Mao
 * @classname: BaseResult
 * @describe:
 */

data class BaseResult<T>(val status: Int,
                         val msg: String,
                         @JvmSuppressWildcards val  data: T)

