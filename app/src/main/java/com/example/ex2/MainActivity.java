package com.example.ex2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ex2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK){
                        Intent recievedIntent = result.getData();
                        binding.text.setText(recievedIntent.getExtras().get("title").toString());
                    }
                    else {
                        binding.text.setText("DataFailed");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView textView = findViewById(R.id.text);
        textView.setText(R.string.constraintlayout);

        ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource(R.drawable.amogus);

        binding.text.setText(R.string.constraintlayout);
        binding.image.setImageResource(R.drawable.amogus);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button test", "Success");
            }
        });
    }
    public void onClick(View view) {
        //Log.i("Button test", "Pressed");
        Intent intent = new Intent(this, Activity2.class).putExtra("title", "sendData");
        mStartForResult.launch(intent);
    }
}