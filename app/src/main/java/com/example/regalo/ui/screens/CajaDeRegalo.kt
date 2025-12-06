package com.ejemplo.regalo.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ejemplo.regalo.ui.theme.RegaloTheme


@Composable
fun CajaDeRegalo(abrir: () -> Unit){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(19.dp))
            .background(Color(0xFF17D918))
            .clickable{abrir()}
    ){
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(30.dp)
                .background(Color(0xFF1334C9))
                .align(Alignment.Center)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(Color(0xFF1334C9))
                .align(Alignment.Center)
        )

        Surface(
            shape = RoundedCornerShape(59),
            color = Color(0x33FFFFFF),
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center)
        ){
            Box(contentAlignment = Alignment.Center){
                Text(text = "\uD83C\uDF80", style = MaterialTheme.typography.headlineLarge )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCajaDeRegalo(){
    RegaloTheme {
        CajaDeRegalo{

        }
    }
}