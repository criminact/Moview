package com.noobcode.brief.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.noobcode.brief.R;

public class MainActivity extends AppCompatActivity {

    private NavController nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = Navigation.findNavController(MainActivity.this, R.id.fragment);
        NavigationUI.setupActionBarWithNavController(MainActivity.this, nav);

    }
}
