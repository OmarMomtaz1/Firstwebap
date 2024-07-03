package org.example.firstwebap.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.css.CSSAngleNumericValue
import com.varabyte.kobweb.compose.css.functions.*
import com.varabyte.kobweb.compose.css.margin
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.Surface
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.example.firstwebap.util.Res
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Col
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.events.MouseEvent

@Page()
@Composable
fun MainScreen(){
    val ctx = rememberPageContext()
    Surface(modifier = Modifier.fillMaxSize().backgroundImage(url(Res.Image.BACKGROUND))){
        Column(modifier = Modifier.fillMaxSize().padding(top = 20.px), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(200.px).margin(top = 30.px),
                src = Res.Image.TTILE
            )

            Column(modifier = Modifier.margin(top = 100.px), verticalArrangement = Arrangement.spacedBy(10.px)){
                Row() {
                    MyButton(src = Res.Image.MAT, text = "Prayer Times", onClick = {})
                    MyButton(src = Res.Image.TASBIH, text = "Tasbih", onClick = {ctx.router.navigateTo("/tasbih")})
                }
                Row(modifier = Modifier.margin(top = 20.px), horizontalArrangement = Arrangement.spacedBy(10.px)) {
                    MyButton(src = Res.Image.BOOK, text = "Quran", onClick = {})
                    MyButton(src = Res.Image.INFO, text = "Info", onClick = {ctx.router.navigateTo("/info")})
                }

            }
            Column(modifier = Modifier.margin(top = 150.px).color(color = Color.yellow)) {
                Text("Made By Omar Momtaz")
            }
        }
    }
}

@Composable
private fun MyButton(src: String, text: String, onClick:() -> Unit) {
    val ctx = rememberPageContext()
    var modifier = remember { mutableStateOf(Modifier.size(130.px)) }
    val mySrc = remember { mutableStateOf(src) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(src = mySrc.value, modifier = modifier.value.onClick {onClick()}.onMouseEnter {modifier.value =  Modifier.filter(brightness(amount = 108.percent), invert(64.percent), sepia(50.percent), contrast(98.percent),
            hueRotate(angle = 300.deg),
            saturate(5564.percent)).size(130.px)}.onMouseOut { modifier.value = Modifier.filter().size(130.px)})
        Column(modifier = Modifier.fontSize(20.px).color(Color.yellow).margin(top = 20.px)) {
            Text(text)
        }
    }
}