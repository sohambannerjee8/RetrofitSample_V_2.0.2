package com.indus.retrofitsample.network;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Soham on 25-01-2016.
 */
public class RestClient {

    private static Restapi REST_CLIENT;
    private static String ROOT =
            "https://api.something.com/app/";
    private static OkHttpClient addInterceptar(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(new SessionRequestInterceptor()).addInterceptor(interceptor)
                .build();
    }
        static
    {
        setupRestClient();
    }

    public static Restapi get() {
        return REST_CLIENT;
    }

    public static Restapi setupRestClient() {


        Retrofit restAdapter = new Retrofit .Builder()
              //  .setLogLevel(RestAdapter.LogLevel.FULL)
                .baseUrl(ROOT)
                .client(addInterceptar()).addConverterFactory(GsonConverterFactory.create())
               // .setRequestInterceptor(new SessionRequestInterceptor())
                .build();

        return restAdapter.create(Restapi.class);
    }
}