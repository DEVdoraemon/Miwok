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
        setContentView(R.layout.word_list);

        ArrayList<Word> Words = new ArrayList<>();

        Words.add(new Word("Papa", " miwok Papa"));
        Words.add(new Word("Mummi", " miwok Mummi"));
        Words.add(new Word("Dada", " miwok Dada"));
        Words.add(new Word("Dadi", " miwok Dadi"));
        Words.add(new Word("Bhaiya", " miwok Bhaiya"));
        Words.add(new Word("Bhabhi", " miwok Bhabhi"));
        Words.add(new Word("Mama", " miwok Mama"));
        Words.add(new Word("Mami", " miwok Mami"));
        Words.add(new Word("Chacha", " miwok Chacha"));
        Words.add(new Word("Chachi", " miwok Chachi"));


        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }
}