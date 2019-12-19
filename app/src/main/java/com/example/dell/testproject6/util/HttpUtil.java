package com.example.dell.testproject6.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Dell on 2019/12/19.
 */

public class HttpUtil {//与服务器交互

    public static void send0kHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
