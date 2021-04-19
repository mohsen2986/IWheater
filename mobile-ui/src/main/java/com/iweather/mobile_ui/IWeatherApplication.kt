package com.iweather.mobile_ui

import android.app.Application
import android.content.Context
//import com.iweather.cache.cacheModule
import com.facebook.stetho.Stetho
import com.iweather.cache.cacheModule
import com.iweather.data.dataModule
import com.iweather.domain.domainModule
import com.iweather.remote.remoteModule
import com.iweather.presentation.presentationModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class IWeatherApplication(): Application() , KodeinAware{
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@IWeatherApplication))
        bind<Context>() with singleton { applicationContext }

        import(domainModule)
        import(dataModule)
        import(remoteModule)
        import(cacheModule)
        import(presentationModule)
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

    }

}