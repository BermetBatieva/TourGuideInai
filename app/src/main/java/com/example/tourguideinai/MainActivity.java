package com.example.tourguideinai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Fancy Buttons
        Utils.createFancyButton(MainActivity.this, R.id.museums_btn, R.drawable.ic_museums, getText(R.string.cat_museums));
        Utils.createFancyButton(MainActivity.this, R.id.parks_btn, R.drawable.ic_parks, getText(R.string.cat_parks));
        Utils.createFancyButton(MainActivity.this, R.id.palaces_btn, R.drawable.ic_palaces, getText(R.string.cat_palaces));
        Utils.createFancyButton(MainActivity.this, R.id.monuments_btn, R.drawable.ic_monuments, getText(R.string.cat_monuments));

        // Attach Activities for Each Button
        Utils.openCategoriesActivity(MainActivity.this, R.id.museums_btn, 0);
        Utils.openCategoriesActivity(MainActivity.this, R.id.parks_btn, 1);
        Utils.openCategoriesActivity(MainActivity.this, R.id.palaces_btn, 2);
        Utils.openCategoriesActivity(MainActivity.this, R.id.monuments_btn, 3);
    }

}