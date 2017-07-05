package com.raoj.observer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.raoj.observer.listener.ObserverListener;

/**
 * Created by raoj on 2017/6/5.
 */

public class ThirdActivity extends AppCompatActivity implements ObserverListener {

    public static final String TAG = "ThirdActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView = (TextView) findViewById(R.id.tv3);
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObserverManager.getInstance().notifyObserver("观察者请刷新信息");
            }
        });

        //注册
        ObserverManager.getInstance().add(this);
    }

    @Override
    public void observerUpData(String content) {
        Log.d(TAG, "observerUpData:33333333333");
        textView.setText(content);
    }
}
