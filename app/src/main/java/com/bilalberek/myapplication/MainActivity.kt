package com.bilalberek.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    private lateinit var painter: Painter
    private lateinit var contentDescription: String
    private lateinit var title: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


        //  1) Learning and applying column and Row in compose.


            /*


            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)) {

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
            ) {
                Text( "Bilal", color = Color.White , style = TextStyle(fontSize = 30.sp))
                Text( "Berek", color = Color.White , style = TextStyle(fontSize = 30.sp))

            }
*/

        // 2) Learning and Applying Modifiers in compose.


            /*

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .background(Color.Red)
                    .height(400.dp)
                    .border(width = 2.dp,Color.Cyan)
                    .padding(2.dp)
                    .border(width = 4.dp, Color.DarkGray)
                    .padding(4.dp)
                    .border(10.dp, Color.Yellow, shape = RoundedCornerShape(20.dp)),


                //In Compose there is no  feature refers to margin completely instead you can use padding.
                //.requiredHeight(800.dp) this feature exceed(If the parent
                // container's height less than 800) the parent container of the given element, but when you use
                // .width(800.dp), the element expand its parent container's width.

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

                //It is possible to make components interactive by implement some modifiers like clickable, draggable etc.

            ) {
                Text(text = "Hello World", color  = Color.White, style = TextStyle(fontSize = 20.sp), modifier = Modifier

                    .clickable {
                        Toast.makeText(
                            this@MainActivity,
                            "hello world text clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
            }

        }
*/
        // 3) adding image card in a  composable function  and modify it.

             painter = painterResource(id = R.drawable.dark)
             contentDescription = "Lady in the dark, lost in thorough sunrise"
             title = "Lady in the dark, lost in thorough sunrise"


            Box(
               modifier = Modifier
                   .fillMaxSize(0.5f)
                   .padding(16.dp)
                   .clickable {
                       Toast
                           .makeText(this@MainActivity, "you clicked picture", Toast.LENGTH_SHORT)
                           .show()
                   }
            ) {

            ModifyImageCard(
                painter = painter,
                contentDescription = contentDescription,
                title = title
            )
        }


        }
    }


    @Composable
    fun ModifyImageCard(
        painter: Painter,
        contentDescription: String,
        title: String,
        modifier: Modifier = Modifier
    ){
        Card(
            modifier =  modifier.fillMaxSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {

            Box(
                modifier = Modifier.size(200.dp)
            ) {

                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black,
                            ),
                            startY = 300f

                        )
                    ))

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ){
                    Text(title, style = TextStyle(fontSize = 16.sp, color =  Color.White))
                }
            }


        }
    }


}



