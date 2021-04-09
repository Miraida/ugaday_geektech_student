package com.geek.ugadai.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.geek.ugadai.R;

import java.util.ArrayList;

public class StartFragment extends GeneralFragment {
    private Button btn_start, btn_exit;

    public StartFragment() {
        super(R.layout.fragment_start);
    }

    @Override
    protected void initClickers() {
        btn_start.setOnClickListener(v -> sendLevels());
        btn_exit.setOnClickListener(v -> requireActivity().finish());
    }

    @Override
    protected void initViews(View view) {
        btn_start = view.findViewById(R.id.btn_start);
        btn_exit = view.findViewById(R.id.btn_exit);
    }

    private void sendLevels() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(Keys.LIST_LEVEL_KEY.toString(), getLevelsList());
        LevelFragment levelFragment = new LevelFragment();
        levelFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, levelFragment).commit();
    }

    private ArrayList<String> getLevelsList() {
        ArrayList<String> levels = new ArrayList<>();
        levels.add("1");
        levels.add("2");
        levels.add("3");
        return levels;
    }

}