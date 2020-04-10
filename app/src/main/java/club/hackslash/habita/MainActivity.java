package club.hackslash.habita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MyBattery myBattery;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBattery= new MyBattery();
    }
    @Override
    protected void onStart(){
        super.onStart();
        IntentFilter intentFilter= new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);





        registerReceiver(myBattery,intentFilter);
        //to register broadcast receiver
    }
    @Override
    protected void onStop(){
        super.onStop();
        unregisterReceiver(myBattery);

    }





}
