package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    backgroundGreeting("Android")
                }
            }
        }
    }
}


@Composable
fun Greeting(num: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Number $num", modifier = modifier
    )
}

@Composable
fun buttonPlus() {

}


@Composable
fun buttonMinus() {


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var num = remember { mutableStateOf(0) }
    MyComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                if (num.value >0) {
                    Image(
                        painterResource(R.drawable.happy),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(100.dp)
                    )
                }


               else if (num.value == 0) {
                    Image(
                        painterResource(R.drawable.dissapain),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(100.dp)
                    )
                }

                else {
                    Image(
                        painterResource(R.drawable.sad),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(100.dp)
                    )
                }

            }
            Row {
                Greeting(num.value)

            }
            Row {
                Button(
                    onClick = {
                        num.value++

                    }
                ) {
                    Text("+")

                }
                Button(onClick = {
                    num.value--
                }) {
                    Text("-")
                }

            }
            Row {
                Button(onClick = {
                    num.value = 0

                }) {
                    Icon(
                        Icons.Filled.Refresh,
                        contentDescription = "Refresh",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)

                    )
                    Text("reset", modifier = Modifier.padding(10.dp, 0.dp))

                }


            }

        }

    }
}