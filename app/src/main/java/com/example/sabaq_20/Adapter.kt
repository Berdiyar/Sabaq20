package com.example.sabaq_20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var models: List<ListItem> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return models[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if(viewType == 1){
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads, parent, false)
            return AdsViewHolder(view)
        }
        else{
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
            return PostViewHolder(view)
        }
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == 1){
            (holder as AdsViewHolder).populateAds(models[position] as Ads)
        }
        else{
            (holder as PostViewHolder).populatePost(models[position] as Post)
        }
    }

}