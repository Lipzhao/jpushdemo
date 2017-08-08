package com.zyt.jpushdemo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * 被观察者
 * Created by heshang on 2017/8/9 0009.
 */

public class OrderObservable extends Observable {
    private static OrderObservable orderObservable=new OrderObservable();
    private OrderObservable(){

    }
    public static OrderObservable getInstance(){
        return orderObservable;
    }

    public void orderMsgComing(String extras) {
        Map<String, String> map = processMsg(extras);
        setChanged();
        notifyObservers(map);

    }

    private Map<String ,String> processMsg(String extras) {
        try {
            JSONObject jsonObject = new JSONObject(extras);
            String name = jsonObject.getString("name");
            String des = jsonObject.getString("des");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name",name);
            hashMap.put("des", des);
            return hashMap;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
