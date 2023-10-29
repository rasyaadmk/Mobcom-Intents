package com.example.intents

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.intents.ui.theme.IntentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentsTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                        Intent(applicationContext, SecondActivity::class.java). also {
                            startActivity(it)
                        }
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFF1B1B1B))) 
                    {
                        Text(text = "Click Me")
                    }
                    Button(onClick = {
                        Intent(Intent.ACTION_MAIN).also {
                            it.`package` = "com.google.android.youtube"
                            try {
                                startActivity(it)
                            } catch (e: ActivityNotFoundException) {
                                e.printStackTrace()
                            }
                        }
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFFFF0000)))
                    {
                        Text(text = "Open YouTube")
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    IntentsTheme {
//
//    }
//}