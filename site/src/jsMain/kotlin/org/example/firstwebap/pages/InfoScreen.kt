package org.example.firstwebap.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage
import org.example.firstwebap.util.Res
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Page("/info")
@Composable
fun InfoScreen(){
    val ctx = rememberPageContext()
    var curr = ColorMode.current
    var colorMode = remember { mutableStateOf( curr) }
    var savedTheme: String = ""
    if (localStorage?.getItem("theme") != ColorMode.LIGHT.name && localStorage.getItem("theme") != ColorMode.DARK.name ){
        localStorage.setItem("theme", ColorMode.LIGHT.name)
    } else{
        localStorage.getItem("theme").also {
            if (it != null) {
                savedTheme = it
            }
            else{
                savedTheme = ColorMode.LIGHT.name
            }
        }
    }

    colorMode.value = savedTheme.let { ColorMode.valueOf(it) }
    Surface(modifier = Modifier.fillMaxSize().backgroundImage(if (colorMode.value.isDark) url(Res.Image.BACKGROUND) else url(Res.Image.LIGHT_BG))) {
        Column(modifier = Modifier.fillMaxSize().fontSize(60.px).padding(top = 40.px), horizontalAlignment = Alignment.CenterHorizontally){
                Column(modifier = Modifier.color(color = if (colorMode.value.isDark) Color.yellow else Color.white)) {
                    Text("Made by Omar Momtaz")
                }
                Column(modifier = Modifier.color(color = if (colorMode.value.isDark) Color.yellow else Color.white)) {
                    Text("Check the Desktop Application :)")
                }


        }
    }
}
