@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.composecolors.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.Divider
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FullScreen() {
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("App title (surface/onSurface)") },
            navigationIcon = { Icon(Icons.Rounded.ArrowBack, null) })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) { Icon(Icons.Rounded.Search, null) }
        },
        bottomBar = { BottomAppBar {
            Text("Bottom bar (surface/onSurface) ")
            Icon(Icons.Rounded.Build, null)
             }
        }
    ) {
        Column(modifier = Modifier
            .padding(vertical = 60.dp, horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxHeight(1f)
        ) {
            ShowButtons()
            ShowFields()
            ShowChecks()
            ShowSliderAndIndicators()
            ShowCards()
            ShowExtFAB()
        }
    }
}

@Composable
private fun ShowButtons() {
    Text("Simple text (onBackground)\nButtons:")
    Row{
        Button(onClick = {}) { Text("Button") }
        Text("Text: back:", Modifier.align(alignment = Alignment.CenterVertically))
    }
    Row{
        FilledTonalButton(onClick = {}) { Text("FilledTonal") }
        Text("Text: back:", Modifier.align(alignment = Alignment.CenterVertically))
    }
    Row{
        OutlinedButton(onClick = {}) { Text("Outlined") }
        Text("Text: back:", Modifier.align(alignment = Alignment.CenterVertically))
    }
    Row{
        ElevatedButton(onClick = {}) { Text("Elevated") }
        Text("Text: back: surface", Modifier.align(alignment = Alignment.CenterVertically))
    }
    Row{
        TextButton(onClick = {}) { Text("Text button") }
        Text("Text: back:", Modifier.align(alignment = Alignment.CenterVertically))
    }
    Divider()
}

@Composable
private fun ShowFields() {
    Text("Fields:")
    Row{
        TextField(value = "TextField", onValueChange = {}, modifier = Modifier.width(180.dp))
        Text("Text: back:", Modifier.align(alignment = Alignment.CenterVertically))
    }
    Row{
        OutlinedTextField(value = "OutlinedTextField", onValueChange = {}, modifier = Modifier.width(180.dp))
        Text("Text: back:", Modifier.align(alignment = Alignment.CenterVertically))
    }
    Divider()
}

@Composable
private fun ShowChecks() {
    Text("Checkbox:")
    Checkbox(checked = false, onCheckedChange = {})
    Checkbox(checked = true, onCheckedChange = {})
    Text("RadioButton:")
    RadioButton(selected = false, onClick = {})
    RadioButton(selected = true, onClick = {})
    Text("Switch:")
    Switch(checked = false, onCheckedChange = {})
    Switch(checked = true, onCheckedChange = {}, modifier = Modifier.padding(horizontal = 10.dp))
    Divider()
}

@Composable fun ShowChips() {
    Text("Chips:")
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
        if (selected) {
            { Icon(imageVector = Icons.Filled.Done, null) }
        } else {
            null
        }
    )
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
    Divider()
}

@Composable
private fun ShowSliderAndIndicators() {
    var sliderPosition by remember { mutableStateOf(0.75f) }
    Text("Slider:")
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it})
    Text("LinearProgressIndicator:")
    LinearProgressIndicator(progress = sliderPosition)
    Text("CircularProgressIndicator:")
    CircularProgressIndicator(progress = sliderPosition)
    Divider()
}

@Composable
private fun ShowCards() {
    ElevatedCard(Modifier.padding(5.dp)) {
        Row(Modifier.padding(15.dp)){
            Text("Elevated\nsurface/onSurface", Modifier.align(alignment = Alignment.CenterVertically))
        }
    }
    OutlinedCard(Modifier.padding(5.dp)) {
        Row(Modifier.padding(15.dp)){
            Text("Outlined\nsurface/onSurface", Modifier.align(alignment = Alignment.CenterVertically))
        }
    }
    Card(Modifier.padding(5.dp)) {
        Row(Modifier.padding(15.dp)){
            Text("Card\nsurfaceVariant/onSurfaceVariant", Modifier.align(alignment = Alignment.CenterVertically))
            Icon(Icons.Rounded.Build, null)
        }
    }
    Divider()
}

@Composable
private fun ShowExtFAB() {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Rounded.AccountBox, null) },
        text = { Text("Extended FAB") },
        onClick = {}
    )
    Text("\n\n\nThe end...")
}