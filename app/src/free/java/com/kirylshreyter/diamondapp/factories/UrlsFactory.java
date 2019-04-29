package com.kirylshreyter.diamondapp.factories;

import com.kirylshreyter.diamondapp.BuildConfig;

public class UrlsFactory {
    public static final String SERVER_ADDRESS = "http://" + BuildConfig.SERVER_PREFIX + "server.com/";
    private static final String SERVER = "SERVER";

    static String getUrl(String urlType) {
        if (urlType.equals(SERVER)) {
            return SERVER_ADDRESS;
        }
        return null;
    }
}
