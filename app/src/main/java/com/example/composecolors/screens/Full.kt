@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.composecolors.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
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
            .padding(vertical = 65.dp, horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxHeight(1f)
        ) {
            Text("Simple text (onBackground)")
            ShowButtons()
            ShowFields()
            ShowChecks()
            ShowChips()
            ShowSliderAndIndicators()
            ShowCards()
            ShowExtFAB()
        }
    }
}

@Composable
private fun ShowButtons() {
    Divider(Modifier.padding(vertical = 8.dp))
    Text("Buttons:")
    Row{
        Button(onClick = {}) { Text("Button") }
        Text("Text: onPrimary back: primary", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Row{
        FilledTonalButton(onClick = {}) { Text("FilledTonal") }
        Text("Text: onSecondaryContainer\nback: secondaryContainer", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Row{
        OutlinedButton(onClick = {}) { Text("Outlined") }
        Text("Text: primary back: background", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Row{
        ElevatedButton(onClick = {}) { Text("Elevated") }
        Text("Text: primary back: surface", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Row{
        TextButton(onClick = {}) { Text("Text button") }
        Text("Text: primary back: background", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Divider(Modifier.padding(vertical = 8.dp))
}

@Composable
private fun ShowFields() {
    Text("Fields:")
    Row{
        TextField(value = "TextField", onValueChange = {}, modifier = Modifier.width(165.dp))
        Text("Text: onSurface\nback: surfaceVariant\nline: onSurfaceVariant", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Row(Modifier.padding(top = 15.dp)) {
        OutlinedTextField(value = "OutlinedTextField", onValueChange = {}, modifier = Modifier.width(165.dp))
        Text("Text: onSurface\nback: background", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Divider(Modifier.padding(vertical = 8.dp))
}

@Composable
private fun ShowChecks() {
    var checkbox by remember { mutableStateOf(false) }
    var radiobtn by remember { mutableStateOf(false) }
    var switch by remember { mutableStateOf(false) }
    Text("Checkbox:")
    Row{
        Checkbox(checked = checkbox, onCheckedChange = { checkbox = !checkbox})
        Text(text = if (checkbox) "On: onPrimary / primary" else "Off: onSurfaceVariant", modifier = Modifier.align(alignment = Alignment.CenterVertically))
    }
    Row{
        Checkbox(checked = !checkbox, onCheckedChange = { checkbox = !checkbox})
        Text(text = if (!checkbox) "On: onPrimary / primary" else "Off: onSurfaceVariant", modifier = Modifier.align(alignment = Alignment.CenterVertically))
    }
    Divider(Modifier.padding(vertical = 8.dp))
    Text("RadioButton:")
    Row{
        RadioButton(selected = radiobtn, onClick = { radiobtn = !radiobtn })
        Text(text = if (radiobtn) "On: primary" else "Off: onSurfaceVariant", modifier = Modifier.align(alignment = Alignment.CenterVertically))
    }
    Row{
        RadioButton(selected = !radiobtn, onClick = { radiobtn = !radiobtn })
        Text(text = if (!radiobtn) "On: primary" else "Off: onSurfaceVariant", modifier = Modifier.align(alignment = Alignment.CenterVertically))
    }
    Divider(Modifier.padding(vertical = 8.dp))
    Text("Switch:")
    Row{
        Switch(checked = switch, onCheckedChange = { switch = !switch })
        Text(text = if (switch) "1 thumb: onPrimary track: primary" else "0 thumb: outline track: surfaceVariant", modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Row{
        Switch(checked = !switch, onCheckedChange = { switch = !switch })
        Text(text = if (!switch) "1 thumb: onPrimary track: primary" else "0 thumb: outline track: surfaceVariant", modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Divider(Modifier.padding(vertical = 8.dp))
}

@Composable fun ShowChips() {
    var selected by remember { mutableStateOf(true) }
    var logined by remember { mutableStateOf(true) }
    Text("Chips:")
    Row{
        Box(modifier = Modifier.width(140.dp)) {
            AssistChip(onClick = {}, label = { Text("Assist") }, leadingIcon = { Icon(Icons.Filled.Settings, null) })
        }
        Text("Text: onSurface\nback: background", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Row(modifier = Modifier.padding(top = 5.dp)){
        Box(modifier = Modifier.width(140.dp)) {
            SuggestionChip(onClick = {}, label = { Text("Suggestion") })
        }
        Text("Text: onSurfaceVariant\nback: background", Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp))
    }
    Row(modifier = Modifier.padding(top = 5.dp)){
        Box(modifier = Modifier.width(140.dp)) {
            FilterChip(
                onClick = { selected = !selected }, selected = selected,
                label = { if (selected) { Text("Filter On") } else { Text("Filter Off") } } ,
                leadingIcon = if (selected) { { Icon(imageVector = Icons.Filled.Done, null) } } else { null }
            )
        }
        Text(modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp),
            text = if (selected) "T: onSecondaryContainer\nback: secondaryContainer" else "T: onSurfaceVariant\nback: background"
        )
    }
    Row(modifier = Modifier.padding(top = 5.dp)){
        Box(modifier = Modifier.width(140.dp)) {
            FilterChip(
                onClick = { selected = !selected }, selected = !selected,
                label = { if (!selected) { Text("Filter On") } else { Text("Filter Off") } } ,
                leadingIcon = if (!selected) { { Icon(imageVector = Icons.Filled.Done, null) } } else { null }
            )
        }
        Text(modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp),
            text = if (!selected) "T: onSecondaryContainer\nback: secondaryContainer" else "T: onSurfaceVariant\nback: background"
        )
    }
    Row(modifier = Modifier.padding(top = 5.dp)){
        Box(modifier = Modifier.width(140.dp)) {
            InputChip(
                onClick = { logined = !logined }, selected = logined,
                label = { if (logined) { Text("Input On") } else { Text("Input Off") } } ,
                avatar = { Icon(Icons.Filled.Person, null) },
                trailingIcon = { if (logined) { Icon(Icons.Default.Close,null) } else { null } }
            )

        }
        Text(modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp),
            text = if (logined) "T: onSecondaryContainer\nback: secondaryContainer" else "T: onSurfaceVariant\nback: background"
        )
    }
    Row(modifier = Modifier.padding(top = 5.dp)){
        Box(modifier = Modifier.width(140.dp)) {
            InputChip(
                onClick = { logined = !logined }, selected = !logined,
                label = { if (!logined) { Text("Input On") } else { Text("Input Off") } } ,
                avatar = { Icon(Icons.Filled.Person, null) },
                trailingIcon = { if (!logined) { Icon(Icons.Default.Close,null) } else { null } }
            )
        }
        Text(modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(start = 8.dp),
            text = if (!logined) "T: onSecondaryContainer\nback: secondaryContainer" else "T: onSurfaceVariant\nback: background"
        )
    }
    Divider(Modifier.padding(vertical = 8.dp))
}

@Composable
private fun ShowSliderAndIndicators() {
    var sliderPosition by remember { mutableStateOf(0.75f) }
    Text("Slider:")
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it})
    Text("LinearProgressIndicator:")
    LinearProgressIndicator(progress = sliderPosition)
    Row(Modifier.padding(top = 15.dp)){
        Text("CircularProgressIndicator:", modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(end = 20.dp))
        CircularProgressIndicator(progress = sliderPosition)
    }
    Text("progress: primary back: surfaceVariant")
    Divider(Modifier.padding(vertical = 8.dp))
}

@Composable
private fun ShowCards() {
    Card(Modifier.padding(5.dp)) {
        Row(Modifier.padding(15.dp)){
            Text("Card\ntext: onSurfaceVariant\nback: surfaceVariant", Modifier.align(alignment = Alignment.CenterVertically))
            Icon(Icons.Rounded.Build, null)
        }
    }
    ElevatedCard(Modifier.padding(5.dp)) {
        Row(Modifier.padding(15.dp)){
            Text("ElevatedCard\ntext: onSurface\nback: surface", Modifier.align(alignment = Alignment.CenterVertically))
            Icon(Icons.Rounded.Call, null)
        }
    }
    OutlinedCard(Modifier.padding(5.dp)) {
        Row(Modifier.padding(15.dp)){
            Text("OutlinedCard\ntext: onSurface\nback: surface", Modifier.align(alignment = Alignment.CenterVertically))
            Icon(Icons.Rounded.Email, null)
        }
    }

    Divider(Modifier.padding(vertical = 8.dp))
}

@Composable
private fun ShowExtFAB() {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Rounded.AccountBox, null) },
        text = { Text("Extended FAB\ntext: onPrimaryContainer\nback: primaryContainer") },
        onClick = {}
    )
    Text("\n\n\nThe end...")
}