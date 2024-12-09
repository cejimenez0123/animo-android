package com.solbao.animo.android.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

@Composable
fun Dashboard() {
    Column {
        Column(modifier = Modifier.weight(1f)){
           Text(text = "Hello")
        }
        Column(modifier = Modifier.weight(1f)){
            LazyVerticalGrid() { }
        }

    }
}