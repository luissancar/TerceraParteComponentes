package com.example.tercerapartecomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tercerapartecomponentes.ui.theme.TerceraParteComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerceraParteComponentesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                  //  modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Gatos( )
                }
            }
        }
    }

}


@Composable
fun CardGatos(imagen: Int, text1: String, texto2: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { }
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(

                painter = painterResource(id = imagen),
                contentDescription = "Dos gatos",
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text1,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Text(texto2, style = MaterialTheme.typography.bodyMedium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box() {
                        Row {

                            TextButton(onClick = { /*TODO*/ }) {
                                Text("Gatos")
                            }
                            TextButton(onClick = { /*TODO*/ }) {
                                Text("Razas")
                            }
                        }
                    }
                    Box() {
                        Row {

                            IconButton(onClick = { /*TODO*/ }) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Favorito"
                                    )

                                }

                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Share,
                                        contentDescription = "Favorito"
                                    )

                                }

                            }
                        }
                    }
                }

            }
        }

    }
}


@Composable
fun MyCard() {


    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Cyan),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(10.dp), //MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
            contentColor = Color.Red

        ),
        border = BorderStroke(5.dp, Color.Blue)
    )
    {
        Column(Modifier.padding(20.dp)) {
            Text(text = "Texo 1")
            Text(text = "Texo 1")
        }
    }
}

@Composable
fun Gatos(/*name: String, modifier: Modifier = Modifier*/) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        CardGatos(R.drawable.gatos, "Dos gatos", "Mirando por la ventana")
        CardGatos(R.drawable.gatoesfinge, "Gato esfinge", "Mirandote")
        CardGatos(R.drawable.gatosolo, "Gato solo", "en Sombra")
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(badge = { Text(text = "1") }, modifier = Modifier.padding(16.dp)) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox2() {

    var badgeCount by remember { mutableStateOf(5) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BadgedBox(badge = { BadgeContent(badgeCount) }) {
            IconButton(onClick = { /* Handle button click */ }) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = badgeCount.toString(),
            onValueChange = {
                badgeCount = it.toIntOrNull() ?: 0
            }
        )
    }
}


@Composable
fun BadgeContent(count: Int) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.Red, shape = CircleShape)
            .padding(4.dp)
    ) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onPrimary),
            modifier = Modifier.padding(4.dp)
        )
    }
}


@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), color = Color.Red
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember {
        mutableStateOf("..")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    val guitarras = listOf("Fender", "Gibson", "Yamaha")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            guitarras.forEach { guitarra ->
                DropdownMenuItem(
                    text = {  Text(text = guitarra) },
                    onClick = {
                        expanded = false
                        selectedText=guitarra

                    })


            }
        }

    }
}

@Composable
private fun Greeting(s: String) {
    MyDropDownMenu()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TerceraParteComponentesTheme {
        Greeting("Android")
    }
}