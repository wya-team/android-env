package com.wya.env.http.interceptor

import com.wya.env.common.Constant
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * @author : xdl
 * @time : 2019/07/19
 * @describe :拦截替换域名host
 */
class HostInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val baseUrl = HttpUrl.parse(Constant.BASE_URL)
        val url = request.url()
                .newBuilder()
                .host(baseUrl!!.host())
                .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
