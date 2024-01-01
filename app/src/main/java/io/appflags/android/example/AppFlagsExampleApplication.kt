package io.appflags.android.example

import android.app.Application
import io.appflags.android.AppFlagsClient
import io.appflags.android.models.AppFlagsUser

class AppFlagsExampleApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        AppFlagsClient.init(
            applicationContext,
            "YOUR_CLIENT_KEY", // Modify this to your client key
            AppFlagsUser("x")
        )
    }
}