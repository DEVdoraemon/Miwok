package com.awasthir.miwok;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        ArrayList<String> Words = new ArrayList<String>();

        Words.add("Papa");
        Words.add("Mummi");
        Words.add("Dada");
        Words.add("Dadi");
        Words.add("Bhaiya");
        Words.add("Bhabhi");
        Words.add("Mama");
        Words.add("Mami");
        Words.add("Chacha");
        Words.add("Chachi");


        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }
}