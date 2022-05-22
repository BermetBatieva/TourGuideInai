package com.example.tourguideinai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
//Библиотеки
public class BibliotekFragment extends Fragment {

    public BibliotekFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get String Array Resources from the Strings File
        String[] museumsNames = getResources().getStringArray(R.array.museums_names);
        String[] museumsAddresses = getResources().getStringArray(R.array.museums_addresses);
        String[] museumsDescriptions = getResources().getStringArray(R.array.museums_descriptions);
        String[] museumsHours = getResources().getStringArray(R.array.museums_hours);
        String[] museumsPhones = getResources().getStringArray(R.array.museums_phones);

        // Add Google Maps URIs
        String[] museumsMapUris = {
                "https://www.google.com/maps/place/%D0%9A%D1%8B%D1%80%D0%B3%D1%8B%D0%B7%D1%81%D0%BA%D0%B8%D0%B9+%D0%BD%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9+%D0%B0%D0%BA%D0%B0%D0%B4%D0%B5%D0%BC%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9+%D1%82%D0%B5%D0%B0%D1%82%D1%80+%D0%BE%D0%BF%D0%B5%D1%80%D1%8B+%D0%B8+%D0%B1%D0%B0%D0%BB%D0%B5%D1%82%D0%B0+%D0%B8%D0%BC.+%D0%90%D0%B1%D0%B4%D1%8B%D0%BB%D0%B0%D1%81%D0%B0+%D0%9C%D0%B0%D0%BB%D0%B4%D1%8B%D0%B1%D0%B0%D0%B5%D0%B2%D0%B0/@42.8780791,74.6105509,17z/data=!3m1!4b1!4m5!3m4!1s0x389eb7c10848a93d:0x178c9dfeb06e7595!8m2!3d42.8779249!4d74.6127282",
                "https://www.google.com/maps/place/%D0%A0%D0%B5%D1%81%D0%BF%D1%83%D0%B1%D0%BB%D0%B8%D0%BA%D0%B0%D0%BD%D1%81%D0%BA%D0%B0%D1%8F+%D0%91%D0%B8%D0%B1%D0%BB%D0%B8%D0%BE%D1%82%D0%B5%D0%BA%D0%B0+%D0%B8%D0%BC%D0%B5%D0%BD%D0%B8+%D0%9A.+%D0%91%D0%B0%D1%8F%D0%BB%D0%B8%D0%BD%D0%BE%D0%B2%D0%B0/@42.8776599,74.540484,13z/data=!4m9!1m2!2m1!1z0LHQuNCx0LvQuNC-0YLQtdC60LA!3m5!1s0x389eb7c3d5c15d25:0xe02a106a7808bc9c!8m2!3d42.8776599!4d74.6105218!15sChTQsdC40LHQu9C40L7RgtC10LrQsJIBDnB1YmxpY19saWJyYXJ5?hl=ru",
                "https://www.google.com/maps?q=%D0%93%D0%BE%D1%81%D1%83%D0%B4%D0%B0%D1%80%D1%81%D1%82%D0%B2%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9+%D0%B8%D1%81%D1%82%D0%BE%D1%80%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9+%D0%BC%D1%83%D0%B7%D0%B5%D0%B9&rlz=1C1GCEA_enKG938KG938&um=1&ie=UTF-8&sa=X&sqi=2&ved=2ahUKEwj67tWDnPP3AhUcDEQIHWhLD7sQ_AUoBHoECAIQBg",
                "https://www.google.com/maps?q=%D0%9C%D1%83%D0%B7%D0%B5%D0%B9+%D0%B3%D0%B5%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D0%B8+%D0%B8+%D0%9C%D1%83%D0%B7%D0%B5%D0%B9+%D0%BC%D0%B8%D0%BD%D0%B5%D1%80%D0%B0%D0%BB%D0%BE%D0%B3%D0%B8%D0%B8&source=lmns&bih=641&biw=1422&rlz=1C1GCEA_enKG938KG938&hl=ru&sa=X&ved=2ahUKEwi0q4HnnPP3AhVp_SoKHZ04AIIQ_AUoAXoECAEQAQ",
                "https://www.google.com/maps/place/M+V+Frunze+Museum/@42.8804787,74.6031499,17z/data=!3m1!4b1!4m5!3m4!1s0x389eb7e80e0d64a5:0x25ae18c0a7bd53ca!8m2!3d42.8805255!4d74.605339?hl=ru"

        };

        // Add Images Resource IDs
        int[] museumsImages = {
                R.drawable.teatr_oper,
                R.drawable.cul1,
                R.drawable.cul2,
                R.drawable.cul3,
                R.drawable.cul4
        };

        // Initialize ArrayList of Landmarks
        final ArrayList<Landmark> museums = new ArrayList<>();

        // Add All Landmarks to the ArrayList
        for (int i = 0; i < museumsNames.length; i++) {
            museums.add(new Landmark(
                    museumsNames[i],
                    museumsDescriptions[i],
                    museumsAddresses[i],
                    museumsHours[i],
                    Utils.addPrefix(museumsPhones[i]),
                    museumsMapUris[i],
                    museumsImages[i]));
        }

        // Set Custom List View Adapter
        ListView listView = (ListView) rootView.findViewById(R.id.cat_items_list);
        LandmarkAdapter adapter = new LandmarkAdapter(getActivity(), museums);
        listView.setAdapter(adapter);

        // Set Click Listeners for Each Item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get Landmark Object at Current Position
                Landmark museum = museums.get(position);

                // Start Intent and Send Landmark Object to DetailActivity
                Utils.openDetailActivity(getContext(), museum);

            }
        });

        return rootView;
    }
}