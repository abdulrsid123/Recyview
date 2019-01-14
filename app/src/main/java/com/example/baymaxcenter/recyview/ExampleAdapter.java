package com.example.baymaxcenter.recyview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleLIst;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList){
        mContext = context;
        mExampleLIst = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleLIst.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikesCount();


        holder.mTexViewCreator.setText(creatorName);
        holder.mTexViewLikes.setText("Likes: "+ likeCount);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mExampleLIst.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTexViewCreator;
        public TextView mTexViewLikes;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view_1);
            mTexViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTexViewLikes = itemView.findViewById(R.id.text_view_likes);

        }
    }


}
