package com.jewellery.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.jewellery.data.local.entity.JewelleryDatabaseEntity;
import java.util.List;

/**
 * Created by gboss on 23/09/18.
 */
@Dao
public interface JewelleryDao {

  @Query("SELECT * FROM jewellery")
  List<JewelleryDatabaseEntity> getAll();

  @Query("SELECT * FROM jewellery where jewellery_name LIKE  :jewelleryName")
  JewelleryDatabaseEntity findByName(String jewelleryName);

  @Query("SELECT COUNT(*) from jewellery")
  int countUsers();

  @Insert
  void insertAll(JewelleryDatabaseEntity... jewellerys);

  @Insert
  void insertMultipleJwelleryList(List<JewelleryDatabaseEntity> jewelleryist);


  @Delete
  void delete(JewelleryDatabaseEntity user);

  @Query("DELETE FROM jewellery")
  void deleteAll();

}
