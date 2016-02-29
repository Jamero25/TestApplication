package com.example.usuario.testapplication.process;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.testapplication.R;
import com.example.usuario.testapplication.data.Items;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by Usuario on 27/02/2016.
 */
public class MyAdapter extends android.support.v7.widget.RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public static ArrayList<Items> items = new ArrayList<>();
    public MyAdapter(ArrayList<Items> itemsArrayList) {
        this.items=itemsArrayList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
    Items it = items.get(position);
        holder.textView.setText(it.getName());

       // Picasso.with(holder.imageView.getContext()).load(it.getUrlImagen()).into(holder.imageView);
        Picasso.with(holder.imageView.getContext()).load(it.getUrlImagen()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(Resources.getSystem(), bitmap);
                roundedBitmapDrawable.setCornerRadius(70);
                holder.imageView.setImageDrawable(roundedBitmapDrawable);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = (ImageView) itemView.findViewById(R.id.imagenPlanet);
            textView = (TextView) itemView.findViewById(R.id.namePlanet);

        }


        @SuppressLint("NewApi")
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(view.getContext(), DetailsPlanetActivity.class);
            int position = getAdapterPosition();
            Items it = items.get(position);
            intent.putExtra(DetailsPlanetActivity.BUNDLE_IMAGEN, it.getUrlImagen());
            intent.putExtra(DetailsPlanetActivity.BUNDLE_NAME, textView.getText().toString());
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    ((InitialActivity) view.getContext()),
                    new Pair<View, String>(view.findViewById(R.id.imagenPlanet),
                            DetailsPlanetActivity.VIEW_IMAGEN),
                    new Pair<View, String>(view.findViewById(R.id.namePlanet), DetailsPlanetActivity.VIEW_NAME));

            ActivityCompat.startActivity((InitialActivity) view.getContext(), intent, activityOptionsCompat.toBundle());
        }
    }



}
