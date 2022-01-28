package com.example.mymovyapp.screen.detail

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mymovyapp.model.getMovies
import com.example.mymovyapp.widgets.MovieRow

@ExperimentalAnimationApi
@Composable
fun DetailScreen(navController: NavController,
                 movieId: String?){
    val newMovieList= getMovies().filter {
        it ->it.id==movieId
    }

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Magenta,
            elevation = 5.dp,
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(corner = CornerSize(12.dp))
                )
                .padding(top = 5.dp, start = 5.dp, end = 5.dp)
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "image arrowBack",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })

           Spacer(modifier = Modifier.width(50.dp))
                Text(text = "Movies")
            }

        }

    }) {
        Surface(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                MovieRow(movie = newMovieList.first())
                Text(text = newMovieList[0].title,
                    style = MaterialTheme.typography.h4)
                Spacer(modifier = Modifier.padding(8.dp))
                Divider()
                LazyRow{
                    items(newMovieList[0].images){
                        image ->
                        Card(modifier = Modifier
                            .padding(12.dp)
                            .size(240.dp),
                        elevation = 5.dp) {
           Image(painter = rememberImagePainter(data=image ) ,
    contentDescription = "images")
                        }
                    }
                }
            }
        }

    }
}

