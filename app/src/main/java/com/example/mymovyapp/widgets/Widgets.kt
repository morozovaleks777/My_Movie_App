package com.example.mymovyapp.widgets

import android.view.View
import android.widget.ScrollView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mymovyapp.model.Movie
import com.example.mymovyapp.model.getMovies

@ExperimentalAnimationApi
@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0],
             onItemClick:(String)->Unit={} ) {
    var expanded by remember{
        mutableStateOf(false)
    }
    Card(
        modifier =
        Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable { onItemClick(movie.id) },
        //  color = Color.Gray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = (+10).dp,
        contentColor = Color.Green,
        backgroundColor = Color.Gray
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Surface(modifier = Modifier
                .padding(6.dp)
                .size(100.dp),
                shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                elevation = 4.dp) {
//                Icon(imageVector = Icons.Default.AccountBox,
//                    contentDescription ="movie image " ,
//                    modifier = Modifier.background(color = Color.LightGray ))

                Image(painter = rememberImagePainter(data = movie.images[0],
                builder ={
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }) ,
                    contentDescription ="movie poster" )
            }
            Column() {
                Text(text = movie.title,
               modifier= Modifier.padding(3.dp),
                style = MaterialTheme.typography.h5)
                Text(text ="realised : ${movie.year}",
                    modifier= Modifier.padding(3.dp),
                    style = MaterialTheme.typography.caption)
                Text(text = "director : ${movie.director}",
                        modifier= Modifier.padding(3.dp),
                    style = MaterialTheme.typography.caption)

                AnimatedVisibility(visible =expanded ) {
    Column {


        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(
                color = Color.Green,
                fontSize = 13.sp)){
                append("Plot : ")
            }

            withStyle(style = SpanStyle(
                color = Color.DarkGray,
                fontSize = 13.sp)){
                append("${movie.plot} ")
            }
        },modifier = Modifier.padding(5.dp))
        Divider()
        Text(text = "Genre : ${movie.genre}",
            style = MaterialTheme.typography.caption)
        Text(text = "Actors : ${movie.actors}",
                style = MaterialTheme.typography.caption)
        Text(text = "Rating : ${movie.rating}",
            style = MaterialTheme.typography.caption)

}
                }


                Icon(imageVector = if(expanded){
                    Icons.Filled.KeyboardArrowUp
                }
                    else Icons.Filled.KeyboardArrowDown ,
                    contentDescription ="down arrow" ,
                modifier = Modifier.clickable {
                    expanded=!expanded

                })
            }
        }
    }
}