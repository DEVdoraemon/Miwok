package com.awasthir.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> Words = new ArrayList<>();

        Words.add(new Word("Black", " miwok Black"));
        Words.add(new Word("Blue", " miwok Blue"));
        Words.add(new Word("Green", " miwok Green"));
        Words.add(new Word("Violet", " miwok Violet"));
        Words.add(new Word("Crimson", " miwok Crimson"));
        Words.add(new Word("Red", " miwok Red"));
        Words.add(new Word("SkyBlue", " miwok SkyBlue"));
        Words.add(new Word("Pink", " miwok Pink"));
        Words.add(new Word("Grey", " miwok Grey"));
        Words.add(new Word("White", " miwok White"));

        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }
}
