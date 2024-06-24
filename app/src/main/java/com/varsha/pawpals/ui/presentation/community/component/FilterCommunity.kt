package com.varsha.pawpals.ui.presentation.community.component

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilterCommunity(selectedCategory: String, onCategorySelected: (String) -> Unit, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        val categories = listOf("All", "Kucing", "Anjing", "Health", "Care")

        categories.forEach { category ->
            val selected = selectedCategory == category

            FilterChip(
                selected = selected,
                onClick = { onCategorySelected(category) },
                label = {
                    Text(
                        text = category,
                        style = TextStyle(
                            color = if (selected) Color.White else Color(0xFFCE5628),
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFCE5628),
                ),
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCE5628),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .height(40.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun FilterCommunityPreview() {
    FilterCommunity(selectedCategory = "All", onCategorySelected = {})
}
