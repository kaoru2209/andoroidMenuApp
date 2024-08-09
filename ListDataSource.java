package com.example.myfragment;

import android.widget.ImageView;

import com.google.android.material.color.utilities.Variant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListDataSource {
    private static final ArrayList<String> name = new ArrayList<String>() {
        {
            add("ビール");
            add("日本酒");
            add("ハイボール");
            add("ワイン");
            add("唐揚げ");
        }
    };
    private static final ArrayList<String> alias = new ArrayList<String>() {
        {
            add("100円");
            add("200円");
            add("300円");
            add("400円");
            add("500円");
        }
    };
    private static final ArrayList<String> info = new ArrayList<String>() {
        {
            add("");
            add("");
            add("");
            add("");
            add("");
        }
    };

    private static final ArrayList<Integer> img = new ArrayList<Integer>() {
        {
            add(R.drawable.beer);
            add(R.drawable.nihonsyu);
            add(R.drawable.highball);
            add(R.drawable.wine);
            add(R.drawable.karaage_lemon);
        }
    };

    public static List<String> getAllNames() {
        return name;
    }

    public static List<Map<String, String>> getAll() {
        List<Map<String, String>> result = new ArrayList<>();
        for(int i = 0; i < name.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", name.get(i));
            map.put("alias", alias.get(i));
            map.put("info", info.get(i));
            map.put("img",String.valueOf(img.get(i)));
            result.add(map);
        }
        return result;
    }

    static Map<String, String> getInfoByName(String key) {
        int index = name.indexOf(key);
        Map<String, String> map = new HashMap<>();
        map.put("name", name.get(index));
        map.put("alias", alias.get(index));
        map.put("info", info.get(index));
        map.put("img",String.valueOf(img.get(index)));
        return map;
    }

    public static Map<String,String> countPage;

    static {
        countPage = new HashMap<>();
        countPage.put("ビール",String.valueOf(0));
        countPage.put("日本酒",String.valueOf(0));
        countPage.put("ハイボール",String.valueOf(0));
        countPage.put("ワイン",String.valueOf(0));
        countPage.put("唐揚げ",String.valueOf(0));
    }
}
