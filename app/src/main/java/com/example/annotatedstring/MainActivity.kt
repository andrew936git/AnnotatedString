package com.example.annotatedstring

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation.Clickable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val textColor = Color.Magenta
            val textStyle = TextLinkStyles(SpanStyle(color = textColor,
                textDecoration = TextDecoration.Underline))
            val link = Clickable(tag = "",linkInteractionListener = {
                context.startActivity(Intent(context, SecondActivity::class.java)) }, styles = textStyle )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(top = 40.dp, start = 90.dp, end = 90.dp)
                ) {
                Text(
                    buildAnnotatedString {
                        withLink(link){
                            append("Urban")
                        }
                        append("University")

                    },
                    fontSize = 36.sp,

                )
            }

        }
    }
}




