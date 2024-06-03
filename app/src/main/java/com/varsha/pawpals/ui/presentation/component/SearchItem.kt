package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.ui.theme.PawPalsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextFieldItem(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Row {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(label)
            }
        },
        visualTransformation = VisualTransformation.None,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        ),
        maxLines = 1,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color(0x4D000000),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )

            .clip(RoundedCornerShape(10.dp))
            .padding(0.5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldPreview() {
    var searchQuery by remember { mutableStateOf("") }
    PawPalsTheme {
        SearchTextFieldItem(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = "Search",
            keyboardType = KeyboardType.Text
        )
    }
}
