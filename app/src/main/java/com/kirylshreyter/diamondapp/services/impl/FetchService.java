package com.kirylshreyter.diamondapp.services.impl;

import android.util.Log;

import com.kirylshreyter.diamondapp.common.Constants;
import com.kirylshreyter.diamondapp.common.Tags;
import com.kirylshreyter.diamondapp.services.IBaseService;
import com.kirylshreyter.diamondapp.services.IServiceResult;

import org.json.JSONException;
import org.json.JSONObject;

public class FetchService implements IBaseService {
    @Override
    public IServiceResult fetchData() {
        IServiceResult result = new ServiceResult();
        JSONObject resultObject = new JSONObject();
        try {
            resultObject.put(Constants.MESSAGE_STRING, Constants.JSON_DUMMY_RESULT);
        } catch (JSONException exception) {
            result.addError(exception.getMessage());
            Log.d(Tags.JSON_EXCEPTION.name(), exception.getMessage());
        }
        result.setData(resultObject);
        return result;
    }
}
