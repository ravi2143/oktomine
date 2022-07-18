package com.oktomine.mining.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.oktomine.mining.R;

public class RefferAFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reffer_afriend);

        findViewById(R.id.refs_back).setOnClickListener(view -> finish());
    }
}