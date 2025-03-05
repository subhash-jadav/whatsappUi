package com.example.whatsappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.theme.brightGreen
import com.example.whatsappui.ui.theme.customColorGreen
import com.example.whatsappui.ui.theme.darkGreen1
import com.example.whatsappui.ui.theme.grey
import com.example.whatsappui.ui.theme.grey1

@Composable
fun UpdatesScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkGreen1)
            .padding(top = 44.dp, start = 16.dp, end = 12.dp)
    ) {
        TopBarforUpdates()
        MySatusSection()
        ChipsForUpdates()
    }
}
@Composable
fun ChipsForUpdates() {
    var selectedChipIndex by remember {
        mutableStateOf(0) // 0 for Seen, 1 for Unseen
    }

    // Define the two chips: "Seen" and "Unseen"
    val chipItemList = listOf("Seen", "Unseen")

    Column(modifier = Modifier.fillMaxSize()) {
        // Display chips
        LazyRow {
            items(chipItemList.size) { index ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
                        .clickable { selectedChipIndex = index }
                        .clip(RoundedCornerShape(14.dp))
                        .background(if (selectedChipIndex == index) Color(0xFF12CF20) else Color.Gray) // Use your brightGreen and grey here
                        .padding(12.dp)
                ) {
                    Text(
                        text = chipItemList[index],
                        color = Color.White
                    )
                }
            }
        }

        // Display content based on the selected chip
        when (selectedChipIndex) {
            0 -> StatusListSeen() // Show the StatusList when "Seen" is selected
            1 -> StatusListUnSeen() // Show the StatusListUnSeen when "Unseen" is selected
        }
    }
}

@Composable
fun TopBarforUpdates() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(darkGreen1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Updates", style = TextStyle(
                        fontSize = 26.sp,
                        color = customColorGreen,
//                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                )

                Spacer(Modifier.width(100.dp))
                Image(painter = painterResource(R.drawable.qr_logo), contentDescription = "qr_logo")
                Image(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "camera_icon",
                    modifier = Modifier.size(20.dp)
                )
                Image(
                    painter = painterResource(R.drawable.dots_icon),
                    contentDescription = "dots_icon"
                )


            }
        }
    }
}

data class StatusItem(
    val Dp: Int,
    val name: String,
    val msg: String,

    )

@Composable
fun StatusCardUnSeen(statusItem: StatusItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = statusItem.Dp), contentDescription = "dp_1",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(2.dp, customColorGreen, CircleShape)
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(
                    text = statusItem.name, style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp
                    )
                )
                Text(
                    text = statusItem.msg, style = TextStyle(
                        color = grey1,
                        fontSize = 16.sp
                    )
                )

            }
        }
    }
}

@Composable
fun StatusCard(statusItem: StatusItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = statusItem.Dp), contentDescription = "dp_1",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(
                    text = statusItem.name, style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp
                    )
                )
                Text(
                    text = statusItem.msg, style = TextStyle(
                        color = grey1,
                        fontSize = 16.sp
                    )
                )

            }
        }
    }
}


@Composable
fun MySatusSection() {
    Column(Modifier.padding(top = 8.dp, bottom = 6.dp)) {
        Text(
            "Status", style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp
            )
        )
        StatusCard(StatusItem(R.drawable.dp1, "Jon snow", "Tap to add Status Upadte"))
    }
}

@Composable
fun StatusListSeen() {
    val statusItemList = listOf(
        StatusItem(R.drawable.khalisi_rounded, "Dany", "Just Now"),
        StatusItem(R.drawable.tormund_rounded, "Tormond", "2 Hour Ago")
    )
    LazyColumn(Modifier.padding(top = 4.dp)) {
        items(statusItemList) { items ->
            StatusCard(items)
        }
    }
}
@Composable
fun StatusListUnSeen() {
    val statusItemList = listOf(
        StatusItem(R.drawable.ghost_rounded, "Ghost", "2 Hour ago"),
        StatusItem(R.drawable.sansa_rounded, "Ghost", "3 Hour ago"),
        StatusItem(R.drawable.arya_rounded, "Ghost", "Just seen"),
    )
    LazyColumn(Modifier.padding(top = 4.dp)) {
        items(statusItemList) { items ->
            StatusCardUnSeen(items)
        }
    }
}