package test.doosik.com.fakebroadcastreceiver.receiveclasses;

import android.content.Context;
import android.util.Log;

import test.doosik.com.fakebroadcastreceiver.FakeBroadcastReceiver;
import test.doosik.com.fakebroadcastreceiver.MainActivity;

/**
 * Created by dskim98 on 16. 8. 2..
 */
public class ThirdClass implements FakeBroadcastReceiver {
    @Override
    public void onReceive(Context context) {
        Log.e(MainActivity.LOGTAG, "ThirdClass.onReceive");
    }
}
