package com.example.densi.itmd455hw6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by densi on 2/26/2018.
 */

public class BoundServer extends Service {

    private final IBinder bBinder = new LBinder();

    public class LBinder extends Binder {
        BoundServer getService() {
            return BoundServer.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return bBinder;
    }

}
