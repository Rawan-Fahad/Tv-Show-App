package com.example.beltexam2_rawanalanzi.view

import androidx.recyclerview.widget.DiffUtil
import com.example.beltexam2_rawanalanzi.model.data.TvShowItemItem

//
class TvShowDiffUtil :DiffUtil.ItemCallback<TvShowItemItem> (){
    override fun areItemsTheSame(oldItem: TvShowItemItem, newItem: TvShowItemItem): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: TvShowItemItem, newItem: TvShowItemItem): Boolean {
        return oldItem==newItem
    }


}
