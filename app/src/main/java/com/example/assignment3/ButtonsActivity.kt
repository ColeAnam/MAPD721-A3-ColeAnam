package com.example.assignment3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainButtons(navController: NavController) {
    Column(modifier = Modifier.padding(all = 9.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                navController.navigate("transition")
            })
        {
            Text("Transition Animation")
        }

        Button(
            onClick = {
                navController.navigate("scale")
            })
        {
            Text("Scale Animation")
        }

        Button(
            onClick = {
                navController.navigate("infinite")
            })
        {
            Text("Infinite Animation")
        }

        Button(
            onClick = {
                navController.navigate("enterExit")
            })
        {
            Text("Enter Exit Animation")
        }
    }
}