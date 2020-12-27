package com.android.menu.newsapp.ui.home.view.fragment

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.menu.newsapp.R
import com.android.menu.newsapp.base.BaseFragment
import com.android.menu.newsapp.databinding.FragmentSavedNewsBinding
import com.android.menu.newsapp.ui.home.view.adapter.NewsItemAdapter
import com.android.menu.newsapp.ui.home.view.adapter.SavedNewsItemAdapter
import com.android.menu.newsapp.ui.home.viewmodel.SavedNewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_saved_news.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SavedNewsFragment : BaseFragment<FragmentSavedNewsBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() =
            SavedNewsFragment()
    }

    override val layoutID: Int
        get() = R.layout.fragment_saved_news

    private val mSavedNewsViewModel by sharedViewModel<SavedNewsViewModel>()
    private lateinit var mAdapter: SavedNewsItemAdapter

    override fun setupBinding(binding: FragmentSavedNewsBinding) {

    }

    /** init method( working onViewCreated) **/

    override fun initialize(savedInstanceState: Bundle?) {
        super.initialize(savedInstanceState)
        initAdapter()
        initObservers()
    }

    private fun initAdapter() {
        mAdapter = SavedNewsItemAdapter()
        savedNewsRv.layoutManager = LinearLayoutManager(requireContext())
        savedNewsRv.adapter = mAdapter
    }

    private fun initObservers() {
        mSavedNewsViewModel.getSavedNews.observe(viewLifecycleOwner, {
            mAdapter.loadData(it)
        })

    }

}