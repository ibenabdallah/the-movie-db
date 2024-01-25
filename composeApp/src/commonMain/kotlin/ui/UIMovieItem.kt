package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.size.Size
import data.AppConfig
import data.model.MovieItem
import ui.common.shimmerBrush
import ui.utils.RatingBar


@Composable
fun MovieItem(movie: MovieItem, onMovieClick: (MovieItem) -> Unit) {

    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(AppConfig.IMAGE_BASE_URL + movie.posterPath).size(Size.ORIGINAL).build()
    ).state


    Column(modifier = Modifier
        .wrapContentHeight()
        .width(200.dp)
        .padding(4.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.secondaryContainer,
                    MaterialTheme.colorScheme.secondaryContainer
                )
            )
        )
        .clickable {
            onMovieClick(movie)
        }) {

        when (imageState) {
            is AsyncImagePainter.State.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(70.dp),
                        imageVector = Icons.Rounded.Info,
                        contentDescription = "PlaceHolder"
                    )
                }
            }

            is AsyncImagePainter.State.Success -> {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    painter = imageState.painter,
                    contentDescription = movie.title,
                    contentScale = ContentScale.Crop
                )
            }

            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp).background(shimmerBrush())
                ){}
            }
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = movie.title,
            modifier = Modifier.padding(start = 16.dp, end = 8.dp),
            fontSize = 15.sp,
            maxLines = 1,
            style = MaterialTheme.typography.bodyLarge
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, bottom = 12.dp, top = 4.dp)
        ) {

            RatingBar(starsModifier = Modifier.size(20.dp), rating = movie.voteAverage / 2)

            Text(
                text = movie.voteAverage.toString().take(3),
                modifier = Modifier.padding(start = 6.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 14.sp,
                maxLines = 1
            )
        }
    }
}
