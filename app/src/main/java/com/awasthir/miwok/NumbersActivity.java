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

        Words.add(new Word("One", " miwok One", R.drawable.number_one));
        Words.add(new Word("Two", " miwok Two", R.drawable.number_two));
        Words.add(new Word("Three", " miwok Three", R.drawable.number_three));
        Words.add(new Word("Four", " miwok Four", R.drawable.number_four));
        Words.add(new Word("Five", " miwok Five", R.drawable.number_five));
        Words.add(new Word("Six", " miwok Six", R.drawable.number_six));
        Words.add(new Word("Seven", " miwok Seven", R.drawable.number_seven));
        Words.add(new Word("Eight", " miwok Eight", R.drawable.number_eight));
        Words.add(new Word("Nine", " miwok Nine", R.drawable.number_nine));
        Words.add(new Word("White", " miwok Ten", R.drawable.number_ten));


        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);

    }
}