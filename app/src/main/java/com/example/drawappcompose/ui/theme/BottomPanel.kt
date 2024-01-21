package com.example.drawappcompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomPanel(onClick: (Color) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Colorlist() { color ->
            onClick(color)
        }
    }
}

@Composable
fun Colorlist(onClick: (Color) -> Unit) {
    val colors = listOf(
        Color.Blue,
        Color.Black,
        Color.Green,
        Color.Red,
        Color.Magenta,
        Color.DarkGray
    )

    LazyRow(modifier = Modifier.padding(10.dp)) {
        items(colors) { color ->
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        onClick(color)
                    }
                    .size(40.dp)
                    .background(color, CircleShape)
            )

        }
    }
}
