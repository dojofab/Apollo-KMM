package com.example.apollo_kmm.android.ui.country

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apollo_kmm.model.Country

@Composable
fun CountryItem(
    modifier: Modifier = Modifier,
    country: Country,
    onCountryClick: () -> Unit
) {
    Surface(
        modifier = modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier.clickable {
                onCountryClick()
            }
        ) {
            Text(
                country.emoji,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = country.name,
                    fontSize = 20.sp
                )
                Text(
                    text = country.capital,
                    color = Color.LightGray
                )
            }
        }
    }
}