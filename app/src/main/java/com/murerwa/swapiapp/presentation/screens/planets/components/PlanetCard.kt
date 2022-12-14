package com.murerwa.swapiapp.presentation.screens.planets.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.murerwa.swapiapp.PlanetsQuery
import com.murerwa.swapiapp.presentation.theme.MaroonPrimary
import com.murerwa.swapiapp.presentation.theme.OrangePrimary
import com.murerwa.swapiapp.presentation.utils.commaSeparated

@Composable
fun PlanetCard(
    planet: PlanetsQuery.Planet?
) {
    Card(
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 8.dp, bottom = 2.dp, start = 8.dp, end = 8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(all = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = planet?.name ?: "",
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = OrangePrimary
                )
                Text(
                    text = "1 year is ${planet?.orbitalPeriod ?: 0} days here",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaroonPrimary
                )
                Text(
                    text = "${(planet?.population ?: 0).commaSeparated()} population",
                    color = Color.Black,
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PlanetCardPreview() {
    PlanetCard(null)
}