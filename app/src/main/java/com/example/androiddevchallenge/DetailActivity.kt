package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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

class DetailActivity: AppCompatActivity(){
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
    val openDialog = remember { mutableStateOf(false)  }
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

                if(openDialog.value){
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
                                }) {
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