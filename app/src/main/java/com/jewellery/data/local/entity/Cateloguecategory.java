package com.jewellery.data.local.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by gboss on 22/09/18.
 */

public class Cateloguecategory {

  @SerializedName("CategoryId")
  @Expose
  private Integer categoryId;
  @SerializedName("CategoryName")
  @Expose
  private String categoryName;
  @SerializedName("categoryImages")
  @Expose
  private List<CategoryImage> categoryImages = null;

  public Cateloguecategory(JewelleryDatabaseEntity jewelleryDatabaseEntity) {

    if (jewelleryDatabaseEntity != null) {

      this.categoryId = jewelleryDatabaseEntity.getJewellery_cat_id();

      if (jewelleryDatabaseEntity.getJewelleryName() != null) {
        this.categoryName = jewelleryDatabaseEntity.getJewelleryName();
      }

      if (jewelleryDatabaseEntity.getJewelleryCategoryList() != null) {
        this.categoryImages = jewelleryDatabaseEntity.getJewelleryCategoryList();
      }


    }

  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public List<CategoryImage> getCategoryImages() {
    return categoryImages;
  }

  public void setCategoryImages(List<CategoryImage> categoryImages) {
    this.categoryImages = categoryImages;
  }

}

