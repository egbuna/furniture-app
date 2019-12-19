package com.example.furnitureapp.base

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.furnitureapp.MyApplication
import com.example.furnitureapp.di.AppComponent
import com.example.furnitureapp.di.DaggerAppComponent
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavTransactionOptions

abstract class BaseActivity : AppCompatActivity() {

    var mNavController: FragNavController? = null
    private var onBackClickedListener: OnBackClicked? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun <V : View> Activity.bind(@IdRes resource: Int): V {
        val lazyValue: Lazy<V> = lazy { findViewById<V>(resource)!! }
        return lazyValue.value
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        bindViews()
        setUp()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mNavController?.onSaveInstanceState(outState)
    }

    fun pushFragment(fragment: Fragment, transactionOptions: FragNavTransactionOptions? = null) {
        mNavController?.pushFragment(fragment, transactionOptions)
    }

    fun replaceFragment(fragment: Fragment, transactionOptions: FragNavTransactionOptions? = null) {
        mNavController?.replaceFragment(fragment, transactionOptions)
    }

    fun clearFragments() {
        mNavController?.clearStack()
    }

    fun showDialog(dialogFragment: DialogFragment) {
        mNavController?.showDialogFragment(dialogFragment)
    }

    fun hideDialog() {
        mNavController?.clearDialogFragment()
    }

    override fun onBackPressed() {
        if (mNavController == null || mNavController?.isRootFragment!!)
            super.onBackPressed()
        else {
            if (onBackClickedListener != null)
                onBackClickedListener?.onBackClicked()
            mNavController?.popFragment()
        }
    }

    fun popFragments(depth: Int = 0) {
        if (depth > 0) mNavController?.popFragments(depth) else mNavController?.popFragment()
    }

    interface OnBackClicked {
        fun onBackClicked()
    }

    abstract fun bindViews()
    abstract fun setUp()
}
