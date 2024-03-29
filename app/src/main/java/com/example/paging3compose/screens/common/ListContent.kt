package com.example.paging3compose.screens.common

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.paging3compose.R
import com.example.paging3compose.model.UnsplashImage
import com.example.paging3compose.model.Urls
import com.example.paging3compose.model.User
import com.example.paging3compose.model.UserLinks
import com.example.paging3compose.ui.theme.HeartRed
import com.example.paging3compose.utils.DialogScreen

/**
 * Created by Nicola Luigi Piriottu on 19/07/22.
 */

@Composable
fun ListContent(items: LazyPagingItems<UnsplashImage>) {

    Log.d("niKO", "items\n${items.loadState.toString()}")
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = items, key = { unsplashImage -> unsplashImage.id }) { unsplashImage ->
            unsplashImage?.let { UnsplashItem(unsplashImage = it) }
        }
    }
}

@Composable
fun UnsplashItem(unsplashImage: UnsplashImage) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(unsplashImage.urls.regular)
            .crossfade(durationMillis = 1000)
            .build(),
        placeholder = painterResource(R.drawable.placeholder),
        contentScale = ContentScale.Crop
    )

    val context = LocalContext.current

    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value){
        DialogScreen(
            showDialog= showDialog.value,
            titleResId = R.string.app_name,
            message = "",
            positiveButtonMessage = R.string.app_name,
            negativeButtonMessage = R.string.app_name, onPositiveButton = {

            }, onNegativeButton = {
                showDialog.value = false
            })
    }
    Box(modifier = Modifier
        .clickable {
            /*val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://unsplash.com/@${unsplashImage.user.username}?utm_source=DemoApp&utm_medium=referral")
            )
            startActivity(context, browserIntent, null)*/

            showDialog.value = true
        }
        .height(300.dp)
        .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painter,
            contentDescription = "Unsplash Image",
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(ContentAlpha.medium),
            color = Color.Black
        ) {}
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Photo by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(unsplashImage.user.username)
                    }
                    append(" on Unsplash")
                },
                color = Color.White,
                fontSize = MaterialTheme.typography.caption.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            LikeCounter(
                modifier = Modifier.weight(3f),
                painter = painterResource(id = R.drawable.heart),
                likes = "${unsplashImage.likes}"
            )
        }
    }
}


@Composable
fun LikeCounter(modifier: Modifier, painter: Painter, likes: String) {

    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {

        Icon(painter = painter, contentDescription = "Heart Icon", tint = HeartRed)
        Divider(modifier = Modifier.width(6.dp))
        Text(
            text = likes,
            color = Color.White,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Composable
@Preview(showBackground = true)
fun UnsplashImagePreview() {
    UnsplashItem(
        unsplashImage = UnsplashImage(
            id = "1",
            urls = Urls(regular = ""),
            likes = 100,
            user = User(username = "niko", links = UserLinks(html = ""))
        )
    )
}