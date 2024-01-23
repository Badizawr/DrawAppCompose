package com.example.drawappcompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomPanel(onClick: (Color) -> Unit, onLineWidthChange: (Float) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Colorlist{ color ->
            onClick(color)
        }
        CustomSlider{ lineWidth ->
            onLineWidthChange(lineWidth)
        }
        ButtonPanel {

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

@Composable
fun CustomSlider(onChange: (Float) -> Unit) {
    var position by remember {
        mutableStateOf(0.05f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Line width: ${(position * 100).toInt()}")
        Slider(value = position,
            onValueChange = {
                val tempPos = if (it > 0) it else 0.01f
                position = tempPos
                onChange(tempPos * 100)
            })
    }
}

@Composable
fun ButtonPanel(onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            modifier = Modifier
                .background(Color.White)
                .clip(CircleShape),
            onClick = {
            onClick()
        }) {
            Icon(
                Icons.Default.Refresh,
                contentDescription = null
            )
        }
    }
}

