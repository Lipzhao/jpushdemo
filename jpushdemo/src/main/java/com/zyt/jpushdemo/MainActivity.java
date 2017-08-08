package com.zyt.jpushdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private TextView tvPush;
    private TextView tvPushDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OrderObservable.getInstance().addObserver(this);
        tvPush = (TextView) findViewById(R.id.tvpush);
        tvPushDes = (TextView) findViewById(R.id.tvpushdes);
        tvPush.setText("name");
        tvPushDes.setText("des");

    }

    @Override
    public void update(Observable o, Object arg) {
        Map<String ,String > map= (Map<String, String>) arg;
        String name = map.get("name");
        String des = map.get("des");
        tvPush.setText(name);
        tvPushDes.setText(des);

    }
}
