package com.github.carrerfour.Repo.Services;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sumitsaini on 17/06/2019 AD.
 */

public class RetrofitService {

    private static final String BASE_URL = "https://api.github.com/";
    private static Retrofit retrofit;

    private RetrofitService() {
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(getOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

    }

    public static OkHttpClient getOkHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.addInterceptor(logging);
        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder().header("Accept", "application/vnd.github.v3+json");
                return chain.proceed(requestBuilder.build());
            }
        });

        return okHttpClientBuilder.build();

    }
}
