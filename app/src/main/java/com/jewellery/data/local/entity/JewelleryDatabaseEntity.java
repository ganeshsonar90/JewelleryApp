package com.jewellery.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.ArrayList;

/**
 * Created by gboss on 23/09/18.
 */

@Entity(tableName = "jewellery")
public class JewelleryDatabaseEntity {

  @PrimaryKey(autoGenerate = true)
  private int uid;

  @ColumnInfo(name = "jewellery_name")
  private String jewelleryName;

  @ColumnInfo(name = "jewellery_cat_id")
  private int jewellery_cat_id;

  private ArrayList<CategoryImage> jewelleryCategoryList = new ArrayList<>();


  public JewelleryDatabaseEntity() {
  }

  // List<CategoryImage> jewelleryCategoryList=null;

  public JewelleryDatabaseEntity(Cateloguecategory jewellerCategory) {

    if (jewellerCategory != null) {

      if (jewellerCategory.getCategoryId() != null) {
        this.jewellery_cat_id = jewellerCategory.getCategoryId();
      }

      if (jewellerCategory.getCategoryName() != null) {
        this.jewelleryName = jewellerCategory.getCategoryName();
      }

      if (jewellerCategory.getCategoryImages() != null) {
        this.jewelleryCategoryList.addAll(jewellerCategory.getCategoryImages());
      }


    }

  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getJewelleryName() {
    return jewelleryName;
  }

  public void setJewelleryName(String jewelleryName) {
    this.jewelleryName = jewelleryName;
  }


  public int getJewellery_cat_id() {
    return jewellery_cat_id;
  }

  public void setJewellery_cat_id(int jewellery_cat_id) {
    this.jewellery_cat_id = jewellery_cat_id;
  }

  public ArrayList<CategoryImage> getJewelleryCategoryList() {
    return jewelleryCategoryList;
  }

  public void setJewelleryCategoryList(
      ArrayList<CategoryImage> jewelleryCategoryList) {
    this.jewelleryCategoryList = jewelleryCategoryList;
  }
}
