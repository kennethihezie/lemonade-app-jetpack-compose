package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
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
    val map = HashMap<String, String>()
    val lemonadeStages = arrayOf()

    var lemonadeStage by remember {
        mutableStateOf(0)
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
             
             Image(painter = painterResource(id = currentStage['']), contentDescription = "tree",
             modifier = modifier
                 .background(color = Color(0xFF90EE90), shape = RoundedCornerShape(24.dp))
                 .padding(32.dp)
             )

             Spacer(modifier = modifier.height(12.dp))

             Text(text = "Keep tapping the lemon to squeeze it", style = TextStyle(fontSize = 16.sp))
         }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LemonadeApp(){
   MakeLemonade()
}

