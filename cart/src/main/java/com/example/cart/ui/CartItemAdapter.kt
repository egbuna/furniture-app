package com.example.cart.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cart.R
import com.example.core.model.CartHomeItem

class CartItemAdapter(val context: Context) : RecyclerView.Adapter<CartItemAdapter.ViewHolder>() {

    var items: ArrayList<CartHomeItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    fun add(cartItems: ArrayList<CartHomeItem>) {
        this.items = cartItems
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mProductImageView: ImageView = itemView.findViewById(R.id.furniture_image)
        private val mProductName: TextView = itemView.findViewById(R.id.furniture_name)
        private val productPrice: TextView = itemView.findViewById(R.id.price)

        fun bind(position: Int) {
            with(items[position]) {
                //mProductImageView.setOnClickListener { onItemClickedListener.onItemClicked(homeItem = this) }
                mProductName.text = this.name
                productPrice.text = "\$${this.price.toFloat()}"

                com.bumptech.glide.Glide.with(context)
                    .load(this.image)
                    .apply(
                        com.bumptech.glide.request.RequestOptions()
                            .placeholder(R.drawable.favorite)
                            .error(R.drawable.favorite)
                            .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL))
                    .into(mProductImageView)
            }
        }
    }
}