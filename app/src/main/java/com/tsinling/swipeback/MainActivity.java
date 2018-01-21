package com.tsinling.swipeback;

import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends BaseActivity {

    private static final String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this,Main2Activity.class));
    }
}
