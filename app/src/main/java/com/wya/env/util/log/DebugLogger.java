package com.wya.env.util.log;

public class DebugLogger {
    
    private static String TAG_NET = "NET";
    
    public static void logNet(String message, Object... args) {
        try {
            WYALog.t(TAG_NET).e(message, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
