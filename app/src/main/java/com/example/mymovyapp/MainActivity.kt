package com.example.mymovyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mymovyapp.navigation.MovieNavigation
import com.example.mymovyapp.ui.theme.MyMovyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          MyApp {
             // MainContent()
MovieNavigation()
          }
        }
    }
}


@Composable
fun MyApp(
    content:@Composable ()->Unit
){
    MyMovyAppTheme {
       content()


    }
}

//@Composable
//fun MainContent(
//    movieList:List<String> = listOf(
//        "Avatar",
//        "300",
//        "Harry Potter",
//         "Life",
//        "",
//        "",
//        "",
//        "",
//        "",
//        "",
//        "",
//    )
//){
//   Surface(
//       modifier = Modifier
//           .padding(5.dp)
//           .fillMaxWidth()
//           .fillMaxHeight(),
//       color = Color.LightGray,
//       shape = RoundedCornerShape(corner = CornerSize(12.dp))
//   ) {
//       Column() {
//           Text(text = "hello movy app")
//
//           LazyColumn {
//               items(items = movieList){
//                  // Text(text = it)
//                   MovieRow(movie = it){
//                       Log.d("Test", "MainContent:onclickItem :click..$it ")
//                   }
//               }
//           }
//       }
//
//    }
//
//}

@Composable
fun MovieRow(movie: String,onItemClick:(String)->Unit={} ) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onItemClick(movie) },
     //  color = Color.Gray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = (+10).dp,
        contentColor =Color.Green,
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
Icon(imageVector = Icons.Default.AccountBox,
    contentDescription ="movie image " ,
    modifier = Modifier.background(color = Color.LightGray ))
}
            Text(text = movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

        MyApp {
          //  MainContent()
            MovieNavigation()
        }
    }
