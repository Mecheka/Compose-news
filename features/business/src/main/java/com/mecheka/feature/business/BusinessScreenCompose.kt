package com.mecheka.feature.business

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mecheka.core.compose.CommonNewsItem

@Composable
fun BusinessScreenCompose() {
    val context = LocalContext.current
    val viewModel: BusinessViewModel = hiltViewModel()
    val viewState by viewModel.viewState.collectAsState()

    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Business",
                style = MaterialTheme.typography.h5.copy(Color.White),
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
            )
            Card(
                shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp),
                backgroundColor = Color.White,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                when (viewState) {
                    Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Error", style = MaterialTheme.typography.h2)
                        }
                    }

                    Loading -> {
                        Box(modifier = Modifier.fillMaxSize()) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }

                    is Success -> {
                        LazyColumn {
                            items((viewState as Success).data) {
                                CommonNewsItem(
                                    image = it.urlToImage.orEmpty(),
                                    title = it.title.orEmpty(),
                                    author = it.author.orEmpty(),
                                    onClick = {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.url))
                                        context.startActivity(intent)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}