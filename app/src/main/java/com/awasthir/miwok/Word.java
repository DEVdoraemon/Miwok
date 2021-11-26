package com.awasthir.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public static final int NO_IMAGE_PROVIDED = -1;

    public Word (String defaultTranslate, String miwokTranslation) {
        setMiwokTranslation (miwokTranslation);
        setDefaultTranslation (defaultTranslate);
    }

    public Word (String defaultTranslate, String miwokTranslation, int imageResourceId) {
        setMiwokTranslation (miwokTranslation);
        setDefaultTranslation (defaultTranslate);
        mImageResourceId = imageResourceId;
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
