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
// торговые центры
public class PalacesFragment extends Fragment {

    public PalacesFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get String Array Resources from the Strings File
        String[] palacesNames = getResources().getStringArray(R.array.palaces_names);
        String[] palacesAddresses = getResources().getStringArray(R.array.palaces_addresses);
        String[] palacesDescriptions = getResources().getStringArray(R.array.palaces_descriptions);
        String[] palacesHours = getResources().getStringArray(R.array.palaces_hours);
        String[] palacesPhones = getResources().getStringArray(R.array.palaces_phones);

        // Add Google Maps URIs
        String[] palacesMapUris = {
                "https://www.google.com/maps/place/%D0%91%D0%B8%D1%88%D0%BA%D0%B5%D0%BA+%D0%9F%D0%B0%D1%80%D0%BA/@42.8746392,74.5554276,14z/data=!4m9!1m2!2m1!1z0YLQvtGA0LPQvtCy0YvQuSDRhtC10L3RgtGA!3m5!1s0x389eb7dec2f84b71:0x29c1629c788878ab!8m2!3d42.8746392!4d74.5904465!15sChvRgtC-0YDQs9C-0LLRi9C5INGG0LXQvdGC0YBaHSIb0YLQvtGA0LPQvtCy0YvQuSDRhtC10L3RgtGAkgEPc2hvcHBpbmdfY2VudGVy",
                "https://www.google.com/maps/place/%D0%92%D0%B5%D1%84%D0%B0+%D0%A6%D0%B5%D0%BD%D1%82%D1%80/@42.8746392,74.5554276,14z/data=!4m9!1m2!2m1!1z0YLQvtGA0LPQvtCy0YvQuSDRhtC10L3RgtGA!3m5!1s0x389eb633eb4a865f:0xda48af2b2a2e4b59!8m2!3d42.8575761!4d74.6095143!15sChvRgtC-0YDQs9C-0LLRi9C5INGG0LXQvdGC0YBaHSIb0YLQvtGA0LPQvtCy0YvQuSDRhtC10L3RgtGAkgEPc2hvcHBpbmdfY2VudGVy",
                "https://www.google.com/maps/place/%D0%90%D0%B7%D0%B8%D1%8F+%D0%9C%D0%BE%D0%BB%D0%BB/@42.8746392,74.5554276,14z/data=!4m9!1m2!2m1!1z0YLQvtGA0LPQvtCy0YvQuSDRhtC10L3RgtGA!3m5!1s0x389ec9d3088356eb:0xb6b7beaa1240556a!8m2!3d42.8557053!4d74.5851587!15sChvRgtC-0YDQs9C-0LLRi9C5INGG0LXQvdGC0YBaHSIb0YLQvtGA0LPQvtCy0YvQuSDRhtC10L3RgtGAkgEPc2hvcHBpbmdfY2VudGVy",
                "https://www.google.com/maps/place/%D0%A2%D0%BE%D1%80%D0%B3%D0%BE%D0%B2%D0%BE-%D0%B0%D0%B4%D0%BC%D0%B8%D0%BD%D0%B8%D1%81%D1%82%D1%80%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%B9+%D1%86%D0%B5%D0%BD%D1%82%D1%80+%D0%92%D0%B5%D1%81%D0%BD%D0%B0+(%D0%A2%D0%90%D0%A6+%D0%92%D0%B5%D1%81%D0%BD%D0%B0)/@42.8774333,74.5753072,17z/data=!3m1!4b1!4m5!3m4!1s0x389ec83dc62bd4f9:0x896dae01da8934f2!8m2!3d42.8774333!4d74.5774959",
                "https://www.google.com/maps/place/%D0%A2%D0%A0%D0%A6+Dordoi+Plaza+2/@42.8742843,74.6163761,17z/data=!4m9!1m2!2m1!1z0LTQvtGA0LTQvtC5INC_0LvQsNC30LA!3m5!1s0x389eb7b8ecb3f365:0x6551c797c5d374c7!8m2!3d42.8747712!4d74.6189706!15sChfQtNC-0YDQtNC-0Lkg0L_Qu9Cw0LfQsFoZIhfQtNC-0YDQtNC-0Lkg0L_Qu9Cw0LfQsJIBD3Nob3BwaW5nX2NlbnRlcpoBJENoZERTVWhOTUc5blMwVkpRMEZuU1VSdE5rcFVUUzFCUlJBQg?hl=ru"
        };

        // Add Images Resource IDs
        int[] palacesImages = {
                R.drawable.tc1,
                R.drawable.tc2,
                R.drawable.tc3,
                R.drawable.tc4,
                R.drawable.tc5
        };

        // Initialize ArrayList of Landmarks
        final ArrayList<Landmark> palaces = new ArrayList<>();

        // Add All Landmarks to the ArrayList
        for (int i = 0; i < palacesNames.length; i++) {
            palaces.add(new Landmark(
                    palacesNames[i],
                    palacesDescriptions[i],
                    palacesAddresses[i],
                    palacesHours[i],
                    Utils.addPrefix(palacesPhones[i]),
                    palacesMapUris[i],
                    palacesImages[i]));
        }

        // Set Custom List View Adapter
        ListView listView = (ListView) rootView.findViewById(R.id.cat_items_list);
        LandmarkAdapter adapter = new LandmarkAdapter(getActivity(), palaces);
        listView.setAdapter(adapter);

        // Set Click Listeners for Each Item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get Landmark Object at Current Position
                Landmark palace = palaces.get(position);

                // Start Intent and Send Landmark Object to DetailActivity
                Utils.openDetailActivity(getContext(), palace);

            }
        });

        return rootView;
    }
}