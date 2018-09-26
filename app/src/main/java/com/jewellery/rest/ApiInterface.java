package com.jewellery.rest;

import com.jewellery.data.local.entity.Jewellery;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gboss on 22/09/18.
 */

public interface ApiInterface {

  @GET("getcategorydata.json")
  Call<Jewellery> getJewelleryList();

}
