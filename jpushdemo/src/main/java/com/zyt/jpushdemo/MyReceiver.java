package com.zyt.jpushdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by heshang on 2017/8/9 0009.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {

            String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
           // Log.e("MyReceiver", "我收到了推送消息=========");
          //  Log.e("MyReceiver", message);
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
           // Log.e("MyReceiver", extras);
            if (extras != null) {
                OrderObservable.getInstance().orderMsgComing(extras);
            }
        }
    }
}
