package com.example.androiddemo

import androidx.recyclerview.widget.DiffUtil
import com.example.eni_shop.bo.Article

class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id;
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id;
    }
}