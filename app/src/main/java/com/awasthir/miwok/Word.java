package com.awasthir.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    public static final int NO_IMAGE_PROVIDED = -1;

    /**
     * @param defaultTranslate is default translation for each word provided
     *
     * @param miwokTranslation is miwok translation for each word provided
     */

    // we can make the changes in files if we don't want any specific activity to play audio files
    // like if we don't want phrases activity to play audio files
    public Word (String defaultTranslate, String miwokTranslation) {
        setMiwokTranslation (miwokTranslation);
        setDefaultTranslation (defaultTranslate);
    }

    public Word (String defaultTranslate, String miwokTranslation, int audioResourceId) {
        setMiwokTranslation (miwokTranslation);
        setDefaultTranslation (defaultTranslate);
        mAudioResourceId = audioResourceId;
    }

    public Word (String defaultTranslate, String miwokTranslation, int imageResourceId, int audioResourceId) {
        setMiwokTranslation (miwokTranslation);
        setDefaultTranslation (defaultTranslate);
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getMiwokTranslation () {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation () {
        return mDefaultTranslation;
    }

    public int getImageResourceId () {
        return mImageResourceId;
    }

    public int getmAudioResourceId () {
        return mAudioResourceId;
    }

    public void setMiwokTranslation (String miwokTranslation) {
        mMiwokTranslation = miwokTranslation;
    }

    public void setDefaultTranslation (String defaultTranslation) {
        mDefaultTranslation = defaultTranslation;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
