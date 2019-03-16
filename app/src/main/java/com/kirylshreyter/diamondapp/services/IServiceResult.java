package com.kirylshreyter.diamondapp.services;

import org.json.JSONObject;

import java.util.List;

public interface IServiceResult {
    JSONObject data();

    void setData(JSONObject data);

    List<String> getErrors();

    void addError(String error);
}
