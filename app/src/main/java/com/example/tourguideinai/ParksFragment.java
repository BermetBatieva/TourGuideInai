package com.example.tourguideinai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ParksFragment extends Fragment {

    public ParksFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get String Array Resources from the Strings File
        String[] parksNames = getResources().getStringArray(R.array.parks_names);
        String[] parksAddresses = getResources().getStringArray(R.array.parks_addresses);
        String[] parksDescriptions = getResources().getStringArray(R.array.parks_descriptions);
        String[] parksHours = getResources().getStringArray(R.array.parks_hours);
        String[] parksPhones = getResources().getStringArray(R.array.parks_phones);

        // Add Google Maps URIs
        String[] parksMapUris = {
                "https://www.google.com/maps/dir/42.8310193,74.6154911/RJG3%2BGMV+%D0%9F%D0%B0%D1%80%D0%BA+%D0%BF%D0%BE%D0%B1%D0%B5%D0%B4%D1%8B,+%D0%91%D0%B8%D1%88%D0%BA%D0%B5%D0%BA/@42.8292148,74.6047706,16z/data=!3m1!4b1!4m17!1m7!3m6!1s0x389eb6060fd12677:0xc94556213dba6b02!2z0J_QsNGA0Log0L_QvtCx0LXQtNGL!8m2!3d42.8263617!4d74.604174!15sCgrQv9Cw0YDQutC4kgEEcGFyaw!4m8!1m1!4e1!1m5!1m1!1s0x389eb6060fd12677:0xc94556213dba6b02!2m2!1d74.604174!2d42.8263617",
                "https://www.google.com/maps/place/%D0%9F%D0%B0%D1%80%D0%BA+%D0%9F%D0%B0%D0%BD%D1%84%D0%B8%D0%BB%D0%BE%D0%B2%D0%B0/@42.8796914,74.5826379,15z/data=!4m9!1m2!2m1!1z0L_QsNGA0LrQuCDQsdC40YjQutC10Lo!3m5!1s0x389eb7e74697b7a5:0xb625d929c04e872e!8m2!3d42.8796914!4d74.6001474!15sChfQv9Cw0YDQutC4INCx0LjRiNC60LXQuloZIhfQv9Cw0YDQutC4INCx0LjRiNC60LXQupIBBHBhcms",
                "https://www.google.com/maps/place/%D0%BF%D0%B0%D1%80%D0%BA+%D0%B8%D0%BC%D0%B5%D0%BD%D0%B8+%D0%A4%D1%83%D1%87%D0%B8%D0%BA%D0%B0/@42.8729172,74.5441973,15z/data=!4m9!1m2!2m1!1z0L_QsNGA0LrQuCDQsdC40YjQutC10Lo!3m5!1s0x389ec8426f2b96c5:0xe76389be556e25e5!8m2!3d42.8729172!4d74.5617068!15sChfQv9Cw0YDQutC4INCx0LjRiNC60LXQupIBBHBhcms",
                "https://www.google.com/maps/place/%D0%9F%D0%B0%D1%80%D0%BA+%D0%9B%D1%8E%D0%B1%D0%B2%D0%B8/@42.832077,74.5694046,15z/data=!4m9!1m2!2m1!1z0L_QsNGA0LrQuCDQsdC40YjQutC10Lo!3m5!1s0x389ec9e47be9306f:0x7d896ef17d2ad0c8!8m2!3d42.832077!4d74.5869141!15sChfQv9Cw0YDQutC4INCx0LjRiNC60LXQupIBBHBhcms",
                "https://www.google.com/maps/place/%D0%94%D1%83%D0%B1%D0%BE%D0%B2%D1%8B%D0%B9+%D0%BF%D0%B0%D1%80%D0%BA/@42.8779685,74.5895928,15z/data=!4m9!1m2!2m1!1z0L_QsNGA0LrQuCDQsdC40YjQutC10Lo!3m5!1s0x389eb7c2f1de28a9:0xb93a603983eeed29!8m2!3d42.8779685!4d74.6071023!15sChfQv9Cw0YDQutC4INCx0LjRiNC60LXQuloZIhfQv9Cw0YDQutC4INCx0LjRiNC60LXQupIBBHBhcms"
        };

        // Add Images Resource IDs
        int[] parksImages = {
                R.drawable.p2,
                R.drawable.p1,
                R.drawable.p3,
                R.drawable.p4,
                R.drawable.p5,
        };

        // Initialize ArrayList of Landmarks
        final ArrayList<Landmark> parks = new ArrayList<>();

        // Add All Landmarks to the ArrayList
        for (int i = 0; i < parksNames.length; i++) {
            parks.add(new Landmark(
                    parksNames[i],
                    parksDescriptions[i],
                    parksAddresses[i],
                    parksHours[i],
                    Utils.addPrefix(parksPhones[i]),
                    parksMapUris[i],
                    parksImages[i]));
        }

        // Set Custom List View Adapter
        ListView listView = (ListView) rootView.findViewById(R.id.cat_items_list);
        LandmarkAdapter adapter = new LandmarkAdapter(getActivity(), parks);
        listView.setAdapter(adapter);

        // Set Click Listeners for Each Item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get Landmark Object at Current Position
                Landmark park = parks.get(position);

                // Start Intent and Send Landmark Object to DetailActivity
                Utils.openDetailActivity(getContext(), park);

            }
        });

        return rootView;
    }
}