package com.claire.hostelmanagementsystem.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.claire.hostelmanagementsystem.models.User
import com.claire.hostelmanagementsystem.navigation.ROUTE_HOME
import com.claire.hostelmanagementsystem.navigation.ROUTE_LOGIN
import com.claire.hostelmanagementsystem.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var navController:NavHostController,var context: Context) {

    var mAuth: FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait....")
    }

    fun signup(email: String, pass: String, confpass: String) {
        progress.show()
        if (email.isEmpty() || pass.isBlank() || confpass.isBlank()) {
            progress.dismiss()
            Toast.makeText(context, "Email and password cannot be the same", Toast.LENGTH_LONG).show()
            return
        } else if (pass != confpass) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
            return
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
               progress.dismiss()
                if (it.isSuccessful) {
                    val userData = User(email, pass, mAuth.currentUser!!.uid)
                    val regRef = FirebaseDatabase.getInstance().getReference()
                        .child("Users/" + mAuth.currentUser!!.uid)
                    regRef.setValue(userData).addOnCompleteListener {

                        if (it.isSuccessful) {
                            Toast.makeText(context, "account created successfully", Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)
                        } else {
                            Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }

    fun login(email: String, pass: String) {
        progress.show()
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Successfully logged in", Toast.LENGTH_LONG).show()
//                    navController.navigate((ROUTE_REGISTER))To take you to a different page
                navController.navigate(ROUTE_HOME)
            } else {
                Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }
    }

    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

    fun isloggedin(): Boolean {
        return mAuth.currentUser != null

    }
}