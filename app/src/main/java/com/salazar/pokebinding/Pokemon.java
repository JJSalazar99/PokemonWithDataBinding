package com.salazar.pokebinding;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class Pokemon {
    public final String name;
    public final String url;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @BindingAdapter({"imageUrl", "error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Picasso.get()
                .load(url)
                .error(error)
                .into(view);
    }
}
