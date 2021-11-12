package com.awasthir.miwok;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        ArrayList<String> Words = new ArrayList<String>();

        Words.add("Black");
        Words.add("Blue");
        Words.add("Green");
        Words.add("Violet");
        Words.add("Crimson");
        Words.add("Red");
        Words.add("SkyBlue");
        Words.add("Pink");
        Words.add("Grey");
        Words.add("White");

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }
}
