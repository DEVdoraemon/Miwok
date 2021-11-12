package com.awasthir.miwok;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        ArrayList<String> Words = new ArrayList<String>();

        Words.add("Hi!");
        Words.add("Hello");
        Words.add("Bye");
        Words.add("Good night");
        Words.add("Good Morning");
        Words.add("Good Noon");
        Words.add("Good Afternoon");
        Words.add("Goodbye");
        Words.add("Alas!");
        Words.add("Oh!");

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }
}
