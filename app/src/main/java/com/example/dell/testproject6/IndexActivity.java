package com.example.dell.testproject6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","进入主页面");
//        replacefragment(new ChooseAreaFragment());
        setContentView(R.layout.index_layout);
        ChooseAreaFragment chooseAreaFragment = (ChooseAreaFragment) getSupportFragmentManager()
                .findFragmentById(R.id.choose_area_fragment);

    }

    private void replacefragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.choose_area_fragment,fragment);
        transaction.commit();
    }
}
