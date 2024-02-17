package br.com.vtvinicius.tabrowteste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.tabrowteste.ui.theme.TabRowTesteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabRowTesteTheme {

                val titles = listOf("Tortas", "Doces", "Salgados", "Cafés", "Bebidas")
                var tabIndex by remember { mutableStateOf(0) }

                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {

                    },
                    content = { paddingValues ->


                        Column(
                            modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {

                            Row {

                                Column {


                                    Box(modifier = Modifier
                                        .width(150.dp)
                                        .height(100.dp)
                                        .background(darkGreen)) {
                                    }

                                    titles.forEachIndexed { index, title ->
                                        Box(
                                            modifier = Modifier
                                                .width(150.dp)
                                                .height(100.dp)
                                                .background(if (index % 2 == 0) lightGreen else darkGreen)
                                        ) {
                                            Tab(
                                                text = { Text(title) },
                                                icon = {
                                                    Icon(
                                                        imageVector = Icons.Default.AccountCircle,
                                                        contentDescription = null,
                                                        modifier = Modifier.size(24.dp)
                                                    )
                                                },
                                                modifier = Modifier
                                                    .width(150.dp)
                                                    .height(100.dp),
                                                selected = tabIndex == index,
                                                onClick = { tabIndex = index },
                                                selectedContentColor = Color.White,
                                                unselectedContentColor = Color.Black
                                            )
                                        }
                                    }
                                    Box(modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp)
                                        .background(darkGreen)) {
                                    }

                                }

                                Column {
                                    Crossfade(
                                        targetState = tabIndex, label = "",
                                        animationSpec = tween(500)
                                    ) { tabIndex ->
                                        when (tabIndex) {
                                            0 -> {
                                                Greeting("Android 1 ")
                                            }

                                            1 -> {
                                                Greeting2("Android 2 ")
                                            }

                                            2 -> {
                                                Greeting3("Android 3 ")
                                            }

                                            3 -> {
                                                Greeting("Android 3 ")
                                            }

                                            4 -> {
                                                Greeting2("Android 3 ")
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Scaffold(content = {
        it
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello $name!")
            Spacer(modifier = Modifier.size(16.dp))
            Card(Modifier.size(100.dp)) {
                Text(text = "This is a card")
            }
            Spacer(modifier = Modifier.size(16.dp))

            Card(Modifier.size(100.dp)) {
                Text(text = "This is a card in tab 1")
            }
        }

    }
    )
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Scaffold(content = {
        it
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello $name!")
            Spacer(modifier = Modifier.size(16.dp))
            Card(Modifier.size(100.dp)) {
                Text(text = "This is a card")
            }
            Spacer(modifier = Modifier.size(16.dp))

            Card(Modifier.size(400.dp)) {
                Text(text = "This is a card in tab 2")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Card(Modifier.size(200.dp)) {
                Text(text = "This is a card in tab 2")
            }
        }

    }
    )
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Scaffold(content = {
        it
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello $name!")
            Spacer(modifier = Modifier.size(30.dp))
            Card(Modifier.size(200.dp)) {
                Text(text = "This is a card")
            }
            Spacer(modifier = Modifier.size(30.dp))

            Card(Modifier.size(300.dp)) {
                Text(text = "This is a card in tab 3")
            }

            Spacer(modifier = Modifier.size(30.dp))

            Card(Modifier.size(400.dp)) {
                Text(text = "This is a card in tab 3")
            }
        }

    }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TabRowTesteTheme {
        Greeting("Android")
    }
}


val lightGreen = Color(0xFFCFC2B2)
val darkGreen = Color(0xFF808978)