package com.jewellery.data.local.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import com.jewellery.data.local.AppDatabase;
import com.jewellery.data.local.entity.Cateloguecategory;
import com.jewellery.data.local.entity.JewelleryDatabaseEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gboss on 23/09/18.
 */

public class DatabaseInitializer {

  private static final String TAG = DatabaseInitializer.class.getName();

  public static void populateAsync(@NonNull final AppDatabase db,
      List<Cateloguecategory> jewelleryCatList) {
    PopulateDbAsync task = new PopulateDbAsync(db, jewelleryCatList);
    task.execute();
  }

  private static void addJewellery(final AppDatabase db,
      List<Cateloguecategory> jewelleryCatList) {

    List<JewelleryDatabaseEntity> jewelleryDatabaseEntityList = new ArrayList<>();
    for (Cateloguecategory jewellerCategory : jewelleryCatList) {

      JewelleryDatabaseEntity jewelleryDatabaseEntityObj = new JewelleryDatabaseEntity(
          jewellerCategory);

      jewelleryDatabaseEntityList.add(jewelleryDatabaseEntityObj);
    }

    db.jewelleryDao().insertMultipleJwelleryList(jewelleryDatabaseEntityList);

  }

  private static void populateWithTestData(AppDatabase db,
      List<Cateloguecategory> jewelleryCatList) {
    addJewellery(db, jewelleryCatList);
  }


  public static List<Cateloguecategory> getAllJewelleryList(AppDatabase db) {

    List<Cateloguecategory> jewelleryCatList = new ArrayList<>();

    List<JewelleryDatabaseEntity> jewelleryDatabaseEntityList = db.jewelleryDao().getAll();

    for (JewelleryDatabaseEntity jewelleryDatabaseEntity : jewelleryDatabaseEntityList) {

      Cateloguecategory cateloguecategoryObj = new Cateloguecategory(jewelleryDatabaseEntity);

      jewelleryCatList.add(cateloguecategoryObj);
    }

    Log.d(DatabaseInitializer.TAG, "Rows Count: " + jewelleryDatabaseEntityList.size());

    return jewelleryCatList;

  }


  private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final AppDatabase mDb;
    private final List<Cateloguecategory> mjewelleryCatList;


    PopulateDbAsync(AppDatabase db,
        List<Cateloguecategory> jewelleryCatList) {
      mDb = db;
      mjewelleryCatList = jewelleryCatList;
    }

    @Override
    protected Void doInBackground(final Void... params) {
      populateWithTestData(mDb, mjewelleryCatList);
      return null;
    }

  }

  public static void deleteAll(AppDatabase db) {
    new deleteAllWordsAsyncTask(db).execute();
  }

  private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {

    AppDatabase mDb;

    deleteAllWordsAsyncTask(AppDatabase db) {
      mDb = db;
    }

    @Override
    protected Void doInBackground(Void... voids) {
      if (mDb != null) {
        mDb.jewelleryDao().deleteAll();
      }

      return null;
    }
  }


}

