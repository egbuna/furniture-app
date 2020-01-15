package com.example.furnitureapp.ui.home.bathroom


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.furnitureapp.R
import com.example.core.base.BaseFragment

class BathRoomFragment : BaseFragment() {
    override fun bindViews(views: View) {

    }

    override fun setUp(view: View) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bath_room, container, false)
    }

    companion object {
        fun newInstance(): BathRoomFragment {
            val fragment = BathRoomFragment()
            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

}
