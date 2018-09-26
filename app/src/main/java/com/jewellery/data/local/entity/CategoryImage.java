package com.jewellery.data.local.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gboss on 22/09/18.
 */

public class CategoryImage {

  @SerializedName("createddate")
  @Expose
  private String createddate;
  @SerializedName("hdpi")
  @Expose
  private Object hdpi;
  @SerializedName("imageid")
  @Expose
  private Integer imageid;
  @SerializedName("ipad")
  @Expose
  private Object ipad;
  @SerializedName("ipadretina")
  @Expose
  private Object ipadretina;
  @SerializedName("iphone")
  @Expose
  private String iphone;
  @SerializedName("iphone6")
  @Expose
  private Object iphone6;
  @SerializedName("iphone6plus")
  @Expose
  private Object iphone6plus;
  @SerializedName("mdpi")
  @Expose
  private Object mdpi;
  @SerializedName("modifieddate")
  @Expose
  private String modifieddate;
  @SerializedName("xhdpi")
  @Expose
  private Object xhdpi;
  @SerializedName("xxhdpi")
  @Expose
  private Object xxhdpi;
  @SerializedName("xxxhdpi")
  @Expose
  private Object xxxhdpi;

  public String getCreateddate() {
    return createddate;
  }

  public void setCreateddate(String createddate) {
    this.createddate = createddate;
  }

  public Object getHdpi() {
    return hdpi;
  }

  public void setHdpi(Object hdpi) {
    this.hdpi = hdpi;
  }

  public Integer getImageid() {
    return imageid;
  }

  public void setImageid(Integer imageid) {
    this.imageid = imageid;
  }

  public Object getIpad() {
    return ipad;
  }

  public void setIpad(Object ipad) {
    this.ipad = ipad;
  }

  public Object getIpadretina() {
    return ipadretina;
  }

  public void setIpadretina(Object ipadretina) {
    this.ipadretina = ipadretina;
  }

  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }

  public Object getIphone6() {
    return iphone6;
  }

  public void setIphone6(Object iphone6) {
    this.iphone6 = iphone6;
  }

  public Object getIphone6plus() {
    return iphone6plus;
  }

  public void setIphone6plus(Object iphone6plus) {
    this.iphone6plus = iphone6plus;
  }

  public Object getMdpi() {
    return mdpi;
  }

  public void setMdpi(Object mdpi) {
    this.mdpi = mdpi;
  }

  public String getModifieddate() {
    return modifieddate;
  }

  public void setModifieddate(String modifieddate) {
    this.modifieddate = modifieddate;
  }

  public Object getXhdpi() {
    return xhdpi;
  }

  public void setXhdpi(Object xhdpi) {
    this.xhdpi = xhdpi;
  }

  public Object getXxhdpi() {
    return xxhdpi;
  }

  public void setXxhdpi(Object xxhdpi) {
    this.xxhdpi = xxhdpi;
  }

  public Object getXxxhdpi() {
    return xxxhdpi;
  }

  public void setXxxhdpi(Object xxxhdpi) {
    this.xxxhdpi = xxxhdpi;
  }

}

