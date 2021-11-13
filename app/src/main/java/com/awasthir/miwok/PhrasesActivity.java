package com.awasthir.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> Words = new ArrayList<>();

        Words.add(new Word("Hi!", " miwok Hi!"));
        Words.add(new Word("Hello", " miwok Hello"));
        Words.add(new Word("Bye", " miwok Bye"));
        Words.add(new Word("Good night", " miwok Good night"));
        Words.add(new Word("Good Morning", " miwok Good Morning"));
        Words.add(new Word("Good Noon", " miwok Good Noon"));
        Words.add(new Word("Good Afternoon", " miwok Good Afternoon"));
        Words.add(new Word("Goodbye", " miwok Goodbye"));
        Words.add(new Word("Alas!", " miwok Alas!"));
        Words.add(new Word("Oh!", " miwok Oh!"));


        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }
}
