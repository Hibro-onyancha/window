import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Row(
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.onBackground),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            header()
        }
    }
}

@Composable
fun header(
    modifier: Modifier = Modifier,
) {
    val dogs = listOf("dog.jpg", "dog2.jpg", "dog3.jpg", "daer.jpg", "dearfam.jpg", "fattig.jpg", "flamfam.jpg", "flamingo.jpg", "impalla.jpg", "jaguar.jpg", "main.png")
    var currentDog by remember {
        mutableStateOf(0)
    }

    Row(
        modifier = modifier.fillMaxWidth().padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(0.3f),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Not only people \n need a house",
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                maxLines = 2,
                fontSize = 40.sp,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.SansSerif,
                lineHeight = 50.sp
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "You've probably noticed your dog sniffing around constantly, but did you know their sense of smell is incredible? Their noses contain up to 300 million olfactory receptors, compared to our measly 6 million. The area in their brain dedicated to smell is also 40 times larger than ours [1]. This allows them to detect odors at amazing levels of detail and even pick up on faint traces of chemicals.",
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = Color.Gray,

                )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier.width(150.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .clickable {
                        if (currentDog != dogs.lastIndex) {
                            currentDog++
                        } else {
                            currentDog = 0
                        }
                    }
                    .background(Color.Yellow),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "next")
            }
        }
        Image(
            painter = painterResource(resourcePath = dogs[currentDog]),
            contentDescription = "",
            modifier = Modifier.weight(0.6f).padding(start = 40.dp).clip(RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Crop
        )

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
