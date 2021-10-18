package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;

public class MySer extends Service {
    private static final String TAG="MyService";
    public MySer() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"Oncreate(),호출됨");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"OnStartCommand(),호출됨");
        if(intent==null){
            return Service.START_STICKY;

        }else{
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);

    }
    private void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");
        Log.d(TAG,"전달받은 데이터"+command+" ,"+name);

        try{
            Thread.sleep(5000);
        }catch(Exception e){}
        Intent showIntent = new Intent(getApplicationContext(),MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                            Intent.FLAG_ACTIVITY_SINGLE_TOP|
                            Intent.FLAG_ACTIVITY_CLEAR_TOP);
        showIntent.putExtra("command","show");
        showIntent.putExtra("name",name+"from Service");
        startActivity(showIntent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroy(),호출됨");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

}