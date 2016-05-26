package com.leke.volleydemo;

import android.app.Application;

import com.leke.minivolley.RequestQueue;
import com.leke.minivolley.toolbox.Volley;

/**
 * ProjectName: LekeVolleyDemo
 * ClassName: LekeApplication
 * User: xfeng
 * <p>
 * Date: 2016-05-25 13:57
 * <p>
 * Version : V 1.0.0
 * throws:
 */
public class LekeApplication extends Application {
    private static LekeApplication instance ;

    private RequestQueue requestQueue ;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this ;
    }

    /**
     * application的单例
     * @return
     */
    public static LekeApplication getInstance(){
        return instance ;
    }

    /**
     * 初始化volley网络队列RequestQueue
     * @return
     *      requestQueue
     */
    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            this.requestQueue = Volley.newRequestQueue(this) ;
        }
        return requestQueue ;
    }
}
