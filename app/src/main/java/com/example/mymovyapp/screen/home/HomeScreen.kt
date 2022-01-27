package com.example.mymovyapp.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mymovyapp.MovieRow
import com.example.mymovyapp.navigation.MovieScreens


@Composable
fun HomeScreen(navController: NavController){

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
            Text(text = "Movies")
        }
    }) {
        MainContent(navController=navController)
    }
}

@Composable
fun MainContent(navController: NavController,
    movieList:List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Life",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
    )
){
    Surface(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color.LightGray,
        shape = RoundedCornerShape(corner = CornerSize(12.dp))
    ) {
        Column() {
            Text(text = "hello movy app")

            LazyColumn {
                items(items = movieList){
                    //Text(text = it)
                    MovieRow(movie = it){movie ->
                       navController.navigate(route = MovieScreens.DetailScreen.name+"/$movie")
                       // Log.d("Test", "MainContent:onclickItem :click..$it ")
                    }
                }
            }
        }

    }

}