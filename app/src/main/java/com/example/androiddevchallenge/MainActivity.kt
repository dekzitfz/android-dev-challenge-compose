/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(dummyData())
            }
        }
    }
}

private fun dummyData(): List<Puppy> {
    val data = mutableListOf<Puppy>()
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    data.add(Puppy("cebol", "2 years", R.drawable.puppy1))
    return data
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PuppyList(data: List<Puppy>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        items(data) { puppy ->
            Box(contentAlignment = Alignment.BottomStart) {
                Image(
                    painter = painterResource(id = puppy.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(
                        text = puppy.name,
                        modifier = Modifier
                            .padding(start = 8.dp),
                        fontSize = 20.sp,
                        style = TextStyle(fontWeight = FontWeight.Bold, color = Color.White)
                    )
                    Text(
                        text = puppy.age,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 8.dp),
                        fontSize = 12.sp,
                        style = TextStyle(color = Color.White)
                    )
                }

            }
        }
    }
}

// Start building your app here!
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp(data: List<Puppy>) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                title = { Text(text = "Puppies")},
            )
            PuppyList(data = data)
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(dummyData())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(dummyData())
    }
}
