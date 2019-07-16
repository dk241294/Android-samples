package com.example.miwok;

public class Word {

        private String mDefaultTranslation;


        private String mMiwokTranslation;
        private int mImagesourceId = NO_IMAGE_PROVIDED;
        private static final int NO_IMAGE_PROVIDED=0;


        public Word(String defaultTranslation, String miwokTranslation) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
        }
    public Word(String defaultTranslation, String miwokTranslation,int imagesourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImagesourceId = imagesourceId;
    }

        public String getDefaultTranslation() {
            return mDefaultTranslation;
        }


        public String getMiwokTranslation() {
            return mMiwokTranslation;
        }
        public int getImagesourceId(){
            return mImagesourceId;
        }
        public boolean hasImage(){
            return mImagesourceId !=NO_IMAGE_PROVIDED;
        }


    }

