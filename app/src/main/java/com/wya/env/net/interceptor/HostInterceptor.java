package com.wya.env.net.interceptor;

import com.wya.env.BuildConfig;
import com.wya.env.common.Constant;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : xdl
 * @time : 2019/07/19
 * @describe :拦截替换域名host
 */
public class HostInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (BuildConfig.IS_TEST_ENV) {

            HttpUrl baseUrl = HttpUrl.parse(Constant.BASE_URL);
            HttpUrl url = request.url()
                    .newBuilder()
                    .host(baseUrl.host())
                    .build();
            request = request.newBuilder().url(url).build();
        }
        return chain.proceed(request);
    }
}
