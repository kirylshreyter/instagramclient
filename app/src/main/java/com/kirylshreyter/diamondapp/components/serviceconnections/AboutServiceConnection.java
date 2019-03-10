package com.kirylshreyter.diamondapp.components.serviceconnections;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.kirylshreyter.diamondapp.common.Tags;

public class AboutServiceConnection implements ServiceConnection {
    private Context context;

    public AboutServiceConnection(Context context) {
        this.context = context;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d(Tags.SERVICE_CONNECTED.name(), "onServiceConnected() called with: name = [" + name + "], service = [" + service + "]");

        //((AboutActivity) context).handleResult(((AboutBinder) service).getService().getResult());
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d(Tags.SERVICE_DISCONNECTED.name(), "onServiceDisconnected() called with: name = [" + name + "]");
    }
}
