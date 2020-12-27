package com.android.menu.newsapp.base

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding : ViewDataBinding> : Fragment(), Base {

    abstract fun setupBinding(binding: Binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<Binding>(inflater, layoutID, container, false).run {
            lifecycleOwner = this@BaseFragment
            setupBinding(this)
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initialize(savedInstanceState)
    }
}