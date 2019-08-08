package com.wya.env.uiview.login

/**
 * @author : xdl
 * @time : 2019/08/07
 * @describe :
 */
class LoginInfoBean {

    /**
     * status : 1
     * msg : ld
     * data : {"token":"erer"}
     */

    var status: Int = 0
    var msg: String? = null
    var data: DataBean? = null

    class DataBean {
        var token: String? = null
        var msg: String? = null
        var username: String? = null
        var realname: String? = null
        var organization: String? = null
    }
}
