package com.example.beltexam2_rawanalanzi.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beltexam2_rawanalanzi.databinding.ApiItemBinding
import com.example.beltexam2_rawanalanzi.model.data.TvShowItemItem


class APIAdapter(val tvShowClickInterface: TvShowClickInterface):ListAdapter<TvShowItemItem, APIAdapter.ViewHolder>(
    TvShowDiffUtil()
) {
    class ViewHolder(var binding:ApiItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder(ApiItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
//var name:String,var language:String,var summary:String
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val tvShow=getItem(position)
// https://api.tvmaze.com/search/shows?q=girls

        holder.binding.apply{
            if (tvShow!=null)
            {
                Log.d("TAG", "onBindViewHolder: testAPI")
                tvImageText.text=tvShow.name
                val Link="https://api.tvmaze.com/search/${tvShow.name}.jpg"
                Glide.with(this.root.context).load(Link).into(photoView)
                conLayout.setOnClickListener {
                    tvShowClickInterface.seveToLocalDB(tvShow)
                    }
            }

        }
    }
    interface TvShowClickInterface{
         fun seveToLocalDB(tvShow: TvShowItemItem)


    }

}