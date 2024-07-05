package org.example.firstwebap.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.functions.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Switch
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage
import org.example.firstwebap.util.Res
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text


@Page()
@Composable
fun MainScreen(){
    val ctx = rememberPageContext()
    var curr = ColorMode.current
    var colorMode = remember { mutableStateOf( curr) }
    if (localStorage.getItem("theme" ) == null){
        localStorage.setItem("theme", ColorMode.LIGHT.name)
    }
    var savedTheme: String = ""
    savedTheme = localStorage.getItem("theme")!!
    colorMode.value = savedTheme.let { ColorMode.valueOf(it) }

    Surface(modifier = Modifier.fillMaxSize().backgroundImage(if (colorMode.value.isDark) url(Res.Image.BACKGROUND) else url(Res.Image.LIGHT_BG))){
        Column(modifier = Modifier.fillMaxSize().padding(top = 20.px), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = if(colorMode.value.isLight) Modifier.size(200.px).margin(top = 30.px).filter(brightness(0),invert(1)) else Modifier.size(200.px).margin(top = 30.px).filter(),
                src = Res.Image.TTILE
            )

            Column(modifier = Modifier.margin(top = 100.px), verticalArrangement = Arrangement.spacedBy(10.px)){
                Row() {
                    MyButton(src = Res.Image.MAT, text = "Prayer Times", onClick = {}, if (colorMode.value.isDark) remember { mutableStateOf(Modifier.size(130.px).filter()) } else remember {mutableStateOf(Modifier.filter(brightness(0),invert(1)).size(130.px))}, color = if (colorMode.value.isDark) Color.yellow else Color.white)
                    MyButton(src = Res.Image.TASBIH, text = "Tasbih", onClick = {ctx.router.navigateTo("/tasbih")}, if (colorMode.value.isDark) remember { mutableStateOf(Modifier.size(130.px).filter()) } else remember {mutableStateOf(Modifier.filter(brightness(0),invert(1)).size(130.px))}, color = if (colorMode.value.isDark) Color.yellow else Color.white)
                }
                Row(modifier = Modifier.margin(top = 20.px), horizontalArrangement = Arrangement.spacedBy(10.px)) {
                    MyButton(src = Res.Image.BOOK, text = "Quran", onClick = {}, if (colorMode.value.isDark) remember { mutableStateOf(Modifier.size(130.px).filter()) } else remember {mutableStateOf(Modifier.filter(brightness(0),invert(1)).size(130.px))}, color = if (colorMode.value.isDark) Color.yellow else Color.white)
                    MyButton(src = Res.Image.INFO, text = "Info", onClick = {ctx.router.navigateTo("/info")},if (colorMode.value.isDark) remember { mutableStateOf(Modifier.size(130.px).filter()) } else remember {mutableStateOf(Modifier.filter(brightness(0),invert(1)).size(130.px))}, color = if (colorMode.value.isDark) Color.yellow else Color.white)
                }

            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.px), modifier = Modifier.padding(top = 70.px)) {
                Column(Modifier.color(color = if (colorMode.value.isDark) Color.yellow else Color.white)) {
                    Text("Dark Mode")
                }
                Switch(checked = colorMode.value.isDark, onCheckedChange = {colorMode.value = colorMode.value.opposite; localStorage.setItem("theme",colorMode.value.name)})
            }
            Column(modifier = Modifier.padding(top = 70.px).color(color = if (colorMode.value.isDark) Color.yellow else Color.white)) {
                Text("Made By Omar Momtaz")
            }
        }
    }
}

@Composable
fun MyButton(src: String, text: String, onClick:() -> Unit, modifier: MutableState<Modifier>, color: CSSColorValue) {
    val ctx = rememberPageContext()
    val mod = remember { mutableStateOf(modifier.value) }
    mod.value = modifier.value
    val mySrc = remember { mutableStateOf(src) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(src = mySrc.value, modifier = mod.value.onClick {onClick()}.onMouseEnter {mod.value = modifier.value.size(130.px).filter(brightness(amount = 108.percent), invert(64.percent), sepia(50.percent), contrast(98.percent),
            hueRotate(angle = 300.deg),
            saturate(5564.percent)).size(130.px)}.onMouseOut { mod.value = modifier.value})
        Column(modifier = Modifier.fontSize(20.px).color(color).margin(top = 20.px)) {
            Text(text)
        }
    }
}