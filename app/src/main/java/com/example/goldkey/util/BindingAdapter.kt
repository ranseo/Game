package com.example.goldkey.util

import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.w3c.dom.Text

@BindingAdapter("app:visibilityToggle")
fun changeVisiblityForImageView(view: ImageView, toggle: Boolean){
    if(toggle)
        view.visibility = VISIBLE
    else
        view.visibility = INVISIBLE
}

@BindingAdapter("app:visibilityToggle")
fun changeVisiblityForTextView(view: TextView, toggle: Boolean){
    if(!toggle)
        view.visibility = VISIBLE
    else
        view.visibility = INVISIBLE
}



