package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ex2.databinding.Activity2Binding;
import com.example.ex2.databinding.ActivityMainBinding;

public class Activity2 extends AppCompatActivity {
    Intent returnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity2Binding binding = Activity2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.text.setText(getIntent().getExtras().get("title").toString());
        returnIntent = new Intent().putExtra("title", "returnedData");
    }
    public void onClick(View view){
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}