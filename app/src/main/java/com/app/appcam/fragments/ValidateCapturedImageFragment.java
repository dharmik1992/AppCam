package com.app.appcam.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.app.appcam.R;
import com.app.appcam.room.AppRepository;
import com.app.appcam.room.models.ImageInfoModel;
import java.io.File;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ValidateCapturedImageFragment extends BaseFragment {

    private Bitmap bitmap;

    AppRepository appRepository;
    Context context;
    ImageInfoModel imageInfoModel;
    @BindView(R.id.image_preview)
    ImageView image_preview;

    @OnClick(R.id.btn_Retake)
    public void onRetakeclick() {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.btn_next)
    public void onNextclick() {
        if (bitmap != null) {
            String imageFileName = "IMG_" + getTimestamp();
            File file = saveToInternalStorage(bitmap, imageFileName);
            createDataAndSaveToLocal(file, imageFileName);
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result", imageInfoModel);
            getActivity().setResult(Activity.RESULT_OK, returnIntent);
            getActivity().finish();
        }
    }

    public void createDataAndSaveToLocal(File file, String imageFileName) {
        imageInfoModel = new ImageInfoModel();
        imageInfoModel.setImagename(imageFileName);
        imageInfoModel.setImagepath(file.getPath());
        imageInfoModel.setImagesize(file.length() / 1024 + "");
        imageInfoModel.setLatitude("72.5678");
        imageInfoModel.setLongitude("-122.5678");
        imageInfoModel.setTimestamp(getTimestamp() + "");
        appRepository.insertImageData(imageInfoModel);
    }

    public void imageSetupFragment(Bitmap bitmap, Context context) {
        if (bitmap != null) {
            this.bitmap = bitmap;
            this.context = context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
        appRepository = new AppRepository(context.getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_validate_image, container, false);
        ButterKnife.bind(this, view);
        if (bitmap != null) {
            image_preview.setImageBitmap(bitmap);
        }
        return view;
    }
}
