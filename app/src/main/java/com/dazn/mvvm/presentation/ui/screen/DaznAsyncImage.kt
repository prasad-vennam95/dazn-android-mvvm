package com.dazn.mvvm.presentation.ui.screen


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.dazn.mvvm.R

@Composable
fun DaznAsyncImage(
    imageUrl: String,
    withCrossFade: Boolean,
    crossFadeDuration: Int = 100,
    modifier: Modifier,
    contentScale: ContentScale,
    alignment: Alignment = Alignment.TopCenter,
    placeholder: Int? = null,
    error: Int? = null,
    colorFilter: ColorFilter? = null,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).apply {
            data(imageUrl)
            decoderFactory(SvgDecoder.Factory())
            if (placeholder != null) {
                placeholder(placeholder)
            }
            if (error != null) {
                error(error)
            }
            if (withCrossFade) {
                crossfade(true)
                crossfade(crossFadeDuration)
            }
        }.build(),
        contentDescription = stringResource(R.string.empty),
        modifier = modifier,
        contentScale = contentScale,
        alignment = alignment,
        colorFilter = colorFilter
    )
}