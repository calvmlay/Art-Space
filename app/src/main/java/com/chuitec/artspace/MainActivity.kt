package com.chuitec.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chuitec.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {

    var currentArtWork by remember { mutableStateOf(1) }
    val artWorkCount by remember { mutableStateOf(7) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(32.dp)) {
        when(currentArtWork) {
            1 -> ArtworkWithDetails(title = R.string.artwork_1_name,
                image = R.drawable.art_work_1,
                imageDescription = R.string.artwork_1_name,
                artistAndYear = R.string.artwork_1_artist_and_year
                            )
            2 -> ArtworkWithDetails(title = R.string.artwork_2_name,
                image = R.drawable.art_work_2,
                imageDescription = R.string.artwork_2_name,
                artistAndYear = R.string.artwork_2_artist_and_year
                            )
            3 -> ArtworkWithDetails(title = R.string.artwork_3_name,
                image = R.drawable.art_work_3,
                imageDescription = R.string.artwork_3_name,
                artistAndYear = R.string.artwork_3_artist_and_year
                            )
            4 -> ArtworkWithDetails(title = R.string.artwork_4_name,
                image = R.drawable.art_work_4,
                imageDescription = R.string.artwork_4_name,
                artistAndYear = R.string.artwork_4_artist_and_year
                            )
            5 -> ArtworkWithDetails(title = R.string.artwork_5_name,
                image = R.drawable.art_work_5,
                imageDescription = R.string.artwork_5_name,
                artistAndYear = R.string.artwork_5_artist_and_year
                            )
            6 -> ArtworkWithDetails(title = R.string.artwork_6_name,
                image = R.drawable.art_work_6,
                imageDescription = R.string.artwork_6_name,
                artistAndYear = R.string.artwork_6_artist_and_year
                            )
            7 -> ArtworkWithDetails(title = R.string.artwork_7_name,
                image = R.drawable.art_work_7,
                imageDescription = R.string.artwork_7_name,
                artistAndYear = R.string.artwork_7_artist_and_year
                            )
        }

        TwoButtons(
            previousButtonClick = {
                if (currentArtWork == 1) {
                    currentArtWork = artWorkCount
                } else {
                    currentArtWork--
                }
            },
            nextButtonClick = {
                if (currentArtWork == artWorkCount) {
                    currentArtWork = 1
                } else {
                    currentArtWork++
                }
            }
        )
    }
}

@Composable
fun ArtworkWithDetails(
    title: Int,
    image: Int,
    imageDescription: Int,
    artistAndYear: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Image(painter = painterResource(image),
                contentDescription = stringResource(imageDescription),
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.size(40.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(title),
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)
            )
            Text(
                text = stringResource(artistAndYear),
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
            )
        }

    }

}

@Composable
fun TwoButtons(
    previousButtonClick: () -> Unit,
    nextButtonClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
    ) {
        Button(
            onClick = previousButtonClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.previous_button_text))
        }
        Spacer(modifier = Modifier.size(24.dp))
        Button(
            onClick = nextButtonClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.next_button_text))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}