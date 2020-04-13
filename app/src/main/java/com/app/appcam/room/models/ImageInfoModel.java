package com.app.appcam.room.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Comparator;

@Entity
public class ImageInfoModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String imagepath;
    private String imagename;
    private String imagesize;
    private String timestamp;
    private String latitude;
    private String longitude;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImagesize() {
        return imagesize;
    }

    public void setImagesize(String imagesize) {
        this.imagesize = imagesize;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public static Comparator<ImageInfoModel> ImageSizeComparator = new Comparator<ImageInfoModel>() {

        public int compare(ImageInfoModel s1, ImageInfoModel s2) {

            int size1 = Integer.valueOf(s1.getImagesize());
            int size2 = Integer.valueOf(s2.getImagesize());

            /*For ascending order*/
            return size1-size2;

            /*For descending order*/
            //size2-size1;
        }};

    public static Comparator<ImageInfoModel> ImageNameComparator = new Comparator<ImageInfoModel>() {

        public int compare(ImageInfoModel s1, ImageInfoModel s2) {

            String imagename1 = s1.getImagename().toUpperCase();
            String imagename2 = s2.getImagename().toUpperCase();

            //ascending order
            return imagename1.compareTo(imagename2);

            //descending order
            //return imagename2.compareTo(imagename1);
        }};

    @Override
    public String toString() {
        return "ImageInfoModel{" +
                "id=" + id +
                ", imagepath='" + imagepath + '\'' +
                ", imagename='" + imagename + '\'' +
                ", imagesize='" + imagesize + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
