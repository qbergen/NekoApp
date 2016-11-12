package com.example.queenabergen.accessnow30.adapter;

import com.example.queenabergen.accessnow30.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by queenabergen on 10/31/16.
 */

public class AccessData {
    private static final int[] accessnowflicks = {R.drawable.facephoto, R.drawable.android, R.drawable.androidapple,
    };


    public static List<ListItem> getListData() {
        List<ListItem> data = new ArrayList<>();
        //made an arraylist and called it data
        for (int i = 0; i < accessnowflicks.length; i++)
        //a for loop to iteriate through the array of photos in accessnowflicks
                    {
            ListItem item = new ListItem();
                        //create a new list item and called it item.
            item.setImageResId(accessnowflicks[i]);
                        //set the image to that item which is the photos from above.
            data.add(item);
                        //then add that item to the new data array list
        }
        return data;
    }

}
