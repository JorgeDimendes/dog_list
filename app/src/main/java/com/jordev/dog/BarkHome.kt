package com.jordev.dog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jordev.dog.data.DataProvider

@Composable
fun BarkHomeContent(navController: NavController){
    val puppies = remember{ DataProvider.puppyList}

    LazyColumn (
        modifier = Modifier
            .background(Color.White),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = puppies,
            itemContent = {
                PuppyListItem(puppy = it, navController = navController)
            }
        )
    }
}