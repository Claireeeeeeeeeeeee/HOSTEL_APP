package com.claire.hostelmanagementsystem.ui.theme.screen.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.claire.hostelmanagementsystem.R
import com.claire.hostelmanagementsystem.navigation.ROUTE_CLUSTER
import com.claire.hostelmanagementsystem.navigation.ROUTE_HOME
import com.claire.hostelmanagementsystem.navigation.ROUTE_SINGLE
import com.claire.hostelmanagementsystem.navigation.ROUTE_SUPERIOR
import com.claire.hostelmanagementsystem.navigation.ROUTE_TWINS

@Composable
fun HomeScreen(navConroller:NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current


        Text(
            text = "SMART HOME HOSTEL",
            color = Color.Cyan,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Button(
                onClick = {
                    navConroller.navigate(ROUTE_SINGLE)
                },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.singleroom),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(125.dp)
                            .clip(RectangleShape) // You can use CircleShape or any other shape you want
                            .background(MaterialTheme.colorScheme.background) // Background color of the button
                    )
                    Text(text = "SINGLE ROOMS", color = Color.White)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Button(
                onClick = {
                    navConroller.navigate(ROUTE_TWINS)
                },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.twinroom),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(125.dp)
                            .clip(RectangleShape) // You can use CircleShape or any other shape you want
                            .background(MaterialTheme.colorScheme.background) // Background color of the button
                    )
                    Text(text = "TWIN ROOMS", color = Color.White)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Button(
                onClick = {
                    navConroller.navigate(ROUTE_CLUSTER)
                },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.clusterroom),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(125.dp)
                            .clip(RectangleShape) // You can use CircleShape or any other shape you want
                            .background(MaterialTheme.colorScheme.background) // Background color of the button
                    )
                    Text(text = "CLUSTER ROOMS", color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(0.dp))
        Row {
            Button(
                onClick = {
                    navConroller.navigate(ROUTE_SUPERIOR)
                },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.superiorroom),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(125.dp)
                            .clip(RectangleShape) // You can use CircleShape or any other shape you want
                            .background(MaterialTheme.colorScheme.background) // Background color of the button
                    )
                    Text(text = "SUPERIOR ROOMS", color = Color.White)
                }
            }
        }
    }
}
        @Preview
        @Composable
        fun Homepage() {
            HomeScreen(rememberNavController())
        }


