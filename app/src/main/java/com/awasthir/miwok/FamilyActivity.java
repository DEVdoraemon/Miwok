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

        Words.add(new Word("Papa", " miwok Papa", R.drawable.family_father));
        Words.add(new Word("Mummi", " miwok Mummi", R.drawable.family_mother));
        Words.add(new Word("Dada", " miwok Dada", R.drawable.family_grandfather));
        Words.add(new Word("Dadi", " miwok Dadi", R.drawable.family_grandmother));
        Words.add(new Word("Bhaiya", " miwok Bhaiya", R.drawable.family_younger_brother));
        Words.add(new Word("Bhabhi", " miwok Bhabhi", R.drawable.family_younger_sister));
        Words.add(new Word("Mama", " miwok Mama", R.drawable.family_older_brother));
        Words.add(new Word("Mami", " miwok Mami", R.drawable.family_older_sister));
        Words.add(new Word("Chacha", " miwok Chacha", R.drawable.family_older_brother));
        Words.add(new Word("Chachi", " miwok Chachi", R.drawable.family_older_sister));


        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }
}