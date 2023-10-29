package com.example.intents

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.intents.ui.theme.IntentsTheme

class SecondActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            IntentsTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Have a nice day! :)",
                        fontWeight = FontWeight.Bold
                    )
                    Button(
                        onClick = {
                            val implicitIntent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_EMAIL, arrayOf("test@gmail.com"))
                                putExtra(Intent.EXTRA_SUBJECT, "This is the subject")
                                putExtra(Intent.EXTRA_TEXT, "This is the text")
                            }
                            startActivity(implicitIntent)
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFF1B1B1B))
                    )
                    {
                        Text(text = "Send Email to Me")
                    }
                }
            }
        }
    }
}