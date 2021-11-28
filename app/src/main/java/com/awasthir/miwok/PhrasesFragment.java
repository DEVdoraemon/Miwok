package com.awasthir.miwok;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

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


        WordAdapter listAdapter = new WordAdapter(getActivity(), Words);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(listAdapter);


        return rootView;
    }
}