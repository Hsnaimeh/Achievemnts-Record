package com.runkeeper.exercise.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.runkeeper.exercise.data.model.main.RemoteMedalResponse
import com.runkeeper.exercise.data.model.main.RemoteRecordsResponse
import com.runkeeper.exercise.ui.theme.BlackLight
import com.runkeeper.exercise.ui.theme.GrayDark
import com.runkeeper.exercise.ui.theme.GrayLight
import com.runkeeper.exercise.ui.theme.RemoteImage

@Composable
fun AchievementsSection(medals: RemoteMedalResponse) {
    Column(Modifier.padding(bottom = 40.dp)) {
        TitleSection(medals)
        Column {
            medals.records.forEachIndexed { index, _ ->
                Row {
                    if (index.isEven) {
                        MedalRow(medals.records[index], Modifier.fillMaxWidth(0.5f))
                        if (index + 1 < medals.records.size)
                            MedalRow(medals.records[index + 1], Modifier.fillMaxWidth())
                    }
                }
            }
        }

    }
}


@Composable
fun TitleSection(item: RemoteMedalResponse) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(GrayLight),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.title, modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(10.dp),
            style = MaterialTheme.typography.subtitle2,
            color = BlackLight
        )
        Text(
            text = item.label,
            Modifier.padding(10.dp),
            color = GrayDark
        )
    }
}

@Composable
fun MedalRow(item: RemoteRecordsResponse, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.alpha(if (item.active) 1f else 0.5f).padding(top = 15.dp)
    ) {

        RemoteImage(
            data = item.image,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(horizontal = 15.dp)
        )
        Text(
            text = item.title, modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 5.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,

            color = Color.Black,
            style = MaterialTheme.typography.subtitle2
        )

        Text(
            text = item.label,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 10.dp),
            color = Color.Black,
            style = MaterialTheme.typography.body1
        )
    }
}

private val Int.isEven: Boolean
    get() {
        return if (this == 0)
            true
        else this.mod(2) == 0
    }