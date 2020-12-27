package com.android.menu.newsapp.ui.home.view.activity

import android.os.Bundle
import com.android.menu.newsapp.R
import com.android.menu.newsapp.base.BaseActivity
import com.android.menu.newsapp.databinding.ActivityMainBinding
import com.android.menu.newsapp.ui.home.view.adapter.viewpager.ViewPagerAdapter
import com.android.menu.newsapp.ui.home.view.fragment.NewsFragment
import com.android.menu.newsapp.ui.home.view.fragment.SavedNewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(override val layoutID: Int = R.layout.activity_main) :
    BaseActivity<ActivityMainBinding>() {

    private lateinit var adapter: ViewPagerAdapter

    override fun initialize(savedInstanceState: Bundle?) {
        super.initialize(savedInstanceState)
        initPagerAdapter()
    }

    private fun initPagerAdapter() {
        adapter = ViewPagerAdapter(
            this.supportFragmentManager
        ).apply {
            addFragment(
                NewsFragment.newInstance(),
                getString(R.string.news)
            )
            addFragment(
                SavedNewsFragment.newInstance(),
                getString(R.string.saved)
            )

        }
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)

    }

}
