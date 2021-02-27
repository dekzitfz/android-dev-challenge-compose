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
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                DetailPuppy(intent.getSerializableExtra("DATA") as Puppy)
            }
        }
    }

    override fun onBackPressed() {
        this.finish()
    }
}

@Composable
fun DetailPuppy(puppy: Puppy) {
    val openDialog = remember { mutableStateOf(false) }
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Header(
                imageRes = puppy.image,
                name = puppy.name
            )

            Column(Modifier.padding(8.dp)) {
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h4
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = puppy.age,
                    style = MaterialTheme.typography.body2
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = puppy.getDescription(),
                    style = MaterialTheme.typography.caption
                )
                Spacer(Modifier.height(16.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { openDialog.value = true }
                ) {
                    Text("Adopt Me")
                }

                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = {
                            // Dismiss the dialog when the user clicks outside the dialog or on the back
                            // button. If you want to disable that functionality, simply use an empty
                            // onCloseRequest.
                            openDialog.value = false
                        },
                        title = {
                            Text(text = "Adopt Success")
                        },
                        text = {
                            Text("Thanks For Adopting ${puppy.name}!")
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    openDialog.value = false
                                }
                            ) {
                                Text("Ok")
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun Header(
    @DrawableRes imageRes: Int,
    name: String
) {
    Box(
        Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = "Image of $name",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightDetailPreview() {
    MyTheme {
        DetailPuppy(Puppy("Bella", "1 years", R.drawable.puppy1))
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkDetailPreview() {
    MyTheme(darkTheme = true) {
        DetailPuppy(Puppy("Bella", "1 years", R.drawable.puppy1))
    }
}
