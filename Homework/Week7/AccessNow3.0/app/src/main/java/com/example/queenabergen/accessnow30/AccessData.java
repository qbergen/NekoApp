package com.example.queenabergen.accessnow30;

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

        for (int i = 0; i < accessnowflicks.length; i++) {
            ListItem item = new ListItem();
            item.setImageResId(accessnowflicks[i]);
            data.add(item);
        }
        return data;
    }

}
