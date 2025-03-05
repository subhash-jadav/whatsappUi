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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.theme.customColorGreen
import com.example.whatsappui.ui.theme.darkGreen1

@Composable
fun CommunitiesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkGreen1)
            .padding(top = 44.dp, start = 16.dp, end = 12.dp)
    ) {
        TopBarforComm()
        AddComm()
        CommList()
    }
}

@Composable
fun TopBarforComm() {
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
                    text = "Communties", style = TextStyle(
                        fontSize = 26.sp,
                        color = customColorGreen,
//                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                )

                Spacer(Modifier.width(100.dp))
                Image(painter = painterResource(R.drawable.qr_logo), contentDescription = "qr_logo")
                Image(
                    painter = painterResource(R.drawable.dots_icon),
                    contentDescription = "dots_icon"
                )


            }
        }
    }
}

data class commItem(
    val Dp: Int,
    val name: String
)

@Composable
fun CommCardForAdd(commItem: commItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = commItem.Dp), contentDescription = "dp_1",
                modifier = Modifier
                    .size(45.dp)
//                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = commItem.name, style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.width(100.dp))
            Icon(imageVector = Icons.Default.Add, contentDescription = "add_icon" , tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
@Composable
fun CommCard(commItem: commItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = commItem.Dp), contentDescription = "dp_1",
                modifier = Modifier
                    .size(45.dp)
//                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = commItem.name, style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                )
            )


        }
    }
}
@Composable
fun AddComm() {
    Column(Modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceAround , modifier = Modifier.fillMaxWidth()) {
            CommCardForAdd(commItem(R.drawable.dp1, "New Community test"))

        }

        Text(
            text = "My Communities", style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun CommList() {
    val commItemsList = listOf(
        commItem(R.drawable.comm1, "Android Dev's Comm"),
        commItem(R.drawable.comm2, "Harvard Alumni Community"),

    )
    LazyColumn(contentPadding = PaddingValues(bottom = 100.dp, top = 6.dp)) {
        items(commItemsList) { items ->
            CommCard(items)
        }
    }

}