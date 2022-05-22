package com.example.tourguideinai;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LandmarkAdapter extends ArrayAdapter<Landmark> {

    public LandmarkAdapter(Activity context, ArrayList<Landmark> landmarks) {
        super(context, 0, landmarks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get or Inflate the Category Item View
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        // Get current Landmark object from the ArrayList
        Landmark currentLandmark = getItem(position);

        // Set the Category Item Title
        Utils.fillText(listItemView, R.id.cat_item_title, currentLandmark.getLandmarkName());

        // Set the Category Item Address
        Utils.fillText(listItemView, R.id.cat_item_address, currentLandmark.getAddress());

        // Set the Category Item Background Image
        Utils.fillImage(listItemView, R.id.cat_bg_image, currentLandmark.getImageId());

        // Return the Fully Assembled Category Item
        return listItemView;
    }
}
