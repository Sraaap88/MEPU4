package com.moietplusultra.ui

import android.content.Context
import android.graphics.Color
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.content.ContextCompat
import com.moietplusultra.R

object BottomNavigationViewHelper {

    fun setupBottomNavigationView(navView: BottomNavigationView, context: Context) {
        navView.itemIconTintList = ContextCompat.getColorStateList(context, R.color.bottom_nav_icon_selector)
        navView.itemTextColor = ContextCompat.getColorStateList(context, R.color.bottom_nav_text_selector)
        navView.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        navView.labelVisibilityMode = BottomNavigationView.LABEL_VISIBILITY_LABELED
        navView.itemRippleColor = ContextCompat.getColorStateList(context, R.color.ripple_soft)
    }
}
