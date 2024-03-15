package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.draw.scale
import com.example.assignment3.ui.theme.Assignment3Theme
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class TransitionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TransitionAnimScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun TransitionAnimScreen() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(0.5f) }
    val translationY = remember { Animatable(1000f) }
    Row {
        Button(onClick = {
            coroutineScope.launch {
                awaitAll(
                    async { scale.animateTo(targetValue = if (scale.value == 0.5f) 0.2f else 0.5f, animationSpec = tween(durationMillis = 1000)) },
                    async { translationY.animateTo(targetValue = if (translationY.value == 1000f) -700f else 1000f, animationSpec = tween(durationMillis = 1000)) }
                )

            }
        }) {
            if (scale.value == 0.5f) {
                Text("Launch Rocket")
            }
            else {
                Text("Land Rocket")
            }
        }

        Image(
            painter = painterResource(R.drawable.rocket),
            contentDescription = "Animated Image",
            modifier = Modifier
                .scale(scale.value)
                .offset(y = translationY.value.dp)
        )
    }

}