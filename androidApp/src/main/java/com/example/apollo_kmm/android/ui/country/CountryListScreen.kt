package com.example.apollo_kmm.android.ui.country

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apollo_kmm.android.ui.ErrorScreen
import com.example.apollo_kmm.android.ui.LoadingScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CountryListScreen(
    modifier: Modifier = Modifier,
    viewModel: CountryScreenModel
) {
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
    )

    ModalBottomSheetLayout(
        modifier = modifier,
        sheetState = modalSheetState,
        sheetContent = {
            viewModel.countryDetails?.let {
                CountryDetailsScreen(countryDetails = it)
            }
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            
            if (viewModel.isLoading) {
                LoadingScreen()
            }
            
            viewModel.error?.let { 
                ErrorScreen(error = it.errorMessage)
            }
            
            val countries = viewModel.countries
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                items(
                    items = countries,
                    key = { it.code }
                ) {
                    CountryItem(country = it) {
                        viewModel.onGetCountryDetails(it.code)
                    }
                }
            }
        }

        viewModel.countryDetails?.let {
            coroutineScope.launch {
                if (modalSheetState.isVisible) modalSheetState.hide()
                else modalSheetState.show()
            }
        }
    }
}