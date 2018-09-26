package com.jewellery.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import com.jewellery.data.local.entity.JewelleryDatabaseEntity;
import com.jewellery.utils.Converters;

/**
 * Created by gboss on 23/09/18.
 */

@Database(entities = {JewelleryDatabaseEntity.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

  private static AppDatabase INSTANCE;

  public abstract JewelleryDao jewelleryDao();

  public static AppDatabase getAppDatabase(Context context) {
    if (INSTANCE == null) {
      INSTANCE =
          Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
              "jewellery-database")
              // allow queries on the main thread.
              // Don't do this on a real app! See PersistenceBasicSample for an example.
              .allowMainThreadQueries()
              .build();
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }
}
