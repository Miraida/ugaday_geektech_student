package com.geek.ugadai.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class GeneralFragment extends Fragment {
    int contentLayoutId;

    public GeneralFragment(int contentLayoutId) {
        this.contentLayoutId = contentLayoutId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(contentLayoutId, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initClickers();
    }

    protected abstract void initClickers();

    protected abstract void initViews(View view);

}
