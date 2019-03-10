package com.kirylshreyter.diamondapp.components.binders;

import android.os.Binder;

import com.kirylshreyter.diamondapp.components.services.AboutService;

public class AboutBinder extends Binder {
    private AboutService service;

    public AboutBinder(AboutService service) {
        this.service = service;
    }

    public AboutService getService() {
        return this.service;
    }
}
