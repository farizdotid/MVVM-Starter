package com.app.mvvmstarter.binding

import android.graphics.Color
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.app.mvvmstarter.extensions.gone
import com.app.mvvmstarter.extensions.visible
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import kotlin.math.abs

@BindingAdapter("loadImage")
fun bindLoadImage(view: AppCompatImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}

@BindingAdapter("pagerAdapter")
fun bindPagerAdapter(view: ViewPager, adapter: PagerAdapter) {
    view.adapter = adapter
    view.offscreenPageLimit = 3
}

@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean) {
    view.gone(shouldBeGone)
}

// -- UNCOMMENT THIS FUNCTION FOR BOTTOM NAVIGATION FUNCTION
/*
@BindingAdapter("bindNavigation")
fun bindNavigation(view: ViewPager, navigationView: BottomNavigationView) {
    view.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) = Unit
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) = Unit

        override fun onPageSelected(position: Int) {
            navigationView.menu.getItem(position).isChecked = true
        }
    })

    navigationView.setOnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.action_one -> view.currentItem = 0
            R.id.action_two -> view.currentItem = 1
            R.id.action_three -> view.currentItem = 2
        }
        true
    }
}
 */

@BindingAdapter("bindFab")
fun bindAppBarLayoutWithFab(appBarLayout: AppBarLayout, fab: FloatingActionButton) {
    appBarLayout.addOnOffsetChangedListener(
        AppBarLayout.OnOffsetChangedListener { appBarLayout1: AppBarLayout, verticalOffset: Int ->
            val verticalOffsetPercentage = abs(
                verticalOffset
            ).toFloat() / appBarLayout1.totalScrollRange.toFloat()
            if (verticalOffsetPercentage > 0.4f && fab.isOrWillBeShown) {
                fab.hide()
            } else if (verticalOffsetPercentage <= 0.4f && fab.isOrWillBeHidden && fab.tag != View.GONE) {
                fab.show()
            }
        })
}

@BindingAdapter("transformFab", "transformContainer")
fun bindTransformFab(view: View, fab: FloatingActionButton, container: CoordinatorLayout) {
    fab.setOnClickListener {
        // Begin the transition by changing properties on the start and end views or
        // removing/adding them from the hierarchy.
        fab.tag = View.GONE
        TransitionManager.beginDelayedTransition(container, getTransform(fab, view))
        fab.gone(true)
        view.visible()
    }

    view.setOnClickListener {
        fab.tag = View.VISIBLE
        TransitionManager.beginDelayedTransition(container, getTransform(view, fab))
        fab.visible()
        view.gone(true)
    }
}

internal fun getTransform(mStartView: View, mEndView: View): MaterialContainerTransform {
    return MaterialContainerTransform().apply {
        startView = mStartView
        endView = mEndView
        pathMotion = MaterialArcMotion()
        duration = 650
        scrimColor = Color.TRANSPARENT
    }
}