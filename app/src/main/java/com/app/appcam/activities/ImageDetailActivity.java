package com.app.appcam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.appcam.R;
import com.app.appcam.adapters.ImagesAdapter;
import com.app.appcam.room.AppRepository;
import com.app.appcam.room.models.ImageInfoModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageDetailActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.headerTitle)
    TextView headerTitle;
    @BindView(R.id.image_preview)
    ImageView image_preview;
    @BindView(R.id.txt_filename)
    TextView txt_filename;
    @BindView(R.id.txt_filesize)
    TextView txt_filesize;
    @BindView(R.id.txt_timestamp)
    TextView txt_timestamp;
    @BindView(R.id.txt_latitude)
    TextView txt_latitude;
    @BindView(R.id.txt_longitude)
    TextView txt_longitude;
    @BindView(R.id.txt_path)
    TextView txt_path;
    @BindView(R.id.img_map)
    ImageView img_map;

    ImageInfoModel imageInfoModelsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        headerTitle.setText("Details");
        Intent intent = getIntent();
        imageInfoModelsData = (ImageInfoModel) intent.getSerializableExtra("imagedetails");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        setData();
    }

    public void setData(){
       setImageWithGlide(this, imageInfoModelsData.getImagepath(), image_preview, R.drawable.defaultplaceholder);
        txt_filename.setText(imageInfoModelsData.getImagename());
        txt_filesize.setText(imageInfoModelsData.getImagesize()+" KB");
        txt_timestamp.setText(imageInfoModelsData.getTimestamp());
        txt_latitude.setText(imageInfoModelsData.getLatitude());
        txt_longitude.setText(imageInfoModelsData.getLongitude());
        txt_path.setText(imageInfoModelsData.getImagepath());
    }

}
