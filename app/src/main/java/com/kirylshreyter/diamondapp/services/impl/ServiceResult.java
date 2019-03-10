package com.kirylshreyter.diamondapp.services.impl;

import com.kirylshreyter.diamondapp.services.IServiceResult;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServiceResult implements IServiceResult {
    private List<String> errors = new ArrayList<>();
    private JSONObject data;

    @Override
    public List<String> getErrors() {
        return this.errors;
    }

    @Override
    public void addError(String error) {
        this.errors.add(error);
    }

    public ServiceResult() {
    }

    public ServiceResult(JSONObject data) {
        this.data = data;
    }

    @Override
    public JSONObject data() {
        return this.data;
    }

    @Override
    public void setData(JSONObject data) {
        this.data = data;
    }
}
