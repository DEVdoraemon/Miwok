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

        Words.add(new Word("Black", " miwok Black", R.drawable.color_black));
        Words.add(new Word("Blue", " miwok Blue", R.drawable.color_black));
        Words.add(new Word("Green", " miwok Green", R.drawable.color_green));
        Words.add(new Word("Brown", " miwok Brown", R.drawable.color_brown));
        Words.add(new Word("Yellow", " miwok Yellow", R.drawable.color_dusty_yellow));
        Words.add(new Word("Red", " miwok Red", R.drawable.color_red));
        Words.add(new Word("SkyBlue", " miwok SkyBlue", android.R.color.holo_blue_light));
        Words.add(new Word("Pink", " miwok Pink", R.drawable.color_red));
        Words.add(new Word("Gray", " miwok Gray", R.drawable.color_gray));
        Words.add(new Word("White", " miwok White", R.color.white));

        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }
}
