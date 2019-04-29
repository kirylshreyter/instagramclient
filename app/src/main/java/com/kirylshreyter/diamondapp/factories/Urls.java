package com.kirylshreyter.diamondapp.factories;

public interface Urls {
    class Base {
        private static final String SERVER = "SERVER";

        public static String getServerUrl() {
            return UrlsFactory.getUrl(SERVER);
        }
    }
}
