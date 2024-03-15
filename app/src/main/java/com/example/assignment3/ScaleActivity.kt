package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment3.ui.theme.Assignment3Theme
import kotlinx.coroutines.launch

class ScaleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScaleAnimScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun ScaleAnimScreen() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(1f) }

    Column(modifier = Modifier.padding(all = 9.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button(onClick = {
            coroutineScope.launch {
                scale.animateTo(targetValue = if (scale.value == 1f) 2f else 1f, animationSpec = tween(durationMillis = 600))
            }
        }, modifier = Modifier.scale(scale.value)) {
            Text("Click Me To Animate")
        }
    }
}