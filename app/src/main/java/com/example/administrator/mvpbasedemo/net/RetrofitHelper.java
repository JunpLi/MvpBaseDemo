package com.example.administrator.mvpbasedemo.net;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ljp on 2018/9/12.
 * <p>
 *
 */
public class RetrofitHelper {

    private Context mCntext;
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    /**
     * 单例
     * @param context
     * @return
     */
    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    private RetrofitHelper(Context context){
        mCntext = context;
        resetApp();
    }



    /**
     * Retrofit初始化，传入URL地址
     */
    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApi.API)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     *  OkHttpClient
     */
    private  OkHttpClient getOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder1 = request.newBuilder();
                        Request build = builder1.addHeader("","").build();
                        return chain.proceed(build);
                    }
                }).retryOnConnectionFailure(true).build();
        return client;
    }


    /**
     *
     * @return RetrofitService接口对象
     */
    public RetrofitApi getRetrofitService(){
        return mRetrofit.create(RetrofitApi.class);
    }

}

