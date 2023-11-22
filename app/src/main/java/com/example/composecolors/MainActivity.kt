package com.example.composecolors

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                title = { Text("App title (surface/onSurface)") },
                navigationIcon = {Icon(Icons.Rounded.ArrowBack, null)})
                     },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) { Icon(Icons.Rounded.Search, null) }
            },
            bottomBar = { BottomAppBar {
                Text("Bottom bar (surface/onSurface) ")
                Icon(Icons.Rounded.Build, null)
            }}
        ) {
            //vars
            var sliderPosition by remember { mutableStateOf(0.75f) }
            //
            Column(modifier = Modifier.padding(vertical = 60.dp, horizontal = 20.dp)) {
                Row{
                    Text("Simple text\n(onBackground)", Modifier.align(alignment = Alignment.CenterVertically))
                    Button(onClick = {}, modifier = Modifier.padding(horizontal = 10.dp)) { Text("Button") }
                    FilledTonalButton(onClick = {}) { Text("FilledTonal") }
                }
                Row{
                    OutlinedButton(onClick = {}) { Text("Outlined") }
                    ElevatedButton(onClick = {}, modifier = Modifier.padding(horizontal = 10.dp)) { Text("Elevated\nsurface") }
                    TextButton(onClick = {}) { Text("Text button") }
                }
                Row{
                    TextField(value = "TextField", onValueChange = {}, Modifier.width(150.dp))
                    OutlinedTextField(value = "OutlinedTextField", onValueChange = {}, Modifier.width(200.dp).padding(start = 5.dp))
                }
                Row{
                    Text("Checkbox", Modifier.align(alignment = Alignment.CenterVertically))
                    Checkbox(checked = false, onCheckedChange = {})
                    Checkbox(checked = true, onCheckedChange = {})
                    Text("RadioButton", Modifier.align(alignment = Alignment.CenterVertically))
                    RadioButton(selected = false, onClick = {})
                    RadioButton(selected = true, onClick = {})
                }
                Row{
                    Text("Switch", Modifier.align(alignment = Alignment.CenterVertically))
                    Switch(checked = false, onCheckedChange = {})
                    Switch(checked = true, onCheckedChange = {}, modifier = Modifier.padding(horizontal = 10.dp))
                    ExtendedFloatingActionButton(
                        icon = { Icon(Icons.Rounded.AccountBox, null) },
                        text = { Text("Extended FAB") },
                        onClick = {}
                    )
                }
                Row {
                    Text("Chips:", Modifier.align(alignment = Alignment.CenterVertically))
                    AssistChip(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        onClick = {},
                        label = { Text("Assist") },
                        leadingIcon = { Icon(Icons.Filled.Settings, null) }
                    )
                    var selected by remember { mutableStateOf(true) }
                    FilterChip(
                        onClick = { selected = !selected },
                        label = { Text("Filter") },
                        selected = selected,
                        leadingIcon =
                            if (selected) { { Icon(imageVector = Icons.Filled.Done, null) } }
                            else { null }
                        )
                }
                Row{
                    InputChip(
                        onClick = {},
                        label = { Text("Input") },
                        selected = true,
                        avatar = { Icon(Icons.Filled.Person, null) },
                        trailingIcon = { Icon(Icons.Default.Close, null) },
                    )
                    SuggestionChip(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        onClick = {},
                        label = { Text("Suggestion") }
                    )
                    CircularProgressIndicator(progress = sliderPosition)
                }
                Row{
                    Text("Slider\nprimary/surfaceV", Modifier.align(alignment = Alignment.CenterVertically))
                    Slider(value = sliderPosition, onValueChange = { sliderPosition = it})
                }
                Row{
                    Text("Progress\nprimary/surfaceV", Modifier.align(alignment = Alignment.CenterVertically))
                    LinearProgressIndicator(progress = sliderPosition, Modifier.align(alignment = Alignment.CenterVertically))
                }
                Row{
                    ElevatedCard {
                        Row(Modifier.padding(15.dp)){
                            Text("Elevated\nsurface/onSurface", Modifier.align(alignment = Alignment.CenterVertically), fontSize = 15.sp)
                        }
                    }
                    OutlinedCard(Modifier.padding(start = 10.dp)) {
                        Row(Modifier.padding(15.dp)){
                            Text("Outlined\nsurface/onSurface", Modifier.align(alignment = Alignment.CenterVertically), fontSize = 15.sp)
                        }
                    }
                }
                Card(Modifier.padding(15.dp)) {
                    Row(Modifier.padding(15.dp)){
                        Text("Card\nsurfaceVariant/onSurfaceVariant", Modifier.align(alignment = Alignment.CenterVertically))
                        Icon(Icons.Rounded.Build, null)
                    }
                }
            }
        }
    }
}