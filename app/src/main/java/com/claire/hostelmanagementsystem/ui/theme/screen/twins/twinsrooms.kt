package com.example.firebaseauth.ui.theme.screen.twins

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.claire.hostelmanagementsystem.R
import com.claire.hostelmanagementsystem.navigation.ROUTE_MPESA
import com.claire.hostelmanagementsystem.navigation.ROUTE_PAYMENT
import com.example.firebaseauth.ui.theme.screen.single.SingleRoom

@Composable
fun TwinsRoom(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Spacer(modifier = Modifier.height(19.dp))
        Spacer(modifier = Modifier.height(19.dp))

        Text(
            text = "TWIN ROOMS",
            color = Color(0xFF673AB7),
            fontFamily = FontFamily.SansSerif,
//            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(19.dp))
        Spacer(modifier = Modifier.height(19.dp))
        Spacer(modifier = Modifier.height(19.dp))

        Image(
            painter = painterResource(id = R.drawable.twinroom),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(RectangleShape)
                .border(
                    width = 5.dp,
                    color = Color.Black,
                    shape = RectangleShape
                )
        )
        Spacer(modifier = Modifier.height(19.dp))
        Spacer(modifier = Modifier.height(19.dp))

        Text(
            text ="This is one of the shared rooms at Safe Home Hostel.It is very spacious, enough for two people." +
                    "It contains facilities that will enable the people sharing to be comfortable and feel at home."
            ,
            color = Color(0xFF131313),
            fontFamily = FontFamily.SansSerif,
//            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navController.navigate(ROUTE_PAYMENT)

            },
            colors = ButtonDefaults.buttonColors(Color.Black),
        )
        {
            Text(
                text = "BOOK",
                color = Color.White
            )


        }

    }

}






@Preview
@Composable
fun TwinRoomPreview() {
    TwinsRoom(rememberNavController())
}



