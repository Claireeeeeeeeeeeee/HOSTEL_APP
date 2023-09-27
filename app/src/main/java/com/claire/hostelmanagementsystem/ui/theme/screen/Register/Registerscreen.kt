package com.claire.hostelmanagementsystem.ui.theme.screen.Register

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.claire.hostelmanagementsystem.R
import com.claire.hostelmanagementsystem.data.AuthViewModel
import com.claire.hostelmanagementsystem.navigation.ROUTE_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    var email by remember{ mutableStateOf(TextFieldValue("")) }
    var pass by remember{ mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember{ mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current



    Column(modifier = Modifier.fillMaxSize().background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Register Here",
            color= Color.Blue,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Image(
                painter = painterResource(id = R.drawable.icon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .border(
                width = 5.dp,
                color = Color.Black,
                shape = CircleShape
            )
        )
        Row(
                verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
        ) {
            // Profile picture icon
            Image(
                imageVector = Icons.Default.MailOutline,
                contentDescription = null, // You can add a content description here
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))




            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text(text = "Enter Email", color = Color.White) },

                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Row(
                verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
        ) {
            // Profile picture icon
            Image(
                imageVector = Icons.Default.Lock,
                contentDescription = null, // You can add a content description here
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))



            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = pass, onValueChange = { pass = it },
                label = { Text(text = "Enter password", color = Color.White) },

                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Row(
                verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
        ) {
            // Profile picture icon
            Image(
                imageVector = Icons.Default.Lock,
                contentDescription = null, // You can add a content description here
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))



            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = confirmpass, onValueChange = { confirmpass = it },
                label = { Text(text = "Confirm password", color = Color.White) },

                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }


        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val myregister= AuthViewModel(navController,context)
            myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register")

        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Have an account ? Click to Login")

        }


    }



}
@Preview
@Composable
fun Registerpage() {
    RegisterScreen(rememberNavController())
}