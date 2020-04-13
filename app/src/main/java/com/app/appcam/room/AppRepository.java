package com.app.appcam.room;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.app.appcam.room.models.ImageInfoModel;

import java.util.List;

public class AppRepository {
    private String DB_NAME = "ImageInfoDatabase.db";

    private AppDatabase appDatabase;

    public AppRepository(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }


    public void insertImageData(final ImageInfoModel imageInfoModel) {
       appDatabase.getAppDao().insertImageData(imageInfoModel);

    }

    public List<ImageInfoModel> getAllImagesInfo() {
        return appDatabase.getAppDao().fetchAllImagesInfo();
    }
}
