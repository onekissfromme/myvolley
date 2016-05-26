package com.leke.volleydemo.volleyplug;

import java.util.Map;

/**
 * ProjectName: LekeVolleyDemo
 * ClassName: LekeVolley
 * User: xfeng
 * <p>
 * Date: 2016-05-25 09:43
 * <p>
 * Version : V 1.0.0
 * throws:
 */
public class LekeVolley extends BaseLekeVolley{



    /** 没有指定请求类型，没有参数的的网络请求：默认方式为post */
    public LekeVolley(int resposeType , String _s , String _m , LekeResponse.Listener responseListener , LekeResponse.ErrorListener errorListener) {
        this.responseListener = responseListener ;
        this.errorListener = errorListener ;
        lekeVolleyNetDispatch(-1,resposeType,_s,_m,null);
    }

    /** 没有参数的网络请求 */
    public LekeVolley(int method , int resposeType , String _s , String _m  , LekeResponse.Listener responseListener , LekeResponse.ErrorListener errorListener) {
        this.responseListener = responseListener ;
        this.errorListener = errorListener ;
        lekeVolleyNetDispatch(method,resposeType,_s,_m,null);
    }
    /** 没有制动请求类型的网络请求，默认：post */
    public LekeVolley(int resposeType , String _s , String _m  , Map<String , String> params ,  LekeResponse.Listener responseListener , LekeResponse.ErrorListener errorListener) {
        this.responseListener = responseListener ;
        this.errorListener = errorListener ;
        lekeVolleyNetDispatch(-1,resposeType,_s,_m,params);

    }
    /** 参数全带的网络请求 **/
    public LekeVolley(int method , int resposeType , String _s , String _m  , Map<String , String> params , LekeResponse.Listener responseListener , LekeResponse.ErrorListener errorListener) {
        this.responseListener = responseListener ;
        this.errorListener = errorListener ;
        lekeVolleyNetDispatch(method,resposeType,_s,_m,params);
    }


    /** 网络请求的分发方法 **/
    private void lekeVolleyNetDispatch(int method , int resposeType , String _s , String _m  , Map<String , String> params ){
        /** 默认请求方式分为两种：POST OR GET ,如果没有指定GET请求，则默认为POST请求 */
        int methodType = method == LekeRequest.Method.GET ? LekeRequest.Method.GET : LekeRequest.Method.POST ;
        String url = initURL(_s,_m) ;
        jsonObjectReqeust(methodType,params,url);


        /** 返回类型的判断 */
        switch (resposeType){
            /** 数据以String形式返回 */
            case LekeRequest.ResposeType.StringType:

                break;
            /** 数据以json对象形式返回 */
            case LekeRequest.ResposeType.JSonType:

                break;
            /** 数据以json数组形式返回 */
            case LekeRequest.ResposeType.JSonArrayType:

                break;
            /** 默认以String形式返回 */
            default:
                break;
        }

    }



}
