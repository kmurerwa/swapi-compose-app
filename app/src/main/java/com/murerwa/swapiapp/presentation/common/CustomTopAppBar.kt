package com.murerwa.swapiapp.presentation.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.murerwa.swapiapp.presentation.theme.MaroonPrimary

@Composable
fun CustomTopAppBar(
    title: String,
    onBackClick: () -> Unit = {},
) {
    TopAppBar(
        title = { Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
        ) },
        navigationIcon = {
            IconButton(
                onClick = { onBackClick() }
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back arrow icon",
                    tint = Color.White,
                )
            }
        },
        backgroundColor = MaroonPrimary
    )
}

@Composable
@Preview(showBackground = true)
fun CustomTopAppBarPreview() {
    CustomTopAppBar(
        title = "Title"
    )
}