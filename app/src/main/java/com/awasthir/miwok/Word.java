package com.awasthir.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word (String defaultTranslate, String miwokTranslation) {
        setMiwokTranslation (miwokTranslation);
        setDefaultTranslation (defaultTranslate);
    }

    public String getMiwokTranslation () {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation () {
        return mDefaultTranslation;
    }

    public void setMiwokTranslation (String miwokTranslation) {
        mMiwokTranslation = miwokTranslation;
    }

    public void setDefaultTranslation (String defaultTranslation) {
        mDefaultTranslation = defaultTranslation;
    }
}
