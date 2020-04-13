package com.app.appcam.activities;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import com.app.appcam.fragments.CapturePhotoFragment;
import com.app.appcam.fragments.ValidateCapturedImageFragment;
import com.app.appcam.R;

import butterknife.ButterKnife;

public class CaptureImageActivity extends BaseActivity implements CapturePhotoFragment.OnFragmentInteractionListener  {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capture_image_activity);
        ButterKnife.bind(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.res_photo_layout, new CapturePhotoFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Bitmap bitmap) {
        if (bitmap != null) {
            ValidateCapturedImageFragment validateCapturedImageFragment = new ValidateCapturedImageFragment();
            validateCapturedImageFragment.imageSetupFragment(bitmap,this);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.res_photo_layout, validateCapturedImageFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 1) {
            finish();
        } else {
            getSupportFragmentManager().popBackStackImmediate();
        }

    }
}
