package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.text.TextUtils.split;

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
        final Earthquake temp = getItem(position);

        /*

        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = temp.getUrl();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH, Uri.parse(url));
                getContext().startActivity(intent);
            }
        });

        */

        TextView mag = (TextView)listItem.findViewById(R.id.Magnitude);
        DecimalFormat newFormat = new DecimalFormat("0.0");
        String magnitude = newFormat.format(temp.getMagnitude());
        mag.setText(magnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(temp.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        String location = temp.getPlace();

        String primaryLocation;
        String locationOffset;

        if (location.contains(" of ")) {
            String[] parts = location.split(" of ");
            locationOffset = parts[0] + " of ";
            primaryLocation = parts[1];
        } else {
            locationOffset = "Near the ";
            primaryLocation = location;
        }
        TextView placeView = (TextView)listItem.findViewById(R.id.Place);
        placeView.setText(primaryLocation);
        TextView offsetView = (TextView)listItem.findViewById(R.id.LocationOffset);
        offsetView.setText(locationOffset);

        Date dateObj = new Date(temp.getTimeInMilliseconds());
        TextView date = (TextView)listItem.findViewById(R.id.Date);
        String formattedDate = formatDate(dateObj);
        date.setText(formattedDate);

        TextView time = (TextView)listItem.findViewById(R.id.Time);
        String formattedTime = formatTime(dateObj);
        time.setText(formattedTime);

        return listItem;

    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
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
