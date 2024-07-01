package org.example.firstwebap.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.theme.colors.ColorSchemes
import org.example.firstwebap.util.Res
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Page("/tasbih")
@Composable
fun TasbihScreen(){
    val num = remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().backgroundImage(url(Res.Image.BACKGROUND)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Column(
            modifier = Modifier.fontSize(60.px).fontFamily("Serif")
                .fillMaxWidth()
                .color(Color.yellow), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Text("سبحان الله و بحمده")
        }

        Column(
            modifier = Modifier.fontSize(60.px).margin {top(30.px) }.fontFamily("Fantasy")
                .fillMaxWidth()
                .color(Color.yellow), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Text(num.value.toString())
        }

        Button(
            modifier = Modifier
                .margin { top(80.px) }
                .width(100.px)
                .height(50.px),
            onClick = {num.value+=1},
            colorScheme = ColorSchemes.Yellow,
            content = {

                Column(
                    modifier = Modifier.fontSize(20.px)
                        .fillMaxSize()
                        .color(Color.black), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("سبح")
                }

            }
        )
    }
}