package com.nndnp.cameraxbasic

import android.app.Application
import timber.log.Timber

class CameraXApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(MyDebugTree())
    }
}

class MyDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return String.format(
            "[C:%s] [L:%s] [M:%s] ",
            super.createStackElementTag(element),
            element.lineNumber,
            element.methodName
        )
    }
}