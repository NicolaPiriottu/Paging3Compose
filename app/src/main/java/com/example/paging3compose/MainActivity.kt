package com.example.paging3compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.paging3compose.navigation.SetupNavGraph
import com.example.paging3compose.ui.theme.Paging3ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Paging3ComposeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Paging3ComposeTheme {

    }
}