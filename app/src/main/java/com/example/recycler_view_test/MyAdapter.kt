package com.example.recycler_view_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class MyAdapter(private val imageUrls: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl = imageUrls[position]

//        Picasso.get()
//            .load(imageUrl)
//            .into(holder.imageView)

        val imageUri = "https://i.imgur.com/tGbaZCY.jpg"
        Picasso.get().load(imageUri).into(holder.imageView);

//        Glide.with(holder.itemView.context)
//            .load(imageUrl)
//            .override(holder.imageView.width, holder.imageView.height)
//            .into(holder.imageView)
    }

    override fun getItemCount(): Int = imageUrls.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.image_view)
    }
}