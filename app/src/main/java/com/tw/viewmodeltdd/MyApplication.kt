package com.tw.viewmodeltdd

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
//            modules(listOf(MyModule.module))
        }
    }
}

private object MyModule {
//    var module = module {
//        factory { (activity: MyActivityWithViewModel) -> Router(activity) }
//        viewModel { (router: Router) -> MyViewModel(router) }
//    }
}