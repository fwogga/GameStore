package pt.iade.ei.gamestore.controller

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.model.ServidorFake
import pt.iade.ei.gamestore.model.jogo
import pt.iade.ei.gamestore.views.componentes.GameCard
import pt.iade.ei.gamestore.ui.theme.GameStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val games = ServidorFake.getGames()

        setContent {
            GameStoreTheme {
                GameStoreHome(
                    games = games,
                    onGameClick = { game ->
                        val intent = Intent(this, GameDetailActivity::class.java)
                        intent.putExtra("game", game)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameStoreHome(
    games: List<jogo>,
    onGameClick: (jogo) -> Unit
) {
    var selectedBottomItem by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Evil Store")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
                }
            )
        }
        ,
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedBottomItem == 0,
                    onClick = { selectedBottomItem = 0 },
                    icon = { Icon(Icons.Default.Star, contentDescription = "Featured") },
                    label = { Text("Featured") }
                )
                NavigationBarItem(
                    selected = selectedBottomItem == 1,
                    onClick = { selectedBottomItem = 1 },
                    icon = {Icon(
                        painter = painterResource(id = R.drawable.ic_action_name),
                        contentDescription = "History",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                    },
                    label = { Text("History") }
                )
                NavigationBarItem(
                    selected = selectedBottomItem == 2,
                    onClick = { selectedBottomItem = 2 },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") }
                )
            }
        }
    ) { paddingValues ->
        GameListContent(
            games = games,
            onGameClick = onGameClick,
            paddingValues = paddingValues
        )
    }
}

@Composable
private fun GameListContent(
    games: List<jogo>,
    onGameClick: (jogo) -> Unit,
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = paddingValues.calculateTopPadding() + 8.dp,
            bottom = paddingValues.calculateBottomPadding() + 8.dp,
            start = 16.dp,
            end = 16.dp
        )
    ) {
        items(games) { game ->
            GameCard(
                game = game,
                onClick = { onGameClick(game) }
            )
        }
    }
}
