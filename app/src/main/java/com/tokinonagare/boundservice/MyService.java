package com.tokinonagare.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder buckysBlinder = new MylocalBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return buckysBlinder;
    }

    public String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.TAIWAN);
        return (dateFormat.format(new Date()));
    }

    public class MylocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

}
