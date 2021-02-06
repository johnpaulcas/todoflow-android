package com.learn.todoflow.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author johnpaulcas
 * @since 06/02/2021
 */
abstract class BaseFragment(
    @LayoutRes layoutResourceId: Int
): Fragment(layoutResourceId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBindViewResource(view)
        init()
    }

    abstract fun onBindViewResource(view: View)

    abstract fun init()

}