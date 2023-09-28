package com.example.wireframeorange

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wireframeorange.ui.theme.WireframeOrangeTheme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.wireframeorange.ui.theme.Primary


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WireframeOrangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var username by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }

    var password by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(
            start = 31.dp,
            end = 31.dp
        ).background(com.example.wireframeorange.ui.theme.Surface),
    ) {
        Image(
            painter = painterResource(id = R.drawable.orange),
            contentDescription = stringResource(id = R.string.orange_content_description)
        )
        Spacer(modifier = Modifier.height(60.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            singleLine = true,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary,
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            singleLine = true,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary
            )
        )

        Spacer(modifier = Modifier.height(46.dp))

        Button(
            modifier = Modifier.defaultMinSize(
                minWidth = 262.dp
            ),
            onClick = {
                context.startActivity(Intent(context, HomeActivity::class.java))
            },
            colors = ButtonDefaults.buttonColors(containerColor = Primary)
        ) { Text("Ingresar") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WireframeOrangeTheme {
        Greeting("Android")
    }
}