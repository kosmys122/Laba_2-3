package com.example.lab_10_pixletter

import android.os.Bundle
import  androidx.compose.ui.res.stringResource
import  androidx.compose.foundation.layout.Box
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab_10_pixletter.ui.theme.Lab_10_PixLetterTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_10_PixLetterTheme {
                GreetingImage(message = stringResource(R.string.king_message_text),
                    from ="From King Arthur")
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(color = Color.Yellow) {
//        Text(
//            text = "Hi, my name is $name!",
//            modifier = modifier.padding(24.dp)
//        )
//    }
//}

//@Preview(showBackground = false)
//@Composable
//fun RoyalInvitationPreview() {
//    Lab_10_PixLetterTheme {
//        GreetingText(message = "Royal Decree! \n" +
//                "Dear Ivan, \n" +
//                "His Majesty the King \n" +
//                "Invites you to a great feast! \n" +
//                "Come to the castle before sunset, \n" +
//                "otherwise, you risk losing your head!", from ="From King Arthur",
//            modifier = Modifier.padding(8.dp))
//
//    }
//}

@Composable
fun GreetingText(message: String, from:String, modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(12.dp)).padding(16.dp)) {
        InvitationTitle()
        Text(
            text = message,
            fontSize = 20.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Text(
            text = from,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.thefinals)
    Box (modifier){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            alpha = 0.8F,
            modifier = Modifier.fillMaxSize(),
        )
        GreetingText(
            message=message,
            from=from,
            modifier=Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun RoyalInvitationPreview() {
    Lab_10_PixLetterTheme {
        GreetingImage(
            message = stringResource(R.string.from_king_arthur),
            from = stringResource(R.string.from_king_arthur)
        )
    }
}
@Composable
fun InvitationTitle(modifier: Modifier=Modifier){
    Text(
        text = stringResource(R.string.invitation_title),
        fontSize = 28.sp,
        color = Color.Yellow,
        textAlign = TextAlign.Center,
        modifier = modifier.padding(bottom = 16.dp)
    )
}