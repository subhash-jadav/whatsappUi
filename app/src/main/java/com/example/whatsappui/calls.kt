package com.example.whatsappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.theme.customColorGreen
import com.example.whatsappui.ui.theme.darkGreen1

@Composable
fun CallsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkGreen1)
            .padding(top = 44.dp, start = 16.dp, end = 12.dp)
    ) {
        TopBarforCalls()
        Favouritescalls()
        CallList()
    }
}

@Composable
fun TopBarforCalls() {
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
                    text = "Calls", style = TextStyle(
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

@Composable
fun Favouritescalls() {
    Column(Modifier.padding(top = 12.dp)) {
        Text(
            text = "Favourites", style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light
            )
        )
        CallCardForAdd(callItems(R.drawable.favourite, "Favourites", R.drawable.call))
        Text(
            text = "Recent", style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            ),
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}

data class callItems(
    val Dp: Int,
    val name: String,
    val icon : Int
)

@Composable
fun CallCardForAdd(callItems: callItems) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = callItems.Dp), contentDescription = "fav",
                modifier = Modifier
                    .size(30.dp)
//                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = callItems.name, style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.width(200.dp))
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "add_icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun CallCard(callItems: callItems) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = callItems.Dp), contentDescription = "fav",
                modifier = Modifier
                    .size(45.dp)
//                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = callItems.name, style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.width(230.dp))
            Image(
               painter = painterResource(id = callItems.icon),
                contentDescription = "add_icon",
                modifier = Modifier.size(26.dp)
            )

        }
    }
}

@Composable
fun CallList() {
    val callItemsList = listOf(
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),
        callItems(R.drawable.ghost_rounded, "Ghost" , R.drawable.call),

    )
    LazyColumn(Modifier.padding(top = 8.dp) , contentPadding = PaddingValues(bottom = 100.dp)) {
        items(callItemsList) { items ->
            CallCard(items)
        }
    }
}