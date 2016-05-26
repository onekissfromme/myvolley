package com.leke.volleydemo.volleyplug;

import android.text.TextUtils;
import android.util.Log;

import com.leke.minivolley.AuthFailureError;
import com.leke.minivolley.Response;
import com.leke.minivolley.VolleyError;
import com.leke.minivolley.toolbox.JsonObjectRequest;
import com.leke.minivolley.toolbox.StringRequest;
import com.leke.volleydemo.LekeApplication;
import com.leke.volleydemo.leke.LekeConfig;

import org.json.JSONObject;

import java.util.Map;

/**
 * ProjectName: LekeVolleyDemo
 * ClassName: BaseLekeVolley
 * User: xfeng
 * <p>
 * Date: 2016-05-25 14:59
 * <p>
 * Version : V 1.0.0
 * throws:
 */
public class BaseLekeVolley {

    protected LekeResponse.Listener responseListener ;
    protected LekeResponse.ErrorListener errorListener ;

    public BaseLekeVolley() {
    }


    protected String initURL(String _s , String _m){
        String host = LekeConfig.HOME_WORK_NEW ;
        String url ;
        String ticket = "VFZSVlBRPT07T0RrK1BEZzdPVHMrOzE1MTU=" ;
        url = host + "?ticket="
                + ticket + "&_s=" + _s
                + "&_m=" + _m + "&device=android" + "&version="
                + LekeConfig.REQUEST_VERSION;

            return url ;
    }

    /** 网络请求：数据为String形式的返回 **/
    private void stringRequest(int method , final Map<String , String> params , String url){
        StringRequest stringRequest = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                responseListener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                errorListener.onErrorResponse("request error");
                if (LekeConfig.IS_DEBUG) {
                    Log.i(LekeConfig.TAG, volleyError.toString());
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params ;
            }
        };

        LekeApplication.getInstance().getRequestQueue().add(stringRequest) ;
    }

    protected void jsonObjectReqeust(int method , final Map<String , String> params , String url){
        Log.i("Test2" , url) ;
        Log.i("Test2" , getjsonRequest(params).toString()) ;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url, getjsonRequest(params), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                responseListener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                errorListener.onErrorResponse("request error");
                if (LekeConfig.IS_DEBUG) {
                    Log.i(LekeConfig.TAG, volleyError.toString());
                }
            }
        }) ;

        LekeApplication.getInstance().getRequestQueue().add(jsonObjectRequest) ;
    }

    private JSONObject getjsonRequest(Map<String , String> params){
        String jsonString = initJsonUrl(params) ;
        JSONObject jsonObject = null ;
        try {
            jsonObject = new JSONObject(jsonString);
        }catch (Exception e){
            jsonObject = null ;
        }
        return jsonObject ;
    }

    private String initJsonUrl(Map<String , String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String key : params.keySet()) {
            sb.append("\"" + key + "\":");
            sb.append(params.get(key));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        if (LekeConfig.IS_DEBUG) {
            //TODO debug模式下 ， 添加打印代码
//            LogcatUtils.i(LekeConfig.TAG, sb.toString());
        }
        if (TextUtils.isEmpty(sb)) {
            return "";
        }
        // return data;
        return /* isEntrypt ? aes.encrypt(data, LekeConfig.SIGN_KEY) : */sb
                .toString();
    }

}
