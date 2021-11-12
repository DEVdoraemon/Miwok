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
        setContentView(R.layout.list_item);

        // Ini
        ArrayList<String> Words = new ArrayList<String>();

        Words.add("One");
        Words.add("Two");
        Words.add("Three");
        Words.add("Four");
        Words.add("Five");
        Words.add("Six");
        Words.add("Seven");
        Words.add("Eight");
        Words.add("Nine");
        Words.add("Ten");

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);

    }
}