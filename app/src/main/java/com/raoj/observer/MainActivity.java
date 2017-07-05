package com.raoj.observer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.raoj.observer.listener.ObserverListener;

/**
 * Subject是我们定义目标对象，或者说被观察对象。
 * ConcreteSubject是实际的被观察对象。
 * Observer是观察者的接口，定义了回调接口。
 * ConcreteObserver是实际的观察者对象。
 */
public class MainActivity extends AppCompatActivity implements ObserverListener {

    public static final String TAG = "MainActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //注册
        ObserverManager.getInstance().add(this);
    }

    @Override
    public void observerUpData(String content) {
        Log.d(TAG, "observerUpData:11111111111");
        textView.setText(content);
    }
}
