package com.jordev.dog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jordev.dog.Rotas.Rotas
import com.jordev.dog.data.Puppy

@Composable
fun PuppyListItem(puppy: Puppy, navController: NavController){
    Card (
        elevation =  CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            //.background(Color.White)
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White)
    ){
        Row (
            modifier = Modifier
                .clickable {
                    //navController.navigate(Rotas.TelaCaes)
                    navController.navigate("tela_caes/${puppy.id}")
                }
        ){

            PuppyImage(puppy = puppy)

            Column (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ){
                Text(text = puppy.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = puppy.description, fontSize = 16.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }
        }
    }
}

@Composable
private fun PuppyImage(puppy: Puppy){
    Image(
        painter = painterResource(puppy.puppyImageId),
        contentDescription = null,
        modifier = Modifier
            .padding(5.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(15.dp)),
//            .width(100.dp)
//            .height(100.dp),
        contentScale = ContentScale.Crop

    )
}