package com.kirylshreyter.diamondapp.components.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.kirylshreyter.diamondapp.common.Actions;
import com.kirylshreyter.diamondapp.common.Constants;
import com.kirylshreyter.diamondapp.components.binders.AboutBinder;
import com.kirylshreyter.diamondapp.services.IBaseService;
import com.kirylshreyter.diamondapp.services.IServiceResult;
import com.kirylshreyter.diamondapp.services.impl.FetchService;

public class AboutService extends Service {
    private Binder binder = new AboutBinder(this);
    private IBaseService fetchService = new FetchService();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendBroadcast(new Intent(Actions.CUSTOM_ACTION) {
                    {
                        putExtra(Constants.RESULT_STRING, fetchService.fetchData().data().optString(Constants.MESSAGE_STRING));
                    }
                });
            }
        }, Constants.SERVICE_DELAY);
        return super.onStartCommand(intent, flags, startId);
    }

    public IServiceResult getResult() {
        return fetchService.fetchData();
    }
}
