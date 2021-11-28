// package that is unique among all android packages
package com.awasthir.miwok;

// import things that are necessary to run the project
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


// inherit the NumbersActivity and it's modify some abstract behaviors from AppCompatActivity
public class NumbersActivity extends AppCompatActivity {


    // Override abstract function to modify the onCreate behavior of Numbers Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new NumbersFragment())
                .commit();
    }
}