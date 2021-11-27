package com.awasthir.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> Words = new ArrayList<>();

        Words.add(new Word("Papa", " miwok Papa", R.drawable.family_father, R.raw.family_father));
        Words.add(new Word("Mummi", " miwok Mummi", R.drawable.family_mother, R.raw.family_mother));
        Words.add(new Word("Dada", " miwok Dada", R.drawable.family_grandfather, R.raw.family_grandfather));
        Words.add(new Word("Dadi", " miwok Dadi", R.drawable.family_grandmother, R.raw.family_grandmother));
        Words.add(new Word("Bhaiya", " miwok Bhaiya", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        Words.add(new Word("Behan", " miwok Behan", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        Words.add(new Word("Mama", " miwok Mama", R.drawable.family_older_brother, R.raw.family_older_brother));
        Words.add(new Word("Mami", " miwok Mami", R.drawable.family_older_sister, R.raw.family_older_sister));
        Words.add(new Word("Chacha", " miwok Chacha", R.drawable.family_older_brother, R.raw.family_older_brother));
        Words.add(new Word("Chachi", " miwok Chachi", R.drawable.family_older_sister, R.raw.family_older_sister));


        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = Words.get(i);
                mMediaPlayer =  MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}