package com.delhiexmp.dilli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CardAdapter extends ArrayAdapter {

    public CardAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_card, parent, false
            );
        }

        Place place = (Place) getItem(position);

        // Setting up Image
        ImageView imageView = listViewItem.findViewById(R.id.imageView);
        imageView.setImageResource(place.getPhotoResourceId());


        // Setting up Name
        TextView nameText = (TextView) listViewItem.findViewById(R.id.name_text_view);
        nameText.setText(place.getName());

        // Setting up timings
        TextView timingsText = (TextView) listViewItem.findViewById(R.id.timings_textView);
        timingsText.setText(place.getTimings());

        // Setting up Location
        TextView locationText = (TextView) listViewItem.findViewById(R.id.location_textView);
        locationText.setText(place.getLocation());

        return listViewItem;
    }


}
