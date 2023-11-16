package com.example.apollo_kmm.android.ui.country

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apollo_kmm.model.CountryDetails

@Composable
fun CountryDetailsScreen(
    modifier: Modifier = Modifier,
    countryDetails: CountryDetails
) {

    val languages = remember(countryDetails.languages) {
        countryDetails.languages.joinToString()
    }

    Column(
        modifier = modifier.background(color = Color.White)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = countryDetails.emoji,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = countryDetails.name,
                fontSize = 24.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Continent: " + countryDetails.continent)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Currency: " + countryDetails.currency)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Capital: " + countryDetails.capital)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Language(s): $languages")
        Spacer(modifier = Modifier.height(8.dp))
    }
}