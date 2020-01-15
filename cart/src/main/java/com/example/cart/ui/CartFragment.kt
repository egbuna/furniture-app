package com.example.cart.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cart.R
import com.example.cart.dagger.inject
import com.example.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cart.*
import javax.inject.Inject

class CartFragment : BaseFragment(), CartItemAdapter.DeleteItemListener {

    @Inject
    lateinit var mCartViewModel: CartViewModel

    private lateinit var mCartItemAdapter: CartItemAdapter
    private lateinit var mCartRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        mCartItemAdapter = CartItemAdapter(context!!)
        mCartItemAdapter.deleteItemListener = this
        mCartRecyclerView = view.findViewById(R.id.cart_item_recycler_view)
        mCartRecyclerView.setHasFixedSize(true)
        mCartRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mCartRecyclerView.adapter = mCartItemAdapter
        // Inflate the layout for this fragment
        return view
    }

    override fun bindViews(views: View) {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(this)
    }

    override fun setUp(view: View) {
        mCartViewModel.getAllCartItem().observe(this, Observer {
            mCartItemAdapter.add(ArrayList(it))
            val totalAmount = it.sumBy { it.price.toFloat().toInt() }
            cart_title.text = "CART(${it.size})"
            shipping.text = "Shipping $0.00"
            sub_total.text = "Sub total \$${totalAmount.toFloat()}"
            total.text = "Total \$${totalAmount.toFloat()}"
        })
    }

    companion object {
        fun newInstance(): CartFragment {
            return CartFragment()
        }
    }

    override fun onDeleteItemClicked(itemName: String) {
        mCartViewModel.deleteCartItem(itemName = itemName)
    }
}
