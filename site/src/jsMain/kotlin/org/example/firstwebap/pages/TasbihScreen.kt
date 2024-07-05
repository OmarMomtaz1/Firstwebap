package org.example.firstwebap.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.functions.brightness
import com.varabyte.kobweb.compose.css.functions.contrast
import com.varabyte.kobweb.compose.css.functions.invert
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.ColorScheme
import com.varabyte.kobweb.silk.theme.colors.ColorSchemes
import kotlinx.browser.localStorage
import org.example.firstwebap.util.Res
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Page("/tasbih")
@Composable
fun TasbihScreen(){
    val ctx = rememberPageContext()
    var curr = ColorMode.current
    var colorMode = remember { mutableStateOf( curr) }
    if (localStorage.getItem("theme" ) == null){
        localStorage.setItem("theme", ColorMode.LIGHT.name)
    }
    var savedTheme: String = ""
    savedTheme = localStorage.getItem("theme")!!
    colorMode.value = savedTheme.let { ColorMode.valueOf(it) }


    val num = remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().backgroundImage(if (colorMode.value.isDark) url(Res.Image.BACKGROUND) else url(Res.Image.LIGHT_BG)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Column(
            modifier = Modifier.fontSize(60.px).fontFamily("Serif")
                .fillMaxWidth()
                .color(color = if (colorMode.value.isDark) Color.yellow else Color.white), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Text("سبحان الله و بحمده")
        }

        Column(
            modifier = Modifier.fontSize(60.px).margin {top(30.px) }.fontFamily("Fantasy")
                .fillMaxWidth()
                .color(color = if (colorMode.value.isDark) Color.yellow else Color.white), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Text(num.value.toString())
        }

        Button(
            modifier = Modifier
                .margin { top(80.px) }
                .width(100.px)
                .height(50.px)
                .backgroundColor(color = if(colorMode.value.isDark) Color.yellow else Color.white),
            onClick = {num.value+=1},
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