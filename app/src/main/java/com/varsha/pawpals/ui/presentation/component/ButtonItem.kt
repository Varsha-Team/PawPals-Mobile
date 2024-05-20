package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.navigation.Screen

@Composable
fun ButtonItem1(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 2.dp,
                color = Color(0xFFC85440),
                shape = RoundedCornerShape(50)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC85440),
            //backgroundColor = Color(0xFFE57373),
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Add",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun ButtonItem2(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 2.dp,
                color = Color(0xFFC85440),
                shape = RoundedCornerShape(50)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            //backgroundColor = Color(0xFFE57373),
            contentColor = Color(0xFFC85440)
        ),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Add",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

//@Composable
//fun ButtonItem3(
//    text: String,
//    icon: ImageVector,
//    onClick: () -> Unit,
//    ) {
//    Button(
//        onClick = onClick,
//        modifier = Modifier
//            .padding(8.dp)
//            .height(48.dp)
//            .clip(RoundedCornerShape(50))
//            .border(
//                width = 2.dp,
//                color = Color(0xFFC85440),
//                shape = RoundedCornerShape(50)
//            ),
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.White,
//            //backgroundColor = Color(0xFFE57373),
//            contentColor = Color(0xFFC85440)
//        ),
//        contentPadding = PaddingValues(horizontal = 24.dp)
//    ) {
//        Icon(
//            imageVector = icon,
//            contentDescription = "Add",
//            modifier = Modifier.size(24.dp)
//        )
//        Spacer(modifier = Modifier.width(8.dp))
//        Text(
//            text = text,
//            style = TextStyle(
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold
//            )
//        )
//    }
//}

@Preview()
@Composable
fun ButtonItemPreview1() {
   // val navController = rememberNavController()
    ButtonItem1(
        text = "Pets", icon = Icons.Default.Add, onClick = {},
    )
}

@Preview()
@Composable
fun ButtonItemPreview2() {
   // val navController = rememberNavController()
    ButtonItem2(
        text = "Pets", icon = Icons.Default.Add, onClick = {}
    )
}

//@Preview()
//@Composable
//fun ButtonItemPreview3() {
//    val navController = rememberNavController()
//    ButtonItem3(
//        text = "Pets", icon = Icons.Default.Add, onClick = {  }
//    )
//}
