package com.example.furnitureapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import com.example.furnitureapp.R
import com.example.furnitureapp.base.BaseFragment
import com.example.furnitureapp.data.model.HomeItem
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun bindViews(views: View) {

    }

    override fun setUp(view: View) {
        val homeItem = arguments?.getParcelable<HomeItem>("HomeItem")
        with(homeItem) {
            rating_text.text = this?.rating
            Glide.with(context!!)
                .load(this?.image)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.favorite_selected)
                        .error(R.drawable.favorite)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(furniture_image)
        }

        cancel.setOnClickListener { baseActivity.onBackPressed() }

        add_to_cart.setOnClickListener { Toast.makeText(context, "Added to cart", Toast.LENGTH_LONG).show() }
    }

    companion object {

        fun newInstance(homeItem: HomeItem): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putParcelable("HomeItem", homeItem)
            fragment.arguments = args
            return fragment
        }
    }
}
