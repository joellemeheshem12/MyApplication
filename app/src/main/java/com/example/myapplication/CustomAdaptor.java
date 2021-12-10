package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdaptor extends ArrayAdapter<Train> {

    private Context context;
    private int resource;

    public CustomAdaptor(@NonNull Context context, int resource, @NonNull List<Train> objects) {
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
        Train train =getItem(position);//method from the android studio , not related to item object
        if(train!=null) {
            ImageView imageView = view.findViewById(R.id.imageItem);
            TextView textViewDescription = view.findViewById(R.id.textViewDesc);
            Button itemButton = view.findViewById(R.id.itemButton);
            itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "This item was added to shopping cart", Toast.LENGTH_LONG).show();
                }
            });
        }
        return view;
    }
}
