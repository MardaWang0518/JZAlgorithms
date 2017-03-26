package com.juwan.jzalgorithms.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.juwan.jzalgorithms.R;
import com.juwan.jzalgorithms.databinding.ActivityMainBinding;
import com.juwan.jzalgorithms.model.Algorithm;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mMainBinding;

    private AlgorithmsListAdapter mAlgorithmsListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setAlgorithmsListView();
    }

    private void setAlgorithmsListView() {
        mAlgorithmsListAdapter = new AlgorithmsListAdapter(this);
        mMainBinding.algorithmsListView.setAdapter(mAlgorithmsListAdapter);
        ArrayList<Algorithm> algorithmses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Algorithm algorithm = new Algorithm();
            algorithm.setName(i+"");
            algorithmses.add(algorithm);
        }
        mAlgorithmsListAdapter.replaceContent(algorithmses);
    }

    @Override
    protected void onResume() {
        super.onResume();
        main();
    }

    static {
        System.loadLibrary("native-lib");
    }

    public native void main();
}
