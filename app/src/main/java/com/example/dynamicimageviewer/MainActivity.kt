package com.example.dynamicimageviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dynamicimageviewer.ui.theme.DynamicImageViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DynamicImageViewerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageViewer(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageViewer(modifier: Modifier = Modifier) {
    // State to keep track of the currently displayed image and quote
    var currentImage by remember { mutableStateOf(R.drawable.image1) }
    var currentQuote by remember { mutableStateOf("Love is the most powerful force in the universe.") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Heading for the app
        Text(
            text = "Dynamic Image Viewer",
            style = TextStyle(
                color = Color(0xFF6200EA), // Cool color for the heading
                fontSize = 24.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Display the current quote
        Text(
            text = currentQuote,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Image Display with Crossfade for a smooth transition
        Crossfade(targetState = currentImage) { image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Displayed Image",
                modifier = Modifier
                    .size(300.dp)
                    .padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Button Row
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    currentImage = R.drawable.image1
                    currentQuote = "“Love is not something you find. Love is something that finds you.” – Loretta Young"
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF80AB)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).padding(8.dp)
            ) {
                Text(text = "Love")
            }

            Button(
                onClick = {
                    currentImage = R.drawable.image2
                    currentQuote = "“In every walk with nature one receives far more than he seeks.” – John Muir"
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03DAC5)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).padding(8.dp)
            ) {
                Text(text = "Nature")
            }

            Button(
                onClick = {
                    currentImage = R.drawable.image3
                    currentQuote = " ”The ocean stirs the heart, inspires the imagination and brings eternal joy to the soul.” – Robert Wyland."
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).padding(8.dp)
            ) {
                Text(text = "Sunsets")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageViewerPreview() {
    DynamicImageViewerTheme {
        ImageViewer()
    }
}
