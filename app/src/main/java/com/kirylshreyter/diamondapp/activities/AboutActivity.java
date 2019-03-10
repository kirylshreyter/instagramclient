package com.kirylshreyter.diamondapp.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.kirylshreyter.diamondapp.R;
import com.kirylshreyter.diamondapp.common.Actions;
import com.kirylshreyter.diamondapp.common.Constants;
import com.kirylshreyter.diamondapp.components.fragments.AboutFragment;
import com.kirylshreyter.diamondapp.components.serviceconnections.AboutServiceConnection;
import com.kirylshreyter.diamondapp.components.services.AboutService;
import com.kirylshreyter.diamondapp.services.IServiceResult;
import com.kirylshreyter.diamondapp.services.impl.ServiceResult;

import org.json.JSONException;
import org.json.JSONObject;

public class AboutActivity extends BaseActivity {
    private IntentFilter filter = new IntentFilter(Actions.CUSTOM_ACTION);
    private ServiceConnection connection = new AboutServiceConnection(this);
    private Intent aboutServiceIntent;
    private BroadcastReceiver receiver;
    private Fragment aboutFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        beforeCreate();
        setFragment(savedInstanceState);
        replaceFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beforeDestroy();
    }

    private void setFragment(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            aboutFragment = getSupportFragmentManager().findFragmentByTag(Constants.ABOUT_FRAGMENT_KEY);
        } else {
            aboutFragment = new AboutFragment();
        }
    }

    private void handleResult(IServiceResult result) {
        findViewById(R.id.about_activity_progress_bar).setVisibility(View.GONE);
        TextView view = findViewById(R.id.about_activity_text_view);
        view.setText(result.data().optString(Constants.MESSAGE_STRING));
        view.setVisibility(View.VISIBLE);
    }

    private void registerReceiver() {
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                IServiceResult result = new ServiceResult();
                JSONObject resultObject = new JSONObject();
                try {
                    resultObject.put(Constants.MESSAGE_STRING, intent.getStringExtra(Constants.RESULT_STRING));
                } catch (JSONException exception) {
                    result.addError(Constants.JSON_PUT_ERROR);
                }
                result.setData(resultObject);
                handleResult(result);
            }
        };
        registerReceiver(receiver, filter);
    }

    private void beforeCreate() {
        aboutServiceIntent = new Intent(this, AboutService.class);
        bindService(aboutServiceIntent, connection, BIND_AUTO_CREATE);
        registerReceiver();
        startService(aboutServiceIntent);
    }

    private void beforeDestroy() {
        unbindService(connection);
        unregisterReceiver(receiver);
        stopService(aboutServiceIntent);
    }

    private void replaceFragment() {
        if (!aboutFragment.isInLayout())
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.daily_digest, aboutFragment, Constants.ABOUT_FRAGMENT_KEY)
                    .commit();
    }
}

