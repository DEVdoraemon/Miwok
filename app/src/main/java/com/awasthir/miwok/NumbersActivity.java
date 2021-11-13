// package that is unique among all android packages
package com.awasthir.miwok;

// import things that are necessary to run the project
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

// inherit the NumbersActivity and it's modify some abstract behaviors from AppCompatActivity
public class NumbersActivity extends AppCompatActivity {

    // Override abstract function to modify the onCreate behavior of Numbers Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Ini
        ArrayList<Word> Words = new ArrayList<Word>();

        Words.add(new Word("One", " miwok One"));
        Words.add(new Word("Two", " miwok Two"));
        Words.add(new Word("Three", " miwok Three"));
        Words.add(new Word("Four", " miwok Four"));
        Words.add(new Word("Five", " miwok Five"));
        Words.add(new Word("Six", " miwok Six"));
        Words.add(new Word("Seven", " miwok Seven"));
        Words.add(new Word("Eight", " miwok Eight"));
        Words.add(new Word("Nine", " miwok Nine"));
        Words.add(new Word("White", " miwok Ten"));


        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);

    }
}