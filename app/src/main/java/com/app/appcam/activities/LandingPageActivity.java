package com.app.appcam.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.appcam.R;
import com.app.appcam.adapters.ImagesAdapter;
import com.app.appcam.room.AppRepository;
import com.app.appcam.room.models.ImageInfoModel;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LandingPageActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.headerTitle)
    TextView headerTitle;
    @BindView(R.id.error_mainLayout)
    RelativeLayout error_mainLayout;
    @BindView(R.id.rl_mainLayout)
    LinearLayout rl_mainLayout;
    @BindView(R.id.radioSortGroup)
    RadioGroup radioSortGroup;

    @BindView(R.id.recycler_view_images)
    RecyclerView recycler_view_images;
    GridLayoutManager gridLayoutManager;
    ImagesAdapter imagesAdapter;
    AppRepository appRepository;
    ArrayList<ImageInfoModel> imageInfoModelsData = new ArrayList<>();
    ImageInfoModel imageInfoModel;

    @OnClick(R.id.button_opencamera)
    public void onNextQuestionClick() {
        requestMultiplePermissions();
        Intent intent = new Intent(this, CaptureImageActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        requestMultiplePermissions();
        appRepository = new AppRepository(getApplicationContext());
        imageInfoModelsData = (ArrayList<ImageInfoModel>) appRepository.getAllImagesInfo();
        if (imageInfoModelsData.size() > 0) {
            error_mainLayout.setVisibility(View.GONE);
            rl_mainLayout.setVisibility(View.VISIBLE);
        } else {
            error_mainLayout.setVisibility(View.VISIBLE);
            rl_mainLayout.setVisibility(View.GONE);
        }
        setRecyclerView();
        radioSortGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioName) {
                    Collections.sort(imageInfoModelsData, ImageInfoModel.ImageNameComparator);
                    imagesAdapter.notifyDataSetChanged();
                } else if (checkedId == R.id.radioSize) {
                    Collections.sort(imageInfoModelsData, ImageInfoModel.ImageSizeComparator);
                    imagesAdapter.notifyDataSetChanged();

                }
            }
        });
    }

    public void setRecyclerView() {
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        imagesAdapter = new ImagesAdapter(this, imageInfoModelsData);
        recycler_view_images.setLayoutManager(gridLayoutManager);
        recycler_view_images.setAdapter(imagesAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                imageInfoModel = (ImageInfoModel) data.getSerializableExtra("result");
                if (imageInfoModelsData.size() == 0) {
                    error_mainLayout.setVisibility(View.GONE);
                    rl_mainLayout.setVisibility(View.VISIBLE);
                }
                imageInfoModelsData.add(imageInfoModel);
                imagesAdapter.notifyDataSetChanged();


            }
        }
    }

}
