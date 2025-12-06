package com.ejemplo.regalo.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ejemplo.regalo.viewmodel.RegaloViewModel


@Composable
fun RegaloScreen(
    viewModel: RegaloViewModel = viewModel(),
    idImagen: Int
){
    val isWrappedState = viewModel.isEnvuelto.collectAsState(initial=true)
    val isWrapped = isWrappedState.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text= if(isWrapped) "¡Tienes un regalo Evelyn!" else "¡Sorpresa!",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(300.dp)
                .shadow(10.dp, RoundedCornerShape(16.dp))
        ){
            Image(
                painter = painterResource(id=idImagen),
                contentDescription = "Tu regalo esta navidad",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .clickable{
                        if(!isWrapped) viewModel.envolverCaja()
                    }
            )
            androidx.compose.animation.AnimatedVisibility(
                visible = isWrapped,
                exit =
                    fadeOut(animationSpec = tween(1000)) +
                            scaleOut(animationSpec = tween (1000), targetScale = 1.5f),
                modifier = Modifier.align(Alignment.Center)
            ){
                CajaDeRegalo(abrir = { viewModel.abrirCaja() } )
            }

            if(!isWrapped){
                Text(
                    text = "Si no te gusto tu regalo, tocalo para envolver de nuevo",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            if(!isWrapped){
                Text(
                    text = "🎄¡Feliz Navidad!🎁",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(16.dp)
                )
            }

        }
    }
}