package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by pulkit on 3/24/2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

   String mUrl;

    public EarthquakeLoader(Context context, String Url) {
        super(context);
        mUrl=Url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.e("EarthquakeLoader","onStartLoading");
    }

    @Override
    public List<Earthquake> loadInBackground() {

        Log.e("EarthquakeLoader", "loadInBackground");
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (mUrl == null) {
            return null;
        }

        List<Earthquake> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }


}
