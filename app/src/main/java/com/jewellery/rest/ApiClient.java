package com.jewellery.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gboss on 22/09/18.
 */

public class ApiClient {

  public static final String BASE_URL = "http://test.chatongo.in/";
  //http://test.chatongo.in/getcategorydata.json
  private static Retrofit retrofit = null;


  public static Retrofit getClient() {
    if (retrofit == null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }
}

