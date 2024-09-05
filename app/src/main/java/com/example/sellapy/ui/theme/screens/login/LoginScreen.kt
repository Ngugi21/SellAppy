package com.example.sellapy.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sellapy.R
import com.example.sellapy.data.AuthViewModel
import com.example.sellapy.navigation.ROUT_DASHBOARD
import com.example.sellapy.ui.theme.Brown
import com.example.sellapy.ui.theme.Yellow


@Composable
fun LoginScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()
        .paint(painterResource(id = R.drawable.img_4), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img) ,
            contentDescription = "product",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Welcome Back!",
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            color = Brown
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Already have an account? Please enter your credentials",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black
        )
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = email,
            onValueChange = { email=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="", tint = Brown ) },
            label = { Text(text = "Email Address")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = password,
            onValueChange = { password=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="", tint = Brown ) },
            label = { Text(text = "Enter your password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)
        Row {
            Button(
                onClick = {
                    authViewModel.login(email, password)
                          },
                colors = ButtonDefaults.buttonColors(Yellow)
            )
            {
                Text(text = "Login as User")


            }
Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {authViewModel.adminlogin(email,password) },
                colors = ButtonDefaults.buttonColors(Yellow)
            )
            {
                Text(text = "Login as Admin")


            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Already have an account? Login",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier.clickable { navController.navigate(ROUT_DASHBOARD) }
        )
    }

    }






@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}

