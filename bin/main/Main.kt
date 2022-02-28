// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

@Composable
@Preview
fun App() {
    val AppTheme = lightColors(
        primary = Color(0xff91a4fc),
        secondary = Color(0xffffeb46),
        background = Color.Gray
    )
    MaterialTheme (
        colors = AppTheme
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize(),
        ){
            val stopWatch = remember { StopWatch() }
            StopWatchDisplay(
                formattedTime   = stopWatch.formattedTime,
                onStartClick    = stopWatch::start,
                onPauseClick    = stopWatch::pause,
                onResetClick    = stopWatch::reset,
            )
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        resizable = false,
        state = rememberWindowState(
            width = 1280.dp,
            height = 720.dp,
            placement = WindowPlacement.Maximized
        ),
        title = "Compose Stopwatch",
    ) {
        App()
    }
}
