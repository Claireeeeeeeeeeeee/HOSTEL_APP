package com.claire.hostelmanagementsystem.ui.theme.screen.mpesa

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Mpesa(navController:NavHostController) {
    val context= LocalContext.current

    Column {
        OutlinedButton(
            onClick = { val simToolKitLaunchIntent =
                context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let {context.startActivity(it) }
            },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "PAY")
        }
    }

}