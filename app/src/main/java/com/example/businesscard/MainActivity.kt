package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeaderCard(stringResource(R.string.full_name),
                        stringResource(R.string.title),
                        stringResource(R.string.phone),
                        stringResource(R.string.ig_social),
                        stringResource(R.string.email)
                    )

                }
            }
        }
    }
}

@Composable
fun HeaderCard(name: String, title : String, phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    val ph = painterResource(R.drawable.baseline_local_phone_24)
    val ig = painterResource(R.drawable.instagram__2_)
    val em = painterResource(R.drawable.baseline_alternate_email_24)
    Box (
        Modifier
            .fillMaxSize()
            .background(Color(0xFFD1E7D3))){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .background(color = Color(0xFF073042))
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(
                text = name,
                fontSize = 35.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
            )
            Text(
                text = title, fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(1, 108, 58, 255),
                modifier = Modifier
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .weight(1f)
            ) {
                Column (verticalArrangement = Arrangement.Bottom,modifier = modifier
                    .weight(1f)
                    .padding(50.dp)
                ){
                    Row(modifier = Modifier) {
                        Image(painter = ph, contentDescription = null)
                        Text(text = phone, Modifier.padding(16.dp, 0.dp, 0.dp, 16.dp))
                    }
                    Row(modifier = Modifier) {
                        Image(
                            painter = ig,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = social, Modifier.padding(16.dp, 0.dp, 0.dp, 16.dp))
                    }
                    Row(modifier = Modifier) {
                        Image(painter = em, contentDescription = null)
                        Text(text = email, Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp))
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        HeaderCard(stringResource(R.string.full_name),
            stringResource(R.string.title),
            stringResource(R.string.phone),
            stringResource(R.string.ig_social), stringResource(R.string.email)
        )
    }
}