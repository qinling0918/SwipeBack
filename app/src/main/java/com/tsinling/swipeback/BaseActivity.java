package com.tsinling.swipeback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tsinling on 2018/1/20.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        attachSwipeToActivity();
    }

    private void attachSwipeToActivity() {

        if (!(this instanceof MainActivity)) {//跳过MainActivity
            SwipeBackLayout mSwipeBackLayout = new SwipeBackLayout(this);
            mSwipeBackLayout.attachToActivity(this);
            mSwipeBackLayout.setWeChatStyle(true);//若开启该功能，需要在Application里init
        }
    }
}
