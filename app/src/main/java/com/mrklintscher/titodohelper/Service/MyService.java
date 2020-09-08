package com.mrklintscher.titodohelper.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.mrklintscher.titodohelper.ServerManager;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyService extends Service {
    private static final String TAG = "NigthTeam";
    public static int default_port=8888;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: MyService");
        new Thread() {
            @Override
            public void run() {
                super.run();
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getByName("0.0.0.0");
                    Log.d(TAG, "onCreate: " + inetAddress.getHostAddress());
                    ServerManager serverManager = new ServerManager(getApplicationContext(), inetAddress, default_port);
                    serverManager.startServer();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}