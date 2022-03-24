package com.runkeeper.exercise.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.runkeeper.exercise.ui.component.AchievementsSection
import com.runkeeper.exercise.ui.component.TopBarSection
import com.runkeeper.exercise.ui.theme.AchievementTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AchievementTheme {
                Scaffold(
                    topBar = {
                        TopBarSection()
                    },
                    modifier = Modifier.fillMaxSize(),
                    content = { ContentSection(viewModel) }
                )
            }
        }
    }
}

@Composable
fun ContentSection(viewModel: MainViewModel) {
    val achievements = viewModel.responseAdsState.value ?: emptyList()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        if (viewModel.loadingState.value)
            CircularProgressIndicator(Modifier.size(100.dp), color = Color.Black)
        else
            achievements.forEach { item -> AchievementsSection(item) }
    }
}

