package com.app.appcam.room.Pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by user on 24/07/2019.
 */
@Entity
public class CategoryPostData implements Serializable {
    @PrimaryKey
    @NonNull
    private String inspectionId;
    private String primaryInspectionNuber;
    private int permitNumber;
    private int categoryId;
    private int questionId;
    private int optionId;
    private String optionValue;

    public String getPrimaryInspectionNuber() {
        return primaryInspectionNuber;
    }

    public void setPrimaryInspectionNuber(String primaryInspectionNuber) {
        this.primaryInspectionNuber = primaryInspectionNuber;
    }

    @NonNull
    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(@NonNull String inspectionId) {
        this.inspectionId = inspectionId;
    }

    public int getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(int permitNumber) {
        this.permitNumber = permitNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
