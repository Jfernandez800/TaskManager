package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CheckmarkImage()
                        CheckmarkPreview()
                    }
                }
            }
        }
    }
}

@Composable
fun ConfirmText(
    confirmation: String,
    //Pass the function from parameter of type String for your signature.
    comment: String,
) {
    Text(
        text = confirmation, // add a Text composable passing in the text message as a named argument.
        fontSize = 16.sp, //Add a fontSize argument with value of 100.sp.
        fontWeight = FontWeight.Bold, //Add a lineHeight argument with a value of 116.sp.
        modifier = Modifier
            .padding(0.dp,24.dp,0.dp,8.dp)
    )
    Text(
        text = comment, //Add Text composable that accepts text argument set to the from value.
        fontSize = 16.sp, //Add a fontSize argument with a value of 36.sp.
    )
}

@Composable
fun CheckmarkImage(
    modifier: Modifier = Modifier
) {
    // call to painterResource() function by passing in the androidparty resource. Assign the
    // returned value to the image variable.
    val image = painterResource(R.drawable.ic_task_completed)
    Box(modifier) { // pass the modifier parameter to the Box composable
        Image(
            painter = image,
            contentDescription = null, //add argument called contentDescription and set its value to null.
            //contentScale = ContentScale.Crop, // use the ContentScale.Crop parameter scaling, which
            )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckmarkPreview() {
    TaskManagerTheme {
        ConfirmText(
            confirmation = stringResource(R.string.all_tasks_completed),
            comment = stringResource(R.string.nice_work)
        )
    }
}