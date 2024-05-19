package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterCommunity(modifier: Modifier = Modifier) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var selectedGlobal by remember { mutableStateOf(false) }
        var selectedCatCommunity by remember { mutableStateOf(false) }
        var selectedDogCommunity by remember { mutableStateOf(false) }
        var selectedDisease by remember { mutableStateOf(false) }

        FilterChip(
            selected = selectedGlobal,
            onClick = { selectedGlobal = !selectedGlobal },
            label = {
                Text(
                    text = "Global",
                    style = TextStyle(
                        color = if (selectedGlobal) Color.Black else Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            leadingIcon = {
                if (selectedGlobal) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Checklist",
                        modifier = Modifier
                            .size(FilterChipDefaults.IconSize)
                    )
                }
            },
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .height(40.dp)
                .background(color = if (selectedGlobal) Color(0xFFFBEDEC) else Color(0xFFD05440))
        )

        FilterChip(
            selected = selectedCatCommunity,
            onClick = { selectedCatCommunity = !selectedCatCommunity },
            label = {
                Text(
                    text = "Komunitas Kucing Oren",
                    style = TextStyle(
                        color = if (selectedCatCommunity) Color.Black else Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            leadingIcon = {
                if (selectedCatCommunity) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Checklist",
                        modifier = Modifier
                            .size(FilterChipDefaults.IconSize)
                    )
                }
            },
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .height(40.dp)
                .background(
                    color = if (selectedCatCommunity) Color(0xFFFBEDEC) else Color(
                        0xFFD05440
                    )
                )
        )

        FilterChip(
            selected = selectedDogCommunity,
            onClick = { selectedDogCommunity = !selectedDogCommunity },
            label = {
                Text(
                    text = "Komunitas Anjing",
                    style = TextStyle(
                        color = if (selectedDogCommunity) Color.Black else Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            leadingIcon = {
                if (selectedDogCommunity) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Checklist",
                        modifier = Modifier
                            .size(FilterChipDefaults.IconSize)
                    )
                }
            },
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .height(40.dp)
                .background(
                    color = if (selectedDogCommunity) Color(0xFFFBEDEC) else Color(
                        0xFFD05440
                    )
                )
        )

        FilterChip(
            selected = selectedDisease,
            onClick = { selectedDisease = !selectedDisease },
            label = {
                Text(
                    text = "Penyakit",
                    style = TextStyle(
                        color = if (selectedDisease) Color.Black else Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            leadingIcon = {
                if (selectedDisease) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Checklist",
                        modifier = Modifier
                            .size(FilterChipDefaults.IconSize)
                    )
                }
            },
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .height(40.dp)
                .background(color = if (selectedDisease) Color(0xFFFBEDEC) else Color(0xFFD05440))
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun FilterCommunityPreview() {
    FilterCommunity()
}