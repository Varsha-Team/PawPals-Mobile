package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
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
fun FilterArticle(modifier: Modifier = Modifier) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        var selectedAll by remember { mutableStateOf(true) }
        var selectedHealth by remember { mutableStateOf(false) }
        var selectedBehaviour by remember { mutableStateOf(false) }
        var selectedNutrition by remember { mutableStateOf(false) }
        var selectedCare by remember { mutableStateOf(false) }

        FilterChip(
            selected = selectedAll,
            onClick = { selectedAll = !selectedAll },
            label = {
                Text(
                    text = "All",
                    style = TextStyle(
                        color = if (selectedAll) Color.White else Color(0xFFCE5628),
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            //            leadingIcon = {
//                if (selectedHealth) {
//                    Icon(
//                        imageVector = Icons.Default.Check,
//                        contentDescription = "Checklist",
//                        modifier = Modifier
//                            .size(FilterChipDefaults.IconSize)
//                    )
//                }
//            },
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
               // .background(color = if (selectedAll) Color(0xFFCE5628) else Color.White)
        )


        FilterChip(
            selected = selectedHealth,
            onClick = { selectedHealth = !selectedHealth },
            label = {
                Text(
                    text = "Health",
                    style = TextStyle(
                        color = if (selectedHealth) Color.White else Color(0xFFCE5628),
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            //            leadingIcon = {
//                if (selectedHealth) {
//                    Icon(
//                        imageVector = Icons.Default.Check,
//                        contentDescription = "Checklist",
//                        modifier = Modifier
//                            .size(FilterChipDefaults.IconSize)
//                    )
//                }
//            },
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
            // .background(color = if (selectedHealth) Color(0xFFCE5628) else Color.White)
        )

        FilterChip(
            selected = selectedBehaviour,
            onClick = { selectedBehaviour = !selectedBehaviour },
            label = {
                Text(
                    text = "Behaviour & Training",
                    style = TextStyle(
                        color = if (selectedBehaviour) Color.White else Color(0xFFCE5628),
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            //            leadingIcon = {
//                if (selectedHealth) {
//                    Icon(
//                        imageVector = Icons.Default.Check,
//                        contentDescription = "Checklist",
//                        modifier = Modifier
//                            .size(FilterChipDefaults.IconSize)
//                    )
//                }
//            },
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
            // .background(color = if (selectedBehaviour) Color(0xFFCE5628) else Color.White)
        )

        FilterChip(
            selected = selectedNutrition,
            onClick = { selectedNutrition = !selectedNutrition },
            label = {
                Text(
                    text = "Nutrition",
                    style = TextStyle(
                        color = if (selectedNutrition) Color.White else Color(0xFFCE5628),
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            //            leadingIcon = {
//                if (selectedHealth) {
//                    Icon(
//                        imageVector = Icons.Default.Check,
//                        contentDescription = "Checklist",
//                        modifier = Modifier
//                            .size(FilterChipDefaults.IconSize)
//                    )
//                }
//            },
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

            // .background(color = if (selectedNutrition) Color(0xFFCE5628) else Color.White)
        )

        FilterChip(
            selected = selectedCare,
            onClick = { selectedCare = !selectedCare },
            label = {
                Text(
                    text = "Care",
                    style = TextStyle(
                        color = if (selectedCare) Color.White else Color(0xFFCE5628),
                        fontWeight = FontWeight.SemiBold
                    )
                )
            },
            //            leadingIcon = {
//                if (selectedHealth) {
//                    Icon(
//                        imageVector = Icons.Default.Check,
//                        contentDescription = "Checklist",
//                        modifier = Modifier
//                            .size(FilterChipDefaults.IconSize)
//                    )
//                }
//            },
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
            // .background(color = if (selectedCare) Color(0xFFCE5628) else Color.White)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun FilterArticlePreview() {
    FilterArticle()
}