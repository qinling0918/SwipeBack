package com.tsinling.swipeback;

import android.app.Application;


/**
 * Created by tsinling on 2018/1/20.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //若是需要微信风格 则需要init
        //在debug版本，若使用微信风格但未init 则会报异常
        //在release版本，若设置了微信风格但未init 则仅仅会没有微信侧滑效果

        ActivityStack.getInstance().init(this);

        //若是不想在Base类里面设置 则可以参考SwipeBackHelper 的使用方法
        SwipeBackHelper.getInstance().init(this);
    }
}
