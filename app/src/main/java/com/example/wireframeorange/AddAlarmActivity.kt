package com.example.wireframeorange

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wireframeorange.ui.theme.WireframeOrangeTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.example.wireframeorange.ui.theme.Primary


class AddAlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WireframeOrangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {

    var hour by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("7:00 PM"))
    }
    var date by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("08/17/2023"))
    }
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("Reunion con abogado"))
    }

    val checkedState = remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Añadir alarma",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {  context.startActivity(Intent(context, HomeActivity::class.java))}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content =  { innerPadding: PaddingValues ->
            Column(
                modifier = Modifier.padding(innerPadding).padding(
                    start = 31.dp,
                    end = 31.dp,
                    bottom = 17.dp
                ).fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column{
                    OutlinedTextField(
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Primary,
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        value = hour,
                        onValueChange = { hour = it },
                        label = { Text("Hora") },
                        trailingIcon = {
                            Icon(imageVector = Icons.Filled.DateRange, contentDescription = null)
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Primary,
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        value = date,
                        onValueChange = { date = it },
                        label = { Text("fecha") },
                        trailingIcon = {
                            Icon(imageVector = Icons.Filled.DateRange, contentDescription = null)
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Primary,
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Descipción") },
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.toggleable(
                            value = checkedState.value,
                            onValueChange = { checkedState.value = it }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            colors = CheckboxDefaults.colors(
                                checkedColor = Primary,
                                checkmarkColor = Primary
                            ),
                            checked = checkedState.value,
                            onCheckedChange = { checkedState.value = it }
                        )
                        Text(text = "Repetible")
                    }
                }
                Button(
                    modifier = Modifier.defaultMinSize(
                        minWidth = 262.dp
                    ),
                    onClick = {
                        context.startActivity(Intent(context, HomeActivity::class.java))
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Primary)
                ) { Text("Confirmar") }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    WireframeOrangeTheme {
        Greeting3("Android")
    }
}