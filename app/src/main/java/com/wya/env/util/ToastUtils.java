package com.wya.env.util;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class ToastUtils {
    private static Toast toast = null;

    /**
     * UI线程/非UI线程均可调用 显示 Toast
     */
    public static void showToast(Context context, String str) {
        if(str != null && !isEmpty(str)){
            Toast toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
            showMyToast(toast,500);
        }
    }
    /**
     * UI线程/非UI线程均可调用 显示 Toast
     * 再中间显示
     */
    public static void showToastCenter(Context context, String str) {
        if(str != null && !isEmpty(str)){
            Toast toast = Toast.makeText(context, str,
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            showMyToast(toast,500);
//            toast.show();
        }

    }
    /**
     * UI线程/非UI线程均可调用 显示 Toast
     */
    public static void showLongToast(Activity context, String str) {
        if(!str.equals("")){
            Toast.makeText(context, str, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input 要判断的字符串
     * @return boolean 空串：true 非空串：false
     */
    public static boolean isEmpty(CharSequence input) {
        if (android.text.TextUtils.isEmpty(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }


    /**
     * 定义toast显示的时间
     * @param toast
     * @param cnt
     */
    public static void showMyToast(final Toast toast, final int cnt) {
        final Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        },0,3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt );
    }

}
