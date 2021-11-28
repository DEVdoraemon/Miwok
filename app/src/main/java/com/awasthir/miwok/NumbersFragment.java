package com.awasthir.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener =
            mediaPlayer -> releaseMediaPlayer();

    // Override abstract function to modify the onCreate behavior of Numbers Activity

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Ini
        final ArrayList<Word> Words = new ArrayList<>();

        Words.add(new Word("One", " miwok One", R.drawable.number_one, R.raw.number_one));
        Words.add(new Word("Two", " miwok Two", R.drawable.number_two, R.raw.number_two));
        Words.add(new Word("Three", " miwok Three", R.drawable.number_three, R.raw.number_three));
        Words.add(new Word("Four", " miwok Four", R.drawable.number_four, R.raw.number_four));
        Words.add(new Word("Five", " miwok Five", R.drawable.number_five, R.raw.number_five));
        Words.add(new Word("Six", " miwok Six", R.drawable.number_six, R.raw.number_six));
        Words.add(new Word("Seven", " miwok Seven", R.drawable.number_seven, R.raw.number_seven));
        Words.add(new Word("Eight", " miwok Eight", R.drawable.number_eight, R.raw.number_eight));
        Words.add(new Word("Nine", " miwok Nine", R.drawable.number_nine, R.raw.number_eight));
        Words.add(new Word("Ten", " miwok Ten", R.drawable.number_ten, R.raw.number_ten));


        WordAdapter listAdapter = new WordAdapter(getActivity(), Words);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(listAdapter);

        // click listener is defined inline,
        // it's methods can only reference local variables is they are declared final
        // or it can ref. global variables in the numbers activity
        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Word word = Words.get(position);

            releaseMediaPlayer();

            int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener,
                    AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

        return rootView;
    }

    // don't comment otherwise app will crash unexpectedly
    @Override
    public void onStop () {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer () {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }


}