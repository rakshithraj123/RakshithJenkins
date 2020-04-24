package com.devteam.jetpackusers.ui

import android.app.Application
import com.devteam.jetpackusers.common.AppViewModelFactory
import com.devteam.jetpackusers.io.RetrofitInstance
import com.devteam.jetpackusers.repository.DataRepository
import com.devteam.jetpackusers.utils.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MyApp : Application(), KodeinAware {

    override val kodein: Kodein = Kodein {

        bind<DataRepository>() with singleton {
            DataRepository(RetrofitInstance.retroService)
        }

        bind<AppViewModelFactory>() with singleton { AppViewModelFactory(instance()) }

        // Refer link https://kodein.org/Kodein-DI/?6.5/android

        // Following are the different types of Scoping. We need to test this with actual app
        //bind<AppViewModelFactory>() with scoped(WeakContextScope<Activity>()).singleton { AppViewModelFactory(instance()) }
        //bind<AppViewModelFactory>() with scoped(ActivityRetainedScope).singleton { AppViewModelFactory(instance()) }
        //bind<AppViewModelFactory>() with scoped(AndroidLifecycleScope).singleton { AppViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        val k = kodein
        Logger.d("*** $k")
    }
}