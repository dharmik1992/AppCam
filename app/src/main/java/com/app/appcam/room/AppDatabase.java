package com.app.appcam.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.app.appcam.room.models.ImageInfoModel;

@Database(entities = {ImageInfoModel.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {

    public abstract DaoAccess getAppDao();
}
