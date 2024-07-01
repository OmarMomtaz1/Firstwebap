package org.example.firstwebap.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.layout.Surface
import org.example.firstwebap.util.Res
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Page("/info")
@Composable
fun InfoScreen(){
    val ctx = rememberPageContext()
    Surface(modifier = Modifier.fillMaxSize().backgroundImage(url(Res.Image.BACKGROUND))) {
        Column(modifier = Modifier.fillMaxSize().fontSize(60.px).padding(top = 40.px), horizontalAlignment = Alignment.CenterHorizontally){
                Column(modifier = Modifier.color(color = Color.yellow)) {
                    Text("Made by Omar Momtaz")
                }
                Column(modifier = Modifier.color(color = Color.yellow)) {
                    Text("Check the Desktop Application :)")
                }


        }
    }
}
