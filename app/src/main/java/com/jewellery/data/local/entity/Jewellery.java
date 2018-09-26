package com.jewellery.data.local.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by gboss on 22/09/18.
 */

public class Jewellery {

  @SerializedName("status")
  @Expose
  private String status;
  @SerializedName("message")
  @Expose
  private String message;
  @SerializedName("cateloguecategory")
  @Expose
  private List<Cateloguecategory> cateloguecategory = null;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<Cateloguecategory> getCateloguecategory() {
    return cateloguecategory;
  }

  public void setCateloguecategory(List<Cateloguecategory> cateloguecategory) {
    this.cateloguecategory = cateloguecategory;
  }

}
