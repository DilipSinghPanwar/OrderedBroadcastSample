package com.orderedbroadcastsample.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button buttonStartBroadcastRecever;

    private static String KEY = "DATA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartBroadcastRecever = (Button) findViewById(R.id.buttonStartBroadCast);
        buttonStartBroadcastRecever.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(KEY,"Dilip");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setAction("custom.action");
//        sendOrderedBroadcast(intent,null);

        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = getResultExtras(true);
                String data = bundle.getString(KEY);
                Log.e(TAG, "Final Result Receiver = : " + data);
            }
        }, null, MainActivity.RESULT_OK, null, null);

    }
}