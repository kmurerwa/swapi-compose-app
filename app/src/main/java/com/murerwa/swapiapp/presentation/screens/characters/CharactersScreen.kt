package com.murerwa.swapiapp.presentation.screens.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.murerwa.swapiapp.presentation.theme.OrangePrimary

@Composable
fun CharactersScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(OrangePrimary),
    ) {

    }
}

@Composable
@Preview(showBackground = true)
fun CharactersScreenPreview() {
    CharactersScreen()
}