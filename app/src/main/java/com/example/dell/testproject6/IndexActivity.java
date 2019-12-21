package com.example.dell.testproject6;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
        setContentView(R.layout.index_layout);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("weather",null) != null){
            Log.d("MainActivity","进入主页面的prefs不等于空");
            Intent intent = new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();
        }else{
            Log.d("MainActivity","进入主页面的prefs等于空");
//          ChooseAreaFragment chooseAreaFragment = (ChooseAreaFragment) getSupportFragmentManager().findFragmentById(R.id.choose_area_fragment);
            ChooseAreaFragment chooseAreaFragment = new ChooseAreaFragment();

        }

    }

}
