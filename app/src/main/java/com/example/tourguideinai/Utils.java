package com.example.tourguideinai;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Utils {


    public static void createFancyButton(Activity activity, int includedBtnId, int drawableId, CharSequence label) {
        View btnInclude = (View) activity.findViewById(includedBtnId);
        ImageView innerBtnImg = (ImageView) btnInclude.findViewById(R.id.fancy_btn_img);
        TextView innerBtnTxt = (TextView) btnInclude.findViewById(R.id.fancy_btn_txt);
        innerBtnImg.setImageResource(drawableId);
        innerBtnTxt.setText(label);
    }


    public static void openCategoriesActivity(final Activity currentActivity, int buttonId, final int selectTab) {
        LinearLayout button = (LinearLayout) currentActivity.findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thisIntent = new Intent(currentActivity, CategoriesActivity.class);
                thisIntent.putExtra("selected_index", selectTab);
                currentActivity.startActivity(thisIntent);
            }
        });
    }


    public static void openDetailActivity(Context context, Landmark landmark) {
        Intent detailActivity = new Intent(context, DetailActivity.class);
        detailActivity.putExtra("serialize_data", landmark);
        context.startActivity(detailActivity);
    }


    public static void fillText(Activity activity, int id, CharSequence text) {
        TextView thisTextView = (TextView) activity.findViewById(id);
        thisTextView.setText(text);
    }


    public static void fillText(View view, int id, CharSequence text) {
        TextView thisTextView = (TextView) view.findViewById(id);
        thisTextView.setText(text);
    }


    public static void fillImage(Activity activity, int id, int image) {
        ImageView thisImageView = (ImageView) activity.findViewById(id);
        thisImageView.setImageResource(image);
    }

  //to add image to specified ImageView
    public static void fillImage(View view, int id, int image) {
        ImageView thisImageView = (ImageView) view.findViewById(id);
        thisImageView.setImageResource(image);
    }


    public static void hideView(Activity activity, int id) {
        View thisView = (View) activity.findViewById(id);
        thisView.setVisibility(View.GONE);
    }


    public static String addPrefix(String phone) {
        if (!phone.isEmpty()) {
            return  phone;
        } else {
            return phone;
        }
    }

    //activity call
    public static void activateBackBtn(final Activity activity, int id) {
        ImageButton backButton = (ImageButton) activity.findViewById(id);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

}