package com.android.menu.newsapp.ui.home.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.menu.newsapp.R
import com.android.menu.newsapp.base.BaseFragment
import com.android.menu.newsapp.databinding.FragmentNewsBinding
import com.android.menu.newsapp.ui.home.model.NewsItem
import com.android.menu.newsapp.ui.home.view.adapter.NewsItemAdapter
import com.android.menu.newsapp.ui.home.viewmodel.NewsViewModel
import com.android.menu.newsapp.ui.home.viewmodel.SavedNewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() =
            NewsFragment()
    }

    override val layoutID: Int
        get() = R.layout.fragment_news

    private val mNewsViewModel by sharedViewModel<NewsViewModel>()
    private val mSavedNewsViewModel by sharedViewModel<SavedNewsViewModel>()

    private lateinit var mAdapter: NewsItemAdapter


    override fun setupBinding(binding: FragmentNewsBinding) {
        binding.model = mNewsViewModel
    }

    /** init method( working onViewCreated) **/

    override fun initialize(savedInstanceState: Bundle?) {
        super.initialize(savedInstanceState)
        initAdapter()
        initObservers()
    }

    private fun initAdapter() {
        mAdapter = NewsItemAdapter() { newsItem ->
            saveItem(newsItem)
        }
        newsRv.layoutManager = LinearLayoutManager(requireContext())
        newsRv.adapter = mAdapter
    }

    private fun initObservers() {
        mNewsViewModel.getNewsLiveData().observe(viewLifecycleOwner, {
            it.channel?.itemList?.let { it1 -> mAdapter.loadData(it1) }

        })
        mNewsViewModel.getMockNewsLiveData().observe(viewLifecycleOwner,{
            mAdapter.loadMockData(it)
        })
    }

    private fun saveItem(newsItem: NewsItem) {
        mSavedNewsViewModel.saveNews(newsItem)
    }

}