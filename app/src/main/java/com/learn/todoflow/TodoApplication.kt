package com.learn.todoflow

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @author johnpaulcas
 * @since 06/02/2021
 */
@HiltAndroidApp
class TodoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Setup timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }

}