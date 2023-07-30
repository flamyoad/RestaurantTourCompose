package com.example.restauranttourcompose.ui.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantTourAppBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
//    title: @Composable () -> Unit,
    titleText: String,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        actions = actions,
        navigationIcon = navigationIcon,
        title = {
            Text(
                text = titleText,
                style = MaterialTheme.typography.bodyMedium
            )
        },
    )
}