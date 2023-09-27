package com.claire.hostelmanagementsystem.ui.theme.screen.viewdetails

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.claire.hostelmanagementsystem.data.productviewmodel
import com.claire.hostelmanagementsystem.models.payment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateDetail(navController: NavHostController,id:String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var userid by remember { mutableStateOf("") }
        var checkindate by remember { mutableStateOf("") }
        var checkoutdate by remember { mutableStateOf("") }
        var typeofroom by remember { mutableStateOf("") }




        var currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var product = snapshot.getValue(payment::class.java)
                name = product!!.name
                typeofroom = product!!.typeofroom
                userid = product!!.userid
                checkindate = product!!.checkindate
                checkoutdate = product!!.checkoutdate


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Text(
            text = "Add product",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

//        var name by remember { mutableStateOf(TextFieldValue(name)) }
//        var typeofroom by remember { mutableStateOf(TextFieldValue(typeofroom)) }
//        var userid by remember { mutableStateOf(TextFieldValue(userid)) }
//        var checkindate by remember { mutableStateOf(TextFieldValue(checkindate)) }
//        var checkoutdate by remember { mutableStateOf(TextFieldValue(checkoutdate)) }



        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = " name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = typeofroom,
            onValueChange = { typeofroom = it },
            label = { Text(text = "Type of room *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = userid,
            onValueChange = { userid = it },
            label = { Text(text = "user id *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = checkindate,
            onValueChange = { checkindate= it },
            label = { Text(text = "Check in date*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = checkoutdate,
            onValueChange = { checkoutdate = it },
            label = { Text(text = "Check out date *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )





        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var productRepository = productviewmodel(navController, context)
            productRepository.updateProduct(name.trim(),typeofroom.trim(),
                userid.trim(),checkindate.trim(),checkoutdate.trim(),id)


        }) {
            Text(text = "Update")
        }

    }
}
