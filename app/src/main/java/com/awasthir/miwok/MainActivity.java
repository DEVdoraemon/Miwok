package com.awasthir.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    // Override onCreate method of AppCompatActivity which is an abstract method
    // unimplemented method
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // pass the saved instance state in which the app is suspended
        super.onCreate(savedInstanceState);

        // set the content view to main activity xml file
        setContentView(R.layout.activity_main);


        ViewPager viewPager = findViewById(R.id.viewpager);

        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

/*
//        // find the id of numbers textview
//        TextView numbers = findViewById(R.id.numbers);
//        // set the onCLickListener on numbers Textview
//        numbers.setOnClickListener(v -> {
//            // create an intent of numbers TextView
//            Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
//            startActivity(numbersIntent);
//        });
//
//
//        TextView colors = findViewById(R.id.colors);
//        colors.setOnClickListener(v -> {
//            Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
//            startActivity(colorsIntent);
//        });
//
//
//        TextView family = findViewById(R.id.family);
//        family.setOnClickListener(v -> {
//            Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
//            startActivity(familyIntent);
//        });
//
//
//        TextView phrases = findViewById(R.id.phrases);
//        phrases.setOnClickListener(v -> {
//            Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
//            startActivity(phrasesIntent);
//        });
 */
    }
}