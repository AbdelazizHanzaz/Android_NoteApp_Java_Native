package com.nassimo.noteapp.ui;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


import android.view.View;

import com.nassimo.noteapp.databinding.ActivityTabedBinding;
import com.nassimo.noteapp.ui.ui.main.SectionsPagerAdapter;

public class TabedActivity extends AppCompatActivity {

    private ActivityTabedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTabedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}