package com.android.menu.newsapp.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.menu.newsapp.R
import com.android.menu.newsapp.data.local.entity.NewsEntity
import com.android.menu.newsapp.databinding.ItemSavedNewsBinding

class SavedNewsItemAdapter : RecyclerView.Adapter<SavedNewsItemAdapter.SavedNewsItemViewHolder>() {


    private var mList = ArrayList<NewsEntity>()

    fun loadData(list: List<NewsEntity>) {
        mList = list as ArrayList<NewsEntity>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedNewsItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemSavedNewsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_saved_news, parent, false
        )
        return SavedNewsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedNewsItemViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size


    inner class SavedNewsItemViewHolder(private val binding: ItemSavedNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            newsEntity: NewsEntity
        ) {
            binding.newsModel = newsEntity

        }
    }

}