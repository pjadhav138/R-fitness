package com.example.myapplication.Cutom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

@SuppressLint("AppCompatCustomView")
public class MyTextView extends EditText {
    public MyTextView(Context context) {
        super(context);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Bold.ttf");
        this.setTypeface(font);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Bold.ttf");
        this.setTypeface(font);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Bold.ttf");
        this.setTypeface(font);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Bold.ttf");
        this.setTypeface(font);
    }
}
