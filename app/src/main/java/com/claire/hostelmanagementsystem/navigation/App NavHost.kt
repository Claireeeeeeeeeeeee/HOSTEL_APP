package com.claire.hostelmanagementsystem.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.claire.hostelmanagementsystem.ui.theme.screen.Home.HomeScreen
import com.claire.hostelmanagementsystem.ui.theme.screen.Login.LoginScreen
import com.claire.hostelmanagementsystem.ui.theme.screen.Register.RegisterScreen
import com.claire.hostelmanagementsystem.ui.theme.screen.contactus.ContactUs
//import com.claire.hostelmanagementsystem.ui.theme.screen.contactus.Contactus
import com.claire.hostelmanagementsystem.ui.theme.screen.mpesa.Mpesa
import com.claire.hostelmanagementsystem.ui.theme.screen.payment.Payment
import com.claire.hostelmanagementsystem.ui.theme.screen.splashscreen.SplashScreen
import com.claire.hostelmanagementsystem.ui.theme.screen.viewdetails.UpdateDetail
import com.claire.hostelmanagementsystem.ui.theme.screen.viewdetails.ViewDetails
import com.example.firebaseauth.ui.theme.screen.cluster.ClusterRoom
import com.example.firebaseauth.ui.theme.screen.single.SingleRoom
import com.example.firebaseauth.ui.theme.screen.superior.SuperiorRoom
import com.example.firebaseauth.ui.theme.screen.twins.TwinsRoom
import com.google.android.play.core.integrity.client.R

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(),
               startDestination:String= ROUTE_SPLASH_SCREEN) {
    NavHost(
        navController = navController,
        modifier = Modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
           LoginScreen(navController)

        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)

        }
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_SINGLE) {
            SingleRoom(navController)
        }
        composable(ROUTE_TWINS) {
            TwinsRoom(navController)
        }
        composable(ROUTE_CONTACT_US){
            ContactUs(navController  )
        }

        composable(ROUTE_CLUSTER) {
            ClusterRoom(navController)
        }
        composable(ROUTE_PAYMENT) {
            Payment(navController)
        }
       composable(ROUTE_SUPERIOR) {
           SuperiorRoom(navController)
       }
        composable(ROUTE_SPLASH_SCREEN){
            SplashScreen(navController )
        }
        composable(ROUTE_MPESA){
            Mpesa(navController)
        }
        composable(ROUTE_VIEW_DETAILS){
            ViewDetails(navController)
        }
        composable(ROUTE_UPDATE_DETAIL+"$id"){passedData->
            UpdateDetail(navController,passedData.arguments?.getString("id")!! )
        }



    }
}


