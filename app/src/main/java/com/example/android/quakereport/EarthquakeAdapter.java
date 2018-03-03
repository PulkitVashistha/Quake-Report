package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pulkit on 3/2/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if(listItem==null){
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.my_layout,parent,false);
        }
        Earthquake temp = getItem(position);

        TextView mag = (TextView)listItem.findViewById(R.id.magnitude);
        mag.setText(temp.getMagnitude());

        TextView place = (TextView)listItem.findViewById(R.id.Place);
        place.setText(temp.getPlace());

        Date dateObj = new Date(temp.getTimeInMilliseconds());
        TextView date = (TextView)listItem.findViewById(R.id.Date);
        String formattedDate = formatDate(dateObj);
        date.setText(formattedDate);

        TextView time = (TextView)listItem.findViewById(R.id.Time);
        String formattedTime = formatTime(dateObj);
        time.setText(formattedTime);

        return listItem;

    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
