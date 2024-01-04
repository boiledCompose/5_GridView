package com.example.gridview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridview.model.Topic
import com.example.gridview.ui.theme.GridViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GridApp(modifier: Modifier = Modifier) {

    GridCardList(topicList = DataSource.topics)
}

@Composable
fun GridCardList(topicList:List<Topic>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ){
        items(topicList) {topic ->
            GridCard(topic, modifier)
        }
    }
}

@Composable
fun GridCard(topic: Topic, modifier:Modifier = Modifier){
    Card(modifier = modifier.wrapContentHeight()){
        Row{
            Image(painter = painterResource(id = topic.drawableSourceId),
                contentDescription = stringResource(id = topic.stringSourceId),
                Modifier.size(68.dp),
                contentScale = ContentScale.Crop)

            GridCardTexts(topic, modifier)
        }
    }
}

@Composable
fun GridCardTexts(topic: Topic, modifier: Modifier = Modifier){
    Column(modifier = modifier){
        Text(
            text = stringResource(id = topic.stringSourceId),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
        )
        GridCardIconAndNumber(topic, modifier)
    }
}

@Composable
fun GridCardIconAndNumber(topic: Topic, modifier: Modifier = Modifier){
    Row(modifier = modifier){
        Icon(
            painter = painterResource(id = R.drawable.ic_grain),
            contentDescription = null,
            modifier = Modifier.padding(start = 16.dp)
        )

        Text(
            text = topic.number.toString(),
            modifier = Modifier.padding(start = 8.dp)
        )

    }
}