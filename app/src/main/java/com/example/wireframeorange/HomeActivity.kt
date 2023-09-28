package com.example.wireframeorange

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wireframeorange.ui.theme.WireframeOrangeTheme

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wireframeorange.ui.theme.SurfaceHigh

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.wireframeorange.ui.theme.PrimaryContainer


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WireframeOrangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(0) }
    var items = mutableListOf(1)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp
            )
            .background(com.example.wireframeorange.ui.theme.Surface)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.card),
                contentDescription = stringResource(id = R.string.orange_content_description),
                modifier = Modifier.clickable { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally)  {
                items(items.toMutableList()) { item ->
                    var unread by remember { mutableStateOf(false) }
                    val dismissState = rememberDismissState(
                        confirmStateChange = {
                            if (it == DismissValue.DismissedToEnd) {
                                items.remove(item)
                                unread = !unread
                            }
                            it != DismissValue.DismissedToEnd
                        }
                    )

                    SwipeToDismiss(
                        state = dismissState,
                        directions = setOf(DismissDirection.EndToStart),
                        background = {
                            val color = when (dismissState.dismissDirection) {
                                DismissDirection.StartToEnd -> Color.Green
                                DismissDirection.EndToStart -> PrimaryContainer
                                null -> Color.Transparent
                            }
                            val direction = dismissState.dismissDirection

                            if (direction == DismissDirection.EndToStart) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(color)
                                        .padding(8.dp)
                                ) {
                                    Column(modifier = Modifier.align(Alignment.CenterEnd)) {
                                        Image(
                                            painter = painterResource(id = R.drawable.close),
                                            contentDescription = null,
                                        )
                                    }
                                }
                            }
                        },
                        dismissContent = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.alertcard),
                                    contentDescription = stringResource(id = R.string.orange_content_description),
                                    modifier = Modifier.clickable { }
                                )
                            }
                        }
                    )
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.backorange),
                contentDescription = stringResource(id = R.string.orange_content_description),
            )
            TabRow(containerColor = SurfaceHigh, selectedTabIndex = state, indicator = @Composable () {}) {
                Tab(
                    selectedContentColor = SurfaceHigh,
                    unselectedContentColor = Color.Black,
                    selected = false,
                    onClick = {  },
                    text = { Text(text = "Pomodoro", maxLines = 2, overflow = TextOverflow.Ellipsis) }
                )
                Tab(
                    selectedContentColor = SurfaceHigh,
                    unselectedContentColor = Color.Black,
                    selected = false,
                    onClick = {  },
                    text = { Text(text = "Sueño", maxLines = 2, overflow = TextOverflow.Ellipsis) }
                )
                Tab(
                    selectedContentColor = SurfaceHigh,
                    unselectedContentColor = Color.Black,
                    selected = false,
                    onClick = {  },
                    text = { Text(text = "Ajustes", maxLines = 2, overflow = TextOverflow.Ellipsis) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    WireframeOrangeTheme {
        Greeting2("Android")
    }
}