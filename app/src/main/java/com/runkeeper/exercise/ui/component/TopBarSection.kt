package com.runkeeper.exercise.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.runkeeper.exercise.R
import com.runkeeper.exercise.ui.theme.Blue


@Composable
fun TopBarSection() {
    TopAppBar(
        title = {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.achievements),
                    modifier = Modifier
                        .padding(end = 25.dp),
                    color = MaterialTheme.colors.onPrimary
                )
            }

        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Color.White
            )

        },
        backgroundColor = Blue,
        contentColor = MaterialTheme.colors.primary,
        elevation = 0.dp,
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "",
                tint = Color.White
            )
        },
    )
}