package com.app.appcam.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.app.appcam.room.models.ImageInfoModel;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertImageData(ImageInfoModel imageInfoModel);

    @Query("SELECT * FROM ImageInfoModel")
    List<ImageInfoModel> fetchAllImagesInfo();

}
