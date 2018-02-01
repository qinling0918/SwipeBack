package com.tsinling.swipeback;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.tsinling.library.ActivityLifecycleCallbacks;
import com.tsinling.library.SwipeBackLayout;


/**
 * Created by tsinling on 2018/1/20.
 */

public class SwipeBackHelper extends ActivityLifecycleCallbacks {

    private SwipeBackHelper(){}
    private static class SingletonHolder {
        private static final SwipeBackHelper mInstance = new SwipeBackHelper();
    }

    public static SwipeBackHelper getInstance() {
        return SwipeBackHelper.SingletonHolder.mInstance;
    }

    public void init(Application mApplication) {
        mApplication.registerActivityLifecycleCallbacks(this);
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        if (!(activity instanceof MainActivity)) {//跳过MainActivity

            SwipeBackLayout mSwipeBackLayout = new SwipeBackLayout(activity);
            mSwipeBackLayout.attachToActivity(activity);
            mSwipeBackLayout.setWeChatStyle(false);//若开启该功能，需要在Application里init
        }
    }

}
