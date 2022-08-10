package com.example.myapplicationtest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TrendHome() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Recommend" )
            }
        )
    })
    { innerPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            TrendScreen()
        }
    }
}

@Composable
    fun TrendScreen(modifier: Modifier = Modifier,viewModel: MainViewModel = MainViewModel()) {
    Surface(
        modifier
            .fillMaxWidth()
            .height(850.dp)
            .padding(horizontal = 4.dp, vertical = 8.dp), color = MaterialTheme.colors.primary
    ) {
        Column {
            Column {
                Text(text = "NewTrend")
                val scrollState = rememberLazyListState()
                LazyRow(state = scrollState) {
                    items(viewModel.newshops) {
                        newarticle(shop = it)
                    }
                }
            }
            Column {
                Text(text = "AreaTrend")
                val scrollState1 = rememberLazyListState()
                LazyRow(state = scrollState1) {
                    items(viewModel.areashops) {
                        areaarticle(shop = it)
                    }
                }
            }

            Column {
                Text(text = "PR")
                val scrollState1 = rememberLazyListState()
                LazyRow(state = scrollState1) {
                    items(viewModel.PRshops) {
                        PRarticle(shop = it)
                    }
                }
            }
        }

    }
}

    @Composable
    fun newarticle(modifier: Modifier = Modifier,shop:Shop) {
        Column() {
            Surface(
                modifier
                    .size(200.dp)
                    .padding(horizontal = 4.dp, vertical = 4.dp),
                color = MaterialTheme.colors.onSecondary
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = shop.image
                    ),
                    contentDescription = "shopImage",
                    modifier = Modifier.size(50.dp)
                )
            }
            Column(
                modifier
                    .padding(horizontal = 4.dp, vertical = 4.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = shop.name, style = TextStyle(fontSize = 10.sp))
                Text(text = shop.area, style = TextStyle(fontSize = 10.sp))
            }
        }

    }
@Composable
fun areaarticle(modifier: Modifier = Modifier,shop:Shop) {
    Column() {
        Surface(
            modifier
                .size(200.dp)
                .padding(horizontal = 4.dp, vertical = 4.dp),
            color = MaterialTheme.colors.onSecondary
        ) {
            Image(
                painter = rememberImagePainter(
                    data = shop.image
                ),
                contentDescription = "shopImage",
                modifier = Modifier.size(50.dp)
            )
        }
        Column(
            modifier
                .padding(horizontal = 4.dp, vertical = 4.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = shop.name, style = TextStyle(fontSize = 10.sp))
            Text(text = shop.area, style = TextStyle(fontSize = 10.sp))
        }
    }

}

@Composable
fun PRarticle(modifier: Modifier = Modifier,shop:Shop) {
    Column() {
        Surface(
            modifier
                .size(200.dp)
                .padding(horizontal = 4.dp, vertical = 4.dp),
            color = MaterialTheme.colors.onSecondary
        ) {
            Image(
                painter = rememberImagePainter(
                    data = shop.image
                ),
                contentDescription = "shopImage",
                modifier = Modifier.size(50.dp)
            )
        }
        Column(
            modifier
                .padding(horizontal = 4.dp, vertical = 4.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = shop.name, style = TextStyle(fontSize = 10.sp))
            Text(text = shop.area, style = TextStyle(fontSize = 10.sp))
        }
    }

}

