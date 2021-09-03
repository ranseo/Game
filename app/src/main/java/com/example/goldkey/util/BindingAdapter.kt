package com.example.goldkey.util

import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.goldkey.R
import org.w3c.dom.Text

//@BindingAdapter("app:visibilityToggle")
//fun changeVisiblityForImageView(view: ImageView, toggle: Boolean){
//    if(toggle)
//        view.visibility = VISIBLE
//    else
//        view.visibility = INVISIBLE
//}
//
//@BindingAdapter("app:visibilityToggle")
//fun changeVisiblityForTextView(view: TextView, toggle: Boolean){
//    if(!toggle)
//        view.visibility = VISIBLE
//    else
//        view.visibility = INVISIBLE
//}

@BindingAdapter(value = ["app:visibilityToggle","android:flag"], requireAll =true)
fun changeVisiblityForConstraintLayout(view: ConstraintLayout, toggle: Boolean, flag:Boolean){

    if(flag) {
        if (toggle)
            view.visibility = VISIBLE
        else
            view.visibility = INVISIBLE
    } else {
        if(!toggle)
            view.visibility = VISIBLE
        else
            view.visibility = INVISIBLE
    }
}

@BindingAdapter("android:setAnimation")
fun setAniamtion(view:ImageView, anim: Animation){

    view.animation= anim
}



