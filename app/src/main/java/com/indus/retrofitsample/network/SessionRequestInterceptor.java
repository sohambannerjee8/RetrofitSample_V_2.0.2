package com.indus.retrofitsample.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Soham on 25-01-2016.
 */
public class SessionRequestInterceptor implements Interceptor {
    private static final String TAG = SessionRequestInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader("Content-Type", "application/json").
                addHeader("token", "").addHeader("api_key", "y0").build();
        return chain.proceed(request);
    }
}
