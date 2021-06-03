package com.example.unsplashimages.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplashimages.Model.Result
import com.example.unsplashimages.R

class ImageAdapter(
    private val context: Context
) : ListAdapter<Result, ImageAdapter.ImageHolder>(DIFF_ITEM_CALLBACK) {

    companion object {
        val DIFF_ITEM_CALLBACK = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.items, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {

        holder.bind(getItem(position))

    }

    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: AppCompatImageView = itemView.findViewById(R.id.image)
        private val description: AppCompatTextView = itemView.findViewById(R.id.description)
        private val likes: AppCompatTextView = itemView.findViewById(R.id.likes)

        fun bind(result: Result) {
            description.text = result.description
            likes.text = result.likes.toString()

            Glide.with(itemView.context)
                .load(result.urls.full + "&w=1500&dpr=2")
                .into(image)

        }
    }


}