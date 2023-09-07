package com.example.lemonadeapp

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakeLemonade(modifier: Modifier = Modifier){
    val lemonadeStages = arrayOf(mapOf(Pair(first = R.drawable.lemon_tree, second = R.string.lemon_tree)),
        mapOf(Pair(first = R.drawable.lemon_squeeze, second = R.string.lemon_squeeze)),
        mapOf(Pair(first = R.drawable.lemon_drink, second = R.string.lemon_drink)),
        mapOf(Pair(first = R.drawable.lemon_restart, second = R.string.lemon_empty)))

    var lemonadeStage by remember {
        mutableStateOf(0)
    }

    var counter by remember {
        mutableStateOf((2..4).random())
    }

    val currentStage = when(lemonadeStage){
        0 -> lemonadeStages[lemonadeStage]
        1 -> lemonadeStages[lemonadeStage]
        2 -> lemonadeStages[lemonadeStage]
        3 -> lemonadeStages[lemonadeStage]
        else -> lemonadeStages[0]
    }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(text = "Lemonade", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Yellow
        )) }
    ) {
         Column(
             modifier = modifier
                 .wrapContentSize(align = Alignment.Center)
                 .fillMaxSize(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {

             Image(painter = painterResource(id = currentStage.keys.elementAt(0)), contentDescription = stringResource(id = currentStage.values.elementAt(0)),
             modifier = modifier
                 .background(color = Color(0xFF90EE90), shape = RoundedCornerShape(24.dp))
                 .padding(32.dp)
                 .pointerInput(Unit) {
                     detectTapGestures(onPress = {
                         if(lemonadeStage == 1){
                             counter -= 1

                             showToast(counter)

                             if(counter <= 0) {
                                 lemonadeStage = displayLemonade(lemonadeStage)
                             }

                         } else {
                             lemonadeStage = displayLemonade(lemonadeStage)

                             if(lemonadeStage == 0){
                                 counter = (2..4).random()
                             }
                         }
                     })
                 }
             )

             Spacer(modifier = modifier.height(12.dp))

             Text(text = stringResource(id = currentStage.values.elementAt(0)), style = TextStyle(fontSize = 18.sp))
         }
    }
}

fun displayLemonade(stage: Int): Int{
    var newStage = stage

    if (newStage < 3) {
        newStage += 1
        return newStage
    }

    return 0
}

fun showToast(counter: Int){
    //Toast.makeText(Application().applicationContext, "Tap more $counter to finish squeezing lemode", Toast.LENGTH_SHORT).show()
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LemonadeApp(){
   MakeLemonade()
}

