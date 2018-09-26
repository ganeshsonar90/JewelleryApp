package com.jewellery.utils;

import android.arch.persistence.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jewellery.data.local.entity.CategoryImage;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by gboss on 25/09/18.
 */

public class Converters {

  @TypeConverter
  public static ArrayList<CategoryImage> fromString(String value) {
    Type listType = new TypeToken<ArrayList<CategoryImage>>() {
    }.getType();
    return new Gson().fromJson(value, listType);
  }

  @TypeConverter
  public static String fromArrayLisr(ArrayList<CategoryImage> list) {
    Gson gson = new Gson();
    String json = gson.toJson(list);
    return json;
  }
}
