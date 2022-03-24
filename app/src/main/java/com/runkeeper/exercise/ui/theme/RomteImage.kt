package com.runkeeper.exercise.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.runkeeper.exercise.R


@Composable
fun RemoteImage(
    modifier: Modifier,
    data: String,
) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_error),
        contentDescription = "",
        modifier = modifier,
        error =  painterResource(R.drawable.ic_error)
    )


}