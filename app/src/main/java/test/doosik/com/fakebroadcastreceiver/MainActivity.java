package test.doosik.com.fakebroadcastreceiver;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String LOGTAG = "LOGTAG";
    public static final String[] CLASSES = {"test.doosik.com.fakebroadcastreceiver.receiveclasses.FirstClass",
                                            "test.doosik.com.fakebroadcastreceiver.receiveclasses.SecondClass",
                                            "test.doosik.com.fakebroadcastreceiver.receiveclasses.ThirdClass"};

    Button button;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(context);
            }
        });

    }

    private void sendBroadcast(Context context) {
        for (String address : CLASSES) {
            Class clazz = null;
            try {
                clazz = Class.forName(address);
                FakeBroadcastReceiver fbr = (FakeBroadcastReceiver) clazz.newInstance();
                fbr.onReceive(context);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
