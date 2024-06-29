package org.example.firstwebap.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import org.example.firstwebap.util.Res
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.dppx
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Col
import org.jetbrains.compose.web.dom.Text

@Page()
@Composable
fun MainScreen(){
    val ctx = rememberPageContext()
    Surface(modifier = Modifier.fillMaxSize().backgroundColor(Color("#212121"))){
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(200.px).margin(top = 30.px),
                src = Res.Image.TTILE
            )

            Row(modifier = Modifier.margin(top = 100.px)) {
                MyButton(src = Res.Image.MAT, text = "Prayer Times", onClick = {}, src2 = Res.Image.MAT_BLUE)
                MyButton(src = Res.Image.TASBIH, text = "Tasbih", onClick = {ctx.router.navigateTo("/tasbih")}, src2 = Res.Image.TASBIH_BLUE)
                MyButton(src = Res.Image.BOOK, text = "Quran", onClick = {}, src2 = Res.Image.BOOK_BLUE)

            }
        }
    }
}

@Composable
private fun MyButton(src: String, src2: String, text: String, onClick:() -> Unit) {
    val ctx = rememberPageContext()
    val mySrc = remember { mutableStateOf(src) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(src = mySrc.value, modifier = Modifier.size(130.px).onClick {onClick()}.onMouseEnter { mySrc.value = src2}.onMouseOut { mySrc.value = src })
        Column(modifier = Modifier.fontSize(20.px).color(Color.yellow).margin(top = 20.px)) {
            Text(text)
        }
    }
}