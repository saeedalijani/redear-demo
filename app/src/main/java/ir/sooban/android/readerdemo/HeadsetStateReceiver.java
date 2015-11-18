package ir.sooban.android.readerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by rajabzz on 7/7/15.
 */
public class HeadsetStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            Log.d("myApp", "plugged in");
        } else {
            Log.d("myApp", "plugged out");
        }
    }
}
