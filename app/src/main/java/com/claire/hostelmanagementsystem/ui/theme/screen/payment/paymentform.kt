package com.claire.hostelmanagementsystem.ui.theme.screen.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.claire.hostelmanagementsystem.data.productviewmodel
import com.claire.hostelmanagementsystem.navigation.ROUTE_MPESA
import com.claire.hostelmanagementsystem.navigation.ROUTE_PAYMENT
import com.claire.hostelmanagementsystem.navigation.ROUTE_VIEW_DETAILS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Payment(navController:NavHostController) {
    var context= LocalContext.current
    Column ( modifier= Modifier.background(Color.White),)
{
    Text(
        text = "PAYMENT",
        color = Color(0xFF3B56EE),
        modifier = Modifier.padding(16.dp),
//        fontFamily = FontFamily.Serif,
        fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
        fontSize = 40.sp
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Form
    var name by remember { mutableStateOf("") }
    var typeofroom by remember { mutableStateOf("") }
    var userid by remember { mutableStateOf("") }
    var checkindate by remember { mutableStateOf("") }
    var checkoutdate by remember { mutableStateOf("") }

    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Name") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    TextField(
        value = typeofroom,
        onValueChange = { typeofroom = it },
        label = { Text("ID Number") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    TextField(
        value = userid ,
        onValueChange = { userid = it },
        label = { Text("Type of room") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    TextField(
        value = checkindate,
        onValueChange = { checkindate = it },
        label = { Text("Check in date") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    TextField(
        value = checkoutdate,
        onValueChange = { checkoutdate = it },
        label = { Text("Check out date") },
        modifier = Modifier
              .fillMaxWidth()

    )
    Spacer(modifier = Modifier.height(16.dp))
    Button(
        onClick = {
            var productRepository = productviewmodel(navController,context)
            productRepository.saveProduct(name.trim(),typeofroom.trim(),
                userid.trim(),checkindate.trim(),checkoutdate.trim())



            navController.navigate(ROUTE_VIEW_DETAILS)

        },
        colors = ButtonDefaults.buttonColors(Color.Black),
    )
    {
        Text(
            text = " Check Out",
            color = Color.White
        )


    }
}




}

@Preview
@Composable
fun PaymentPreview() {
    Payment(rememberNavController())

}


