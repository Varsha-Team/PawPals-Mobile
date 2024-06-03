import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDate
import java.time.YearMonth

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarRowComponent() {
    val currentYear = LocalDate.now().year
    val currentMonth = LocalDate.now().month.value
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var selectedMonth by remember { mutableStateOf(currentMonth) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Month Selector
//        Row(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.fillMaxWidth(),
//        ) {
//            Button(
//                onClick = {
//                selectedMonth = if (selectedMonth > 1) selectedMonth - 1 else 12
//                selectedDate = LocalDate.of(currentYear, selectedMonth, 1) },
//                colors = ButtonDefaults.buttonColors(Color(0xFFD84315))
//            ) {
//                Text(text = "Prev")
//            }
//
//            Text(text = "${selectedDate.month.name} $currentYear", fontSize = 18.sp, fontWeight = FontWeight.Bold)
//
//            Button(onClick = {
//                selectedMonth = if (selectedMonth < 12) selectedMonth + 1 else 1
//                selectedDate = LocalDate.of(currentYear, selectedMonth, 1) },
//                colors = ButtonDefaults.buttonColors(Color(0xFFD84315))
//            ) {
//                Text(text = "Next")
//            }
//        }

        // Days of the Month
        val daysInMonth = YearMonth.of(currentYear, selectedMonth).lengthOfMonth()
        val dates = (1..daysInMonth).map { LocalDate.of(currentYear, selectedMonth, it) }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            dates.forEach { date ->
                val isSelected = date == selectedDate
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .background(if (isSelected) Color(0xFFD84315) else Color.Transparent)
                        .clickable { selectedDate = date }
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = date.month.name.take(3),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color.White else Color.Black
                    )
                    Text(
                        text = date.dayOfMonth.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color.White else Color.Black
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CalendarRowComponentPreview() {
    CalendarRowComponent()
}


