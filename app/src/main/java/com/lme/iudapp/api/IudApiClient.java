package com.lme.iudapp.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IudApiClient {

    public static Retrofit apiService() {
        return new Retrofit.Builder()
                .baseUrl(IudApiInterface.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(addLog().build())
                .build();
    }


    private static OkHttpClient.Builder addLog() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);

        return httpClient;
    }
}
