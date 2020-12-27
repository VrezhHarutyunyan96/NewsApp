package com.android.menu.newsapp.utils.bindingadapter

import android.widget.CheckBox
import androidx.databinding.BindingAdapter
import com.google.android.material.switchmaterial.SwitchMaterial

interface OnCheckedChangedListener {
    fun onCheckedChanged(state: Boolean)
}

@BindingAdapter("switch_listener")
fun addSwitchListener(view: SwitchMaterial, listener: OnCheckedChangedListener) {
    view.setOnCheckedChangeListener { _, isChecked ->
        listener.onCheckedChanged(isChecked)
    }
}