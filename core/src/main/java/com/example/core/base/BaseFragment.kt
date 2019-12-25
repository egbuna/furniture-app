package com.example.core.base


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.annotation.IdRes

abstract class BaseFragment : Fragment() {

    lateinit var baseActivity: BaseActivity private set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
        setUp(view)
    }

    protected fun <V : View> Fragment.bind(@IdRes resource: Int): V {
        val lazyValue: Lazy<V> = lazy { view?.findViewById<V>(resource)!! }
        return lazyValue.value
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity: BaseActivity = context
            baseActivity = activity
        }
    }

    abstract fun bindViews(views: View)
    abstract fun setUp(view: View)
}
