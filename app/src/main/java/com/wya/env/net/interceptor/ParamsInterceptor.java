package com.wya.env.net.interceptor;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wya.utils.utils.PhoneUtil;
import com.wya.utils.utils.StringUtil;

import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * @author : xdl
 * @time : 2019/07/19
 * @describe :
 */
public class ParamsInterceptor implements Interceptor {

    public static final String METHOD_GET = "GET";
    /**
     * 随机生成32位字符串
     *
     * @return
     */
    public static String getRandomString(int num) {
        //1.  定义一个字符串（A-Z，a-z，0-9）即62个数字字母；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //2.  由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //3.  长度为几就循环几次
        for (int i = 0; i < num; ++i) {
            //从62个的数字或字母中选择
            int number = random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("version", "1.0.0")
                .addHeader("platform", "android" + PhoneUtil.getInstance().getSDKVersion())
                .addHeader("Content-Type", "application/json");
        String sign = "";
        HttpUrl httpUrl = original.url();
        // 业务只处理get和post，其中post目前只有json格式的后期如果有form表单格式的需要再单独处理
        long stamp = System.currentTimeMillis() / 1000;
        String random = getRandomString(32);
        if (METHOD_GET.equals(original.method())) {

            String url = httpUrl.toString();
            if (httpUrl.querySize() != 0) {
                url = url + "&timestamp=" + stamp + "&nonce_str=" + random;
            } else {
                url = url + "?timestamp=" + stamp + "&nonce_str=" + random;
            }
            httpUrl = HttpUrl.parse(url);

            Set<String> names = httpUrl.queryParameterNames();
            TreeSet<String> treeSet = new TreeSet<>(names);
            treeSet.comparator();
            for (String key : treeSet) {
                String parameter = httpUrl.queryParameter(key);
                if (!TextUtils.isEmpty(parameter)) {
                    sign += key + "=" + parameter + "&";
                }
            }
            requestBuilder = requestBuilder.url(url);
        } else {
            RequestBody body = original.body();
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            String bodyValue = buffer.readUtf8();
            TreeMap<String, String> map = null;
            if (TextUtils.isEmpty(bodyValue)) {
                map = new TreeMap<>();
            } else {
                map = new Gson().fromJson(bodyValue,
                        new TypeToken<TreeMap<String, String>>() {
                        }.getType());
            }
            map.put("timestamp", String.valueOf(stamp));
            map.put("nonce_str", random);
            map.comparator();
            for (String key : map.keySet()) {
                //数组和空过滤
                String value = map.get(key);
                if (!TextUtils.isEmpty(value)) {
                    sign += key + "=" + value + "&";
                }
            }
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),
                    new Gson().toJson(map));
            requestBuilder = requestBuilder.post(requestBody);

        }
        sign = sign.substring(0, sign.length() - 1);
        sign = sign + "KEY";

        requestBuilder = requestBuilder.addHeader("sign", StringUtil.getSign(sign));
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
