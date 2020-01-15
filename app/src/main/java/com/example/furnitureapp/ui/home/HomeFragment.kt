package com.example.furnitureapp.ui.home


import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.example.furnitureapp.R
import com.example.core.base.BaseFragment
import com.example.furnitureapp.ui.home.bathroom.BathRoomFragment
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment
import com.example.furnitureapp.utils.CustomPagerAdapter
import com.ogaclejapan.smarttablayout.SmartTabLayout
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    override fun bindViews(views: View) {
        mViewPager = views.findViewById(R.id.viewpager)
        mSmartTabLayout = views.findViewById(R.id.viewpagertab)

    }

    override fun setUp(view: View) {
        mPagerAdapter = CustomPagerAdapter(childFragmentManager)

        mPagerAdapter.addFragment(LivingRoomFragment.newInstance(), "LIVING ROOM")
        mPagerAdapter.addFragment(BathRoomFragment.newInstance(), "BATHROOM")
        mPagerAdapter.addFragment(LivingRoomFragment.newInstance(), "BEDROOM")
        mPagerAdapter.addFragment(LivingRoomFragment.newInstance(), "DINING ROOM")

        //mViewPager.isPagingEnabled = false
        mViewPager.adapter = mPagerAdapter
        mSmartTabLayout.setViewPager(mViewPager)
    }

    private lateinit var mPagerAdapter: CustomPagerAdapter

    private lateinit var mViewPager: ViewPager
    private lateinit var mSmartTabLayout: SmartTabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

}
