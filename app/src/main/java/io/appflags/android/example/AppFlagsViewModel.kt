package io.appflags.android.example

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.appflags.android.AppFlagsClient

class AppFlagsViewModel : ViewModel() {

    private val appFlagsClient = AppFlagsClient.getClient()

    private val testFlag = appFlagsClient.getBooleanFlag("test", false)
    val testEnabled = mutableStateOf(testFlag.value)

    private val stringFlag = appFlagsClient.getStringFlag("string_flag", "default fallback")
    val string = mutableStateOf(stringFlag.value)

    init {
        testFlag.onUpdate { updatedFlag ->
            run {
                testEnabled.value = updatedFlag.value
            }
        }

        stringFlag.onUpdate { updatedFlag ->
            run {
                string.value = updatedFlag.value
            }
        }
    }

}