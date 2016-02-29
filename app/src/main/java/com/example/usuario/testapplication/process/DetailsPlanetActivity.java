package com.example.usuario.testapplication.process;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.testapplication.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class DetailsPlanetActivity extends AppCompatActivity {

    public static final String VIEW_IMAGEN = "imagen";
    public static final String VIEW_NAME = "name";
    public static final String BUNDLE_NAME = "name_planet";
    public static final String BUNDLE_IMAGEN = "imagen_planet";

    private ImageView imagePlanet;
    private TextView textPlanet;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_planet);

        imagePlanet = (ImageView) findViewById(R.id.imagen_details_planet);
        textPlanet = (TextView) findViewById(R.id.name_details_planet);
        ViewCompat.setTransitionName(imagePlanet, VIEW_IMAGEN);
        ViewCompat.setTransitionName(textPlanet, VIEW_NAME);

        textPlanet.setText(getIntent().getStringExtra(BUNDLE_NAME));


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && addTransitionListener()){
            
            Picasso.with(this).load(getIntent().getStringExtra(BUNDLE_IMAGEN)).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(Resources.getSystem(), bitmap);
                    roundedBitmapDrawable.setCornerRadius(70);
                    imagePlanet.setImageDrawable(roundedBitmapDrawable);
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });
        }

    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private boolean addTransitionListener() {
        TransitionInflater inflater = TransitionInflater.from(this);
        Transition transition = inflater.inflateTransition(R.transition.transition_details);
        getWindow().setSharedElementEnterTransition(transition);
        if(transition!= null){

            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {

                }

                @Override
                public void onTransitionEnd(Transition transition) {

                    transition.removeListener(this);
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });

            return true;
        }
        return false;
    }
}
