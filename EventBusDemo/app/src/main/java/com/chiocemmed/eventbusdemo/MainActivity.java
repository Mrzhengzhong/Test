package com.chiocemmed.eventbusdemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        EventBus.getDefault().register(this);
        EventBus.getDefault().post("hello");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void niaho(EvenBusMSG event){
        Toast.makeText(this, event.getMsg(), Toast.LENGTH_SHORT).show();
    }

    // This method will be called when a SomeOtherEvent is posted
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void lall(String event){

    }




}
