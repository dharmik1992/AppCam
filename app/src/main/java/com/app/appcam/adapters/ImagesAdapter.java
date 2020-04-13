package com.app.appcam.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.app.appcam.R;
import com.app.appcam.activities.BaseActivity;
import com.app.appcam.activities.ImageDetailActivity;
import com.app.appcam.room.models.ImageInfoModel;

import java.util.ArrayList;


public class ImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<ImageInfoModel> imageInfoModelsData;
    public ImagesAdapter(Context context,ArrayList<ImageInfoModel> imageInfoModelsData) {
        this.context = context;
        this.imageInfoModelsData = imageInfoModelsData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_image, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ((HeaderViewHolder) holder).relativeMainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImageDetailActivity.class);
                intent.putExtra("imagedetails", imageInfoModelsData.get(position));
                context.startActivity(intent);
            }
        });
        ((BaseActivity) context).setImageWithGlide(context, imageInfoModelsData.get(position).getImagepath(), ((HeaderViewHolder) holder).image, R.drawable.defaultplaceholder);

    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeMainLayout;
        ImageView image;
        public HeaderViewHolder(View view) {
            super(view);
            relativeMainLayout = (RelativeLayout) view.findViewById(R.id.relativeMainLayout);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }

    @Override
    public int getItemCount() {
        return imageInfoModelsData.size();
    }
}
