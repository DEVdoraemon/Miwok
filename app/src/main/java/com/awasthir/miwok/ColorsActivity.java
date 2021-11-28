package com.awasthir.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> releaseMediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> Words = new ArrayList<>();

        Words.add(new Word("Black", " miwok Black", R.drawable.color_black, R.raw.color_black));
        Words.add(new Word("Blue", " miwok Blue", R.drawable.color_black, R.raw.color_black));
        Words.add(new Word("Green", " miwok Green", R.drawable.color_green, R.raw.color_green));
        Words.add(new Word("Brown", " miwok Brown", R.drawable.color_brown, R.raw.color_brown));
        Words.add(new Word("Yellow", " miwok Yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        Words.add(new Word("Red", " miwok Red", R.drawable.color_red, R.raw.color_red));
        Words.add(new Word("SkyBlue", " miwok SkyBlue", R.drawable.color_black, R.raw.color_black));
        Words.add(new Word("Pink", " miwok Pink", R.drawable.color_red, R.raw.color_red));
        Words.add(new Word("Gray", " miwok Gray", R.drawable.color_gray, R.raw.color_gray));
        Words.add(new Word("White", " miwok White", R.drawable.color_black, R.raw.color_white));

        WordAdapter listAdapter = new WordAdapter(this, Words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = Words.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
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
        }
    }
}
