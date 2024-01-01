package io.appflags.android.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import io.appflags.android.example.ui.theme.AppFlagsAndroidKotlinExampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppFlagsAndroidKotlinExampleTheme {
                AppFlagsExample()
            }
        }
    }
}

@Composable
fun AppFlagsExample(appFlagsViewModel: AppFlagsViewModel = viewModel()) {
    Column {
        Text("AppFlags Android Example", style=MaterialTheme.typography.headlineSmall)
        if (appFlagsViewModel.testEnabled.value) {
            Text("The `test` feature is: enabled")
        } else {
            Text("The `test` feature is: disabled")
        }
        Text("The `string_flag` value is: " + appFlagsViewModel.string.value)
    }
}