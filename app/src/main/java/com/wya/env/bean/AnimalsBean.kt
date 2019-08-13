package com.wya.env.bean

/**
 *     @author : xdl
 *     @time   : 2019/08/08
 *     @describe :
 */
data class AnimalsBean(
    val list: List<ListBean>,
    val msg: String
)

data class ListBean(
    var icon: String,
    var name: String
)