package com.kirylshreyter.diamondapp.components.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kirylshreyter.diamondapp.R;
import com.kirylshreyter.diamondapp.common.Constants;

public class AboutFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        if (savedInstanceState != null) {
            loadFragmentState(savedInstanceState, view);
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        saveFragmentState(outState);
    }

    private void loadFragmentState(Bundle savedInstanceState, View view) {
        TextView text = view.findViewById(R.id.about_activity_text_view);
        ProgressBar progressBar = view.findViewById(R.id.about_activity_progress_bar);

        text.setText(savedInstanceState.getCharSequence(Constants.ABOUT_FRAGMENT_TEXT_VIEW_TEXT_KEY));
        text.setVisibility(savedInstanceState.getInt(Constants.ABOUT_FRAGMENT_TEXT_VIEW_VISIBILITY_KEY));
        progressBar.setVisibility(savedInstanceState.getInt(Constants.ABOUT_FRAGMENT_PROGRESS_BAR_VISIBILITY_KEY));
    }

    private void saveFragmentState(Bundle outState) {
        ProgressBar progressBar = getView().findViewById(R.id.about_activity_progress_bar);
        TextView text = getView().findViewById(R.id.about_activity_text_view);

        outState.putCharSequence(Constants.ABOUT_FRAGMENT_TEXT_VIEW_TEXT_KEY, text.getText());
        outState.putInt(Constants.ABOUT_FRAGMENT_TEXT_VIEW_VISIBILITY_KEY, text.getVisibility());
        outState.putInt(Constants.ABOUT_FRAGMENT_PROGRESS_BAR_VISIBILITY_KEY, progressBar.getVisibility());
    }
}
