package com.example.composecolors

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composecolors.ui.theme.ComposeColorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowMainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShowMainScreen() {
    ComposeColorsTheme {
        Scaffold(
            topBar = { TopAppBar(
                title = { Text("Application title") },
                navigationIcon = {Icon(Icons.Rounded.ArrowBack, null)})
                     },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) { Icon(Icons.Rounded.Search, null) }
            }
        ) {
            Column(modifier = Modifier.padding(vertical = 60.dp, horizontal = 20.dp)) {
                Text("Text")
                Row{
                    Button(onClick = {}){ Text("Button") }
                    OutlinedButton(onClick = {}) {Text("OutlinedButton") }
                }
                Row{
                    TextField(value = "TextField", onValueChange = {}, Modifier.width(150.dp))
                    OutlinedTextField(value = "OutlinedTextField", onValueChange = {}, Modifier.width(200.dp))
                }
                Row{
                    Text("Checkbox", Modifier.align(alignment = Alignment.CenterVertically))
                    Checkbox(checked = false, onCheckedChange = {})
                    Checkbox(checked = true, onCheckedChange = {})
                }
                Row{
                    Text("RadioButton", Modifier.align(alignment = Alignment.CenterVertically))
                    RadioButton(selected = false, onClick = {})
                    RadioButton(selected = true, onClick = {})
                }
                Row{
                    Text("Switch", Modifier.align(alignment = Alignment.CenterVertically))
                    Switch(checked = false, onCheckedChange = {})
                    Switch(checked = true, onCheckedChange = {})
                }
                ExtendedFloatingActionButton(
                    icon = { Icon(Icons.Rounded.AccountBox, null) },
                    text = { Text("ExtendedFloatingActionButton") },
                    onClick = {}
                )
                Card(Modifier.padding(15.dp)) {
                    Row(Modifier.padding(15.dp)){
                        Text("Text on card", Modifier.align(alignment = Alignment.CenterVertically))
                        Button(onClick = {}, Modifier.padding(horizontal = 10.dp)){ Text("Button on card") }
                        Icon(Icons.Rounded.Build, null)
                    }
                }
            }

        }
    }
}