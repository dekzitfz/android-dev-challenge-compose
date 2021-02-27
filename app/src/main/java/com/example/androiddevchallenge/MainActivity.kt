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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
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
    data.add(Puppy("Bella", "1 years", R.drawable.puppy1))
    data.add(Puppy("Luna", "2.5 years", R.drawable.puppy2))
    data.add(Puppy("Charlie", "2 years", R.drawable.puppy3))
    data.add(Puppy("Lucy", "1.5 years", R.drawable.puppy4))
    data.add(Puppy("Cooper", "3 years", R.drawable.puppy5))
    data.add(Puppy("Max", "1 years", R.drawable.puppy6))
    data.add(Puppy("Bailey", "2 years", R.drawable.puppy7))
    data.add(Puppy("Daisy", "2 years", R.drawable.puppy8))
    data.add(Puppy("Rocky", "1 years", R.drawable.puppy9))
    data.add(Puppy("Gary", "2 years", R.drawable.puppy10))
    return data
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PuppyList(data: List<Puppy>, ctx: Context) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        items(data) { puppy ->
            Box(
                contentAlignment = Alignment.BottomStart,
                modifier = Modifier.clickable(
                    onClick = {
                        ctx.startActivity(
                            Intent(ctx, DetailActivity::class.java)
                                .putExtra("DATA", puppy)
                        )
                    }
                )
            ) {
                Image(
                    painter = painterResource(id = puppy.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp(data: List<Puppy>) {
    val context = LocalContext.current
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                title = { Text(text = "PuppyFinder") },
            )
            PuppyList(data = data, context)
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
