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

public class CafesFragment extends Fragment {

    public CafesFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get String Array Resources from the Strings File
        String[] monumentsNames = getResources().getStringArray(R.array.cafes_names);
        String[] monumentsAddresses = getResources().getStringArray(R.array.cafes_addresses);
        String[] monumentsDescriptions = getResources().getStringArray(R.array.cafes_descriptions);
        String[] monumentsHours = getResources().getStringArray(R.array.cafes_hours);
        String[] monumentsPhones = getResources().getStringArray(R.array.cafes_phones);

        // Add Google Maps URIs
        String[] monumentsMapUris = {
                "https://www.google.com/maps/dir/42.8318216,74.6049057/%D1%81%D0%B8%D0%B5%D1%80%D1%80%D0%B0+%D0%B4%D1%83%D1%88%D0%B0%D0%BD%D0%B1%D0%B8%D0%BD%D0%BA%D0%B0/@42.8363676,74.5909661,15z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x389ec9bd264d1119:0x2bb39f78e10223af!2m2!1d74.5924756!2d42.8441918",
                "https://www.google.com/maps/place/Navigator/@42.869762,74.6022413,17z/data=!3m1!4b1!4m5!3m4!1s0x389eb7dac9948d75:0x8fb0d6f771468aed!8m2!3d42.8697705!4d74.604431",
                "https://www.google.com/maps/place/%D0%91%D1%83%D0%B1%D0%BB%D0%B8%D0%BA/@42.8522941,74.571397,13z/data=!4m19!1m13!4m12!1m4!2m2!1d74.6154059!2d42.8309769!4e1!1m6!1m2!1s0x389eb7df2addcdcb:0xa8f28349aa3fa886!2z0JHRg9Cx0LvQuNC6LCAxINGD0LsuINCi0L7Qs9C-0LvQvtC6INCc0L7Qu9C00L4sINCR0LjRiNC60LXQug!2m2!1d74.5959898!2d42.8734847!3m4!1s0x389eb7df2addcdcb:0xa8f28349aa3fa886!8m2!3d42.8734847!4d74.5959898",
                "https://www.google.com/maps/place/%D0%9A%D0%BE%D1%84%D0%B5%D0%B9%D0%BD%D0%B0%D1%8F+135/@42.8702778,74.5930891,17z/data=!3m1!4b1!4m5!3m4!1s0x389eb7d844765bbb:0x67573f287fae014d!8m2!3d42.8702774!4d74.5953048",
                "https://www.google.com/maps?q=Boris+Coffee+and+Bakery&rlz=1C1GCEA_enKG938KG938&um=1&ie=UTF-8&sa=X&sqi=2&ved=2ahUKEwiyqZyklPP3AhVggpUCHS_RCRYQ_AUoAnoECAIQBA",
                "https://www.google.com/maps/place/Bellagio+Coffee/@42.8743048,74.5837553,17z/data=!4m9!1m2!2m1!1z0LrQvtGE0LXQudC90Lgg0LHQuNGI0LrQtdC6!3m5!1s0x389ec821429f55bb:0x873b4c0e52688a75!8m2!3d42.8735931!4d74.5883261!15sChvQutC-0YTQtdC50L3QuCDQsdC40YjQutC10LpaHSIb0LrQvtGE0LXQudC90Lgg0LHQuNGI0LrQtdC6kgELY29mZmVlX3Nob3CaASRDaGREU1VoTk1HOW5TMFZKUTBGblNVTlpOVFZRVHpablJSQUI"
        };

        // Add Images Resource IDs
        int[] monumentsImages = {
                R.drawable.cafe1,
                R.drawable.cafe2,
                R.drawable.cafe3,
                R.drawable.cafe4,
                R.drawable.cafe5,
                R.drawable.cafe6
        };

        // Initialize ArrayList of Landmarks
        final ArrayList<Landmark> monuments = new ArrayList<>();

        // Add All Landmarks to the ArrayList
        for (int i = 0; i < monumentsNames.length; i++) {
            monuments.add(new Landmark(
                    monumentsNames[i],
                    monumentsDescriptions[i],
                    monumentsAddresses[i],
                    monumentsHours[i],
                    Utils.addPrefix(monumentsPhones[i]),
                    monumentsMapUris[i],
                    monumentsImages[i]));
        }

        // Set Custom List View Adapter
        ListView listView = (ListView) rootView.findViewById(R.id.cat_items_list);
        LandmarkAdapter adapter = new LandmarkAdapter(getActivity(), monuments);
        listView.setAdapter(adapter);

        // Set Click Listeners for Each Item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get Landmark Object at Current Position
                Landmark monument = monuments.get(position);

                // Start Intent and Send Landmark Object to DetailActivity
                Utils.openDetailActivity(getContext(), monument);

            }
        });

        return rootView;
    }
}