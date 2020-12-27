package com.android.menu.newsapp.base

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.google.android.material.textfield.TextInputEditText

abstract class BaseActivity<binding: ViewDataBinding>: AppCompatActivity(), Base {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)
        setupUI(findViewById<ViewGroup>(android.R.id.content).getChildAt(0))
        initialize(savedInstanceState)
        setListeners()
    }

    private fun setupUI(view: View) {

        if (view !is TextInputEditText && view !is EditText) {

        }

        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                setupUI(innerView)
            }
        }
    }
}