package com.android.menu.newsapp.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.menu.newsapp.R
import com.android.menu.newsapp.databinding.ItemNewsBinding
import com.android.menu.newsapp.ui.home.model.NewsItem

class NewsItemAdapter(val onSaveButtonClicked: (NewsItem) -> Unit) :
    RecyclerView.Adapter<NewsItemAdapter.NewsItemViewHolder>() {

    private var mList = ArrayList<NewsItem>()

    fun loadData(list: List<NewsItem>) {
        mList = list as ArrayList<NewsItem>
        notifyDataSetChanged()
    }

    fun loadMockData(list: List<NewsItem>){
        mList = list as ArrayList<NewsItem>
        notifyDataSetChanged()
    }

    inner class NewsItemViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            newsItem: NewsItem
        ) {
            binding.newsModel = newsItem
            binding.saveImage.setOnClickListener {
                onSaveButtonClicked.invoke(newsItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemNewsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_news, parent, false
        )
        return NewsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size

}