package com.example.wireframeorange

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wireframeorange.ui.theme.WireframeOrangeTheme

class PomodoroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WireframeOrangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting4("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Pomodoro",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {  context.startActivity(Intent(context, HomeActivity::class.java)) }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = { innerPadding: PaddingValues ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(
                        start = 31.dp,
                        end = 31.dp,
                        bottom = 17.dp
                    )
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.points),
                    contentDescription = null
                )
                Text(
                    text = "00:10",
                    style = TextStyle(
                        fontSize = 96.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(700),
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.pause),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        context.startActivity(Intent(context, PomodoroStopActivity::class.java))
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    WireframeOrangeTheme {
        Greeting4("Android")
    }
}