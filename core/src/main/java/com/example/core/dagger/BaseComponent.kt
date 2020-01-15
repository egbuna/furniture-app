package com.example.core.dagger

import android.app.Activity
import androidx.fragment.app.Fragment

interface BaseComponent<T> {
    fun inject(target: T)
}

/*
* Base dagger for use in Activity
*/

interface BaseActivityComponent<T: Activity> : BaseComponent<T>

/*
 Base dagger for use in Fragment
  */
interface BaseFragmentComponent<T: Fragment>: BaseComponent<T>