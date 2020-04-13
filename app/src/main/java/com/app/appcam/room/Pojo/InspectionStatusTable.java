package com.app.appcam.room.Pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by user on 08/08/2019.
 */
@Entity
public class InspectionStatusTable implements Serializable {
    @NonNull
    @PrimaryKey
    private String primaryInspectionNumber;
    private String status;
    private int positionToinsertVoilationAt;
    private boolean isVoilationScreensVisible;

    public String getPrimaryInspectionNumber() {
        return primaryInspectionNumber;
    }

    public void setPrimaryInspectionNumber(String primaryInspectionNumber) {
        this.primaryInspectionNumber = primaryInspectionNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPositionToinsertVoilationAt() {
        return positionToinsertVoilationAt;
    }

    public void setPositionToinsertVoilationAt(int positionToinsertVoilationAt) {
        this.positionToinsertVoilationAt = positionToinsertVoilationAt;
    }

    public boolean isVoilationScreensVisible() {
        return isVoilationScreensVisible;
    }

    public void setVoilationScreensVisible(boolean voilationScreensVisible) {
        isVoilationScreensVisible = voilationScreensVisible;
    }
}
