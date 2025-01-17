package com.example.project_umbrella.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.project_umbrella.R

@Composable
fun NavBar (
    navigateToHome: () -> Unit = {},
    currentScreen: String,
    navigateToInventory: () -> Unit = {},
    navigateToGraphs: () -> Unit = {},
    navigateToSettings: () -> Unit = {}
) {
    val nav_items = listOf(
    NavigationItem(label = "Home", int = R.drawable.home, iconClicked = Icons.Filled.Home, navigateTo = navigateToHome),
    NavigationItem(label = "Inventory", int = R.drawable.folder, iconClicked = Icons.Filled.AccountBox, navigateTo = navigateToInventory),
    NavigationItem(label = "Notifications", int = R.drawable.barchart, iconClicked = Icons.Filled.MailOutline, navigateTo = navigateToGraphs),
    NavigationItem(label = "Settings", int = R.drawable.settings, iconClicked = Icons.Filled.Settings, navigateTo = navigateToSettings)
)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.07f)
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxHeight(),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(
                contentColor = Color.Unspecified,
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                nav_items.forEachIndexed { _, item ->
                    Icon(
                        imageVector = ImageVector.vectorResource(item.int),
                        tint = Color(0xffc4c4c4),
                        contentDescription = item.label,
                        modifier = Modifier
                            .clickable {
                                item.navigateTo()
                            }
                    )
                }
            }
        }
    }
}

data class NavigationItem(
    val label:String,
    val int: Int,
    val iconClicked: ImageVector,
    val navigateTo: () -> Unit
)