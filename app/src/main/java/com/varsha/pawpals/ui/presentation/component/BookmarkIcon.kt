package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BookmarkIcon(modifier: Modifier = Modifier) {
    var isBookmarked by remember { mutableStateOf(false) }

    val icon: ImageVector = if (isBookmarked) {
        Icons.Filled.Bookmark
    } else {
        Icons.Outlined.BookmarkBorder
    }

    val tintColor: Color = Color.Red

    Image(
        imageVector = icon,
        contentDescription = "Bookmark",
        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(tintColor),
        modifier = modifier
            .clickable { isBookmarked = !isBookmarked }
            .size(30.dp)
    )
}

@Preview
@Composable
fun PreviewBookmarkIcon() {
    BookmarkIcon(modifier = Modifier)
}
