package com.example.android.quakereport;

/**
 * Created by pulkit on 3/2/2018.
 */

public class Earthquake {

    String mMagnitude;
    String mPlace;
    Long mTimeInMilliseconds;

    Earthquake(String Magnitude, String Place, Long TimeInMilliseconds){
        mMagnitude =Magnitude;
        mPlace=Place;
        mTimeInMilliseconds=TimeInMilliseconds;
    }

    String getMagnitude(){
        return mMagnitude ;
    }

    String getPlace(){
        return mPlace;
    }

    Long getTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }

}
