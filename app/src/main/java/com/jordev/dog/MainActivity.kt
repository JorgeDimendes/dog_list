package com.jordev.dog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jordev.dog.Rotas.Rotas
import com.jordev.dog.data.DataProvider
import com.jordev.dog.view.TelaCaes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            )
        )
        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Rotas.TelaLista) {
                composable(Rotas.TelaLista) {
                    BarkHomeContent(navController)
                }
//                composable(Rotas.TelaCaes){
//                    TelaCaes(navController)
//                }
                composable(
                    route = "tela_caes/{puppyId}",
                    arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
                ){backStackEntry ->
                    val puppyId = backStackEntry.arguments?.getInt("puppyId") ?: 0
                    val puppy = DataProvider.puppyList.find {it.id == puppyId}
                    if (puppy != null){
                        TelaCaes(navController, puppy)
                    }
                }
            }
        }
    }
}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun MyApp() {
//    Scaffold (
//        content = {
//            BarkHomeContent(navController = NavController(navController))
//        }
//    )
//}
