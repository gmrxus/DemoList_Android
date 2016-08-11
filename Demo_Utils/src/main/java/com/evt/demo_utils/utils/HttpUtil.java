package com.evt.demo_utils.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络访问类,使用的okhttp框架
 *
 * Created by mrxus on 16/8/10.
 */
public class HttpUtil {
    public static void post(String url, RequestBody requestBody, final OnNetRequestListener listener) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        HashMap hashMap = requestBody.returnMap();
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = (String) hashMap.get(key);
            builder.add(key, value);
        }
        FormBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                listener.onSuccess(response.body().string());
            }
        });
    }

    public static class RequestBody {
        private HashMap map;

        public RequestBody() {
            this.map = new HashMap();
        }

        public RequestBody add(String key, String value) {
            map.put(key, value);
            return this;
        }

        public HashMap returnMap() {
            return map;
        }

    }

    public interface OnNetRequestListener {
        void onSuccess(String returnValue);

        void onFail();
    }
}
