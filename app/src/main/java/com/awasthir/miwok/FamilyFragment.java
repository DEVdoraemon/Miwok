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

public class FamilyFragment extends Fragment {


    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private final AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> releaseMediaPlayer();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) requireActivity().getSystemService(Context.AUDIO_SERVICE);

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


        WordAdapter listAdapter = new WordAdapter(getActivity(), Words);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Word word = Words.get(i);

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


    @Override
    public void onStop () {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer () {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }
}