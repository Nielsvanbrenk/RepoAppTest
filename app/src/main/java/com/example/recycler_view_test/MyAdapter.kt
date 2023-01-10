package com.example.recycler_view_test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MyAdapter(
    private val imageUrls: List<String>,
    private val listener: OnItemClickListener
    ) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        GET DATA FROM API


        val imageUrl = imageUrls[position]

        val imageUri = "https://i.imgur.com/tGbaZCY.jpg"
        Picasso.get().load(imageUri).into(holder.imageView)

        val repoTitle: TextView = holder.itemView.findViewById(R.id.text)
        repoTitle.text = position.toString()
    }

    override fun getItemCount(): Int = imageUrls.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = bindingAdapterPosition
            val context = itemView.context
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position, context)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int, context: Context)
    }
}