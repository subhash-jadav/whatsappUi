package com.example.whatsappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.theme.brightGreen
import com.example.whatsappui.ui.theme.darkGreen1
import com.example.whatsappui.ui.theme.grey
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import com.example.whatsappui.ui.theme.customColorGreen
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold


@Composable
fun ChatMainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkGreen1)
            .padding(top = 44.dp, start = 16.dp, end = 12.dp)
    ) {
        TopBar()
        TopSearch()
        ArchivedRow()
        chipsForChatScreen(listOf("All", "Unread", "Gruop", "+"))

    }


}

@Composable
fun TopBar() {
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
                    "WhatsApp", color = customColorGreen, style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                )
                Spacer(Modifier.width(100.dp))
                Image(painter = painterResource(R.drawable.qr_logo), contentDescription = "qr_logo")
                Image(
                    painter = painterResource(R.drawable.camera_icon),
                    contentDescription = "camera_icon",
                    modifier = Modifier.size(26.dp)
                )
                Image(
                    painter = painterResource(R.drawable.dots_icon),
                    contentDescription = "dots_icon"
                )


            }
        }
    }
}

@Composable
fun TopSearch() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(38.dp)
                .background(color = Color(0xED5E5B5B), shape = RoundedCornerShape(size = 20.dp))
                .padding(start = 12.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Search",
                style = TextStyle(
                    fontSize = 19.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0x99ADACAC),
                ),
                modifier = Modifier
                    .width(256.dp)
                    .height(22.dp)
                    .fillMaxWidth(),
            )
        }
    }
}

@Composable
fun chipsForChatScreen(itemList: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(itemList.size) { index ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
                    .clickable { selectedChipIndex = index }
                    .clip(RoundedCornerShape(14.dp))
                    .background(if (selectedChipIndex == index) brightGreen else grey)
//                    .shadow(10.dp, RoundedCornerShape(20.dp))
                    .padding(12.dp)


            ) {
                // You can add some content inside the Box, like a Text
                Text(text = itemList[index], color = Color.White) // Example content
            }
        }
    }
    when (selectedChipIndex) {
        0 -> AllMainChat()
        1 -> UnreadMainChat()
        2 -> GroupChats()
    }
}

@Composable
fun ArchivedRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(R.drawable.archived), contentDescription = "archived_icon",
            modifier = Modifier.size(18.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text = "Archived", style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}

data class chatItem(
    val Dp: Int,
    val name: String,
    val msg: String,
    val msgStatus: Int
)

@Composable
fun ChatCard(chatItem: chatItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = chatItem.Dp), contentDescription = "dp_1",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(
                    text = chatItem.name, style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp
                    )
                )
                Row(

                ) {
                    Image(
                        painter = painterResource(id = chatItem.msgStatus),
                        contentDescription = "doubletick",
                        modifier = Modifier
                            .size(20.dp)
                            .padding(top = 4.dp)
                    )
                    Text(
                        text = " " + chatItem.msg, style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )

                }

            }
        }
    }
}

@Composable
fun MainChat() {
    val contectList = listOf(
        chatItem(
            R.drawable.sword_rounded,
            "Night's Watch Warriors ",
            "Stay on duty (Lord Commander) ",
            R.drawable.unread1
        ),
        chatItem(R.drawable.dp1, "Me (Jon Snow)", "Meeting at 10 AM", R.drawable.double_check),
        chatItem(R.drawable.ned_rounded, "Ned Stark", "Where is sword ? ", R.drawable.unread1),
        chatItem(
            R.drawable.ghost_rounded,
            "Ghost",
            "Need to meet you",
            R.drawable.double_tick_sent
        ),
        chatItem(R.drawable.drag_rounded, "Dragon", "see you ", R.drawable.double_tick_sent),
        chatItem(
            R.drawable.khalisi_rounded,
            "Dany",
            "Meet me at Dragon pit ",
            R.drawable.double_tick_sent
        ),
        chatItem(R.drawable.robb_rounded, "Robb", "Meet me ", R.drawable.unread1),
        chatItem(R.drawable.arya_rounded, "Arya", "I Lost my needle ", R.drawable.unread1),
        chatItem(
            R.drawable.sansa_rounded,
            "Sansa",
            "Lord Tyrion is OTW ",
            R.drawable.double_tick_sent
        ),
        chatItem(
            R.drawable.tormund_rounded,
            "Tormund",
            "How's Egrit ? 😙 ",
            R.drawable.double_tick_sent
        ),

        )
    LazyColumn(contentPadding = PaddingValues(bottom = 100.dp)) {
        items(contectList) { chat ->
            ChatCard(chatItem = chat)
        }
    }
}

@Composable
fun AllMainChat(modifier: Modifier = Modifier) {
    MainChat()
}

@Composable
fun UnreadMainChat(modifier: Modifier = Modifier) {
    val contectList = listOf(
        chatItem(R.drawable.robb_rounded, "Robb", "Meet me ", R.drawable.unread1),
        chatItem(R.drawable.ned_rounded, "Ned Stark", "Where is sword ? ", R.drawable.unread1),
        chatItem(R.drawable.arya_rounded, "Arya", "I Lost my needle ", R.drawable.unread1),


        )
    val listState = rememberLazyListState()
    LazyColumn(contentPadding = PaddingValues(bottom = 100.dp), state = listState) {
        items(contectList) { chat ->
            ChatCard(chatItem = chat)
        }
    }
}

@Composable
fun GroupChats() {
    val contectList = listOf(
        chatItem(
            R.drawable.sword_rounded,
            "Night's Watch Warriors ",
            "Stay on duty (Lord Commander) ",
            R.drawable.unread1
        ),

        )
    LazyColumn(contentPadding = PaddingValues(bottom = 100.dp)) {
        items(contectList) { chat ->
            ChatCard(chatItem = chat)
        }
    }
}
