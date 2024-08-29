package com.example.sellapy.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import com.example.sellapy.navigation.ROUT_LOGIN
import com.example.sellapy.ui.theme.Brown
import com.example.sellapy.ui.theme.Yellow


@Composable
fun SignupScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.img_4), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
        painter = painterResource(id = R.drawable.img) ,
        contentDescription = "product",
        modifier = Modifier.size(200.dp)
    )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "SellApy",
            fontSize = 70.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Black
        )
Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Do not have an account? Create one",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black
        )



        var name by remember { mutableStateOf("")}
        var email by remember { mutableStateOf("")}
        var password by remember { mutableStateOf("")}
        var confpassword by remember { mutableStateOf("")}

        Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(value = name,
                onValueChange = { name=it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
//to be at start use leadingIcon
                trailingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription ="", tint = Brown )},
                label = { Text(text = "Fullname")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = email,
            onValueChange = { email=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="", tint = Brown )},
            label = { Text(text = "Email Address")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = password,
            onValueChange = { password=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="", tint = Brown )},
            label = { Text(text = "Enter your password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = confpassword,
            onValueChange = { confpassword=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="", tint = Brown )},
            label = { Text(text = "Confirm your password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

//Create an account button
        Button(
            onClick = {
                authViewModel.signup(name, email, password,confpassword)
            },
            colors = ButtonDefaults.buttonColors(Yellow)
        )
        {
            Text(text = "Register")


        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Already have an account? Login",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier.clickable { navController.navigate(ROUT_LOGIN) }
        )



    }

    }





@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    SignupScreen(rememberNavController())
}
