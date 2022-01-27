package com.example.hometaskandroid_03_06;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.example.hometaskandroid_03_06.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public static boolean isNotClicked=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        if (isNotClicked) {
            getSupportFragmentManager().beginTransaction().add(R.id.frame1, new FirstFragment()).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.frame2, new SecondFragment()).commit();
        }
    }
}