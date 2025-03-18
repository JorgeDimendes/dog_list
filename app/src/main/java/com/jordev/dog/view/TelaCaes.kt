package com.jordev.dog.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jordev.dog.data.DataProvider
import com.jordev.dog.data.Puppy

@Composable
fun TelaCaes(
    navController: NavController,
    puppy: Puppy
){
    Column (
        modifier = Modifier
            //.padding(top = 30.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(puppy.puppyImageId),
            contentDescription = puppy.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
//                .size(200.dp)
//                .clip(RoundedCornerShape(15.dp)),
            contentScale = ContentScale.Crop
        )

        Column (
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = puppy.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)

            dividir()

            textoPequeno("Sexo")
            Text(text = puppy.sex, fontSize = 20.sp)

            dividir()

            textoPequeno("Idade")
            Text(text = "${puppy.age} anos", fontSize = 20.sp)

            dividir()

            textoPequeno("Personalidade")
            Text(text = puppy.description, fontSize = 20.sp)
        }

    }
}
@Composable
fun textoPequeno(textoPequeno: String){
    Text(
        text = textoPequeno,
        fontSize = 12.sp
        )
}

@Composable
fun dividir(){

    Divider(
        modifier = Modifier
            .fillMaxWidth() // A linha vai preencher toda a largura disponível
            .padding(vertical = 5.dp), // Espaçamento vertical ao redor da linha
        color = Color.Gray.copy(alpha = 0.5f), // Cor da linha
        thickness = 2.dp // Espessura da linha
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaCaes() {
    val navController = rememberNavController() // Criando um NavController fake
    val puppy = DataProvider.puppy // Pegando um cachorro de exemplo

    TelaCaes(navController, puppy) // Chamando a tela com o cachorro fictício
}
