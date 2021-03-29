package com.example.mvvmshoppingcart.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mvvmshoppingcart.R;
import com.example.mvvmshoppingcart.ViewModel.MainViewModel;
import com.example.mvvmshoppingcart.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        viewModel = new MainViewModel(this);

        binding.setViewModel(viewModel);
    }
}