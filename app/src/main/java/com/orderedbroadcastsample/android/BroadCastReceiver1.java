package com.orderedbroadcastsample.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class BroadCastReceiver1 extends BroadcastReceiver {

    private static final String TAG = BroadCastReceiver1.class.getSimpleName();
    private static String KEY = "DATA_KEY";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle results = getResultExtras(true);
//        String trail = results.getString(KEY);
        String trail = intent.getStringExtra(KEY);
        Log.e(TAG, "BroadCastReceiver1 onReceive: >>" + trail);
        results.putString(KEY, trail + "->" + " Singh");
    }
}