package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SwimmingTimeAdaptor extends ArrayAdapter<SwimmingTime> {

    private Context context;
    private int resource;

    public SwimmingTimeAdaptor(@NonNull Context context, int resource, @NonNull List<SwimmingTime> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;//this is the item row resource ,the design for each row
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null)
            view= LayoutInflater.from(context).inflate(resource,parent,false);
        SwimmingTime swimmingTime =getItem(position);//method from the android studio , not related to item object
        if(swimmingTime!=null) {
            TextView Date= view.findViewById(R.id.date);
            TextView Time = view.findViewById(R.id.time);
            TextView Pool= view.findViewById(R.id.pool);
            TextView Distance= view.findViewById(R.id.distance);
            TextView Stroke= view.findViewById(R.id.stroke);
            Date.setText(swimmingTime.getDate());
            Time.setText(swimmingTime.getTime());
            Pool.setText(swimmingTime.getPool());
            Distance.setText(swimmingTime.getDistance());
            Stroke.setText(swimmingTime.getStroke());
        }
        return view;
    }
}
