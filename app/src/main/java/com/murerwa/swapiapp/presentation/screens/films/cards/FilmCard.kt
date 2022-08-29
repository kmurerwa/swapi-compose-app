package com.murerwa.swapiapp.presentation.screens.films.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.murerwa.swapiapp.FilmsQuery

@Composable
fun FilmCard(
    film: FilmsQuery.Film?
) {
    Card(
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 8.dp, bottom = 2.dp, start = 8.dp, end = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(all = 10.dp)
                .clickable {

                },
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${film?.title}",
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Text(
                    text = "${film?.releaseDate}",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "${film?.director}"
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun FilmCardPreview() {
    FilmCard(null)
}