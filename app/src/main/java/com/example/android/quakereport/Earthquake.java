package com.example.android.quakereport;

/**
 * Created by pulkit on 3/2/2018.
 */

public class Earthquake {

    Double mMagnitude;
    String mPlace;
    Long mTimeInMilliseconds;
    String mUrl;

    Earthquake(Double Magnitude, String Place, Long TimeInMilliseconds, String Url) {
        mMagnitude = Magnitude;
        mPlace = Place;
        mTimeInMilliseconds = TimeInMilliseconds;
        mUrl = Url;
    }

    Double getMagnitude() {
        return mMagnitude;
    }

    String getPlace() {
        return mPlace;
    }

    Long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    String getUrl() {
        return mUrl;
    }
}
