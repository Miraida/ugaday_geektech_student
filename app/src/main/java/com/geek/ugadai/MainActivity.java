package com.geek.ugadai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geek.ugadai.fragments.StartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openStartFragment();
    }
    private void openStartFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,new StartFragment()).commit();
    }
}