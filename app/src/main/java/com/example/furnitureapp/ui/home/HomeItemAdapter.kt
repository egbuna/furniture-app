package com.example.furnitureapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.furnitureapp.R
import com.example.furnitureapp.data.model.HomeItem
import com.github.siyamed.shapeimageview.RoundedImageView

class HomeItemAdapter(val context: Context) : RecyclerView.Adapter<HomeItemAdapter.ViewHolder>()  {

    var items: ArrayList<HomeItem> = arrayListOf()
    lateinit var onItemClickedListener: OnItemClickedListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    fun add(items: ArrayList<HomeItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mProductImageView: RoundedImageView = itemView.findViewById(R.id.product_image)

        fun bind(position: Int) {
            with(items[position]) {
                mProductImageView.setOnClickListener { onItemClickedListener.onItemClicked(homeItem = this) }

                Glide.with(context)
                    .load(this.image)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.favorite_selected)
                            .error(R.drawable.favorite)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(mProductImageView)
            }
        }
    }

    interface OnItemClickedListener {
        fun onItemClicked(homeItem: HomeItem)
    }
}