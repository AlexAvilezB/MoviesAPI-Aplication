package com.example.moviesapi.helpers

import android.widget.ImageView
import com.bumptech.glide.Glide

/// Se esconde la implementación de Glide en un extension method.
/// Si cambiamos de libreria o implementación nos ahorramos cambiar todas las referencias.
fun ImageView.setImage(url: String) {
    Glide.with(context).load(url).into(this)
}