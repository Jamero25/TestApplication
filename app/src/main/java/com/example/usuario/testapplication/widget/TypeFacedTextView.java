package com.example.usuario.testapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.usuario.testapplication.R;


/**
 * Created by Usuario on 26/02/2016.
 */
public class TypeFacedTextView extends TextView {


    public TypeFacedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        //Typeface.createFromAsset doesn't work in the layout editor. Skipping...
        if (isInEditMode()) {
            return;
        }

        TypedArray styledAttrs = context.obtainStyledAttributes(attributeSet, R.styleable.TypeFacedTextView);
        String fontName = styledAttrs.getString(R.styleable.TypeFacedTextView_typeface);
        styledAttrs.recycle();

        if (fontName != null) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            setTypeface(typeface);
        }
    }
}
