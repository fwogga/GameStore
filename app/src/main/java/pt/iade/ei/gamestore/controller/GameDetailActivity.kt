package pt.iade.ei.gamestore.controller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import pt.iade.ei.gamestore.model.Item
import pt.iade.ei.gamestore.model.ServidorFake
import pt.iade.ei.gamestore.model.jogo
import pt.iade.ei.gamestore.views.componentes.Itemdaloja
import pt.iade.ei.gamestore.views.componentes.Itemdaloja2
import pt.iade.ei.gamestore.ui.theme.GameStoreTheme

class GameDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = intent.getSerializableExtra("game") as? jogo
            ?: error("Game not found in Intent")

        setContent {
            GameStoreTheme {
                GameDetailScreen(
                    game = game,
                    onBackClick = {finish()}
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(
    game: jogo,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    var selectedItem by remember {mutableStateOf<Item?>(null)}
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = game.name)},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Image(
                            painter = painterResource(id = game.imageResId),
                            contentDescription = game.name,
                            modifier = Modifier
                                .size(140.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = game.name,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = game.description,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Purchasable Items",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }


                items(game.items){item ->
                    Itemdaloja(
                        item = item,
                        onClick = {
                            selectedItem = item
                            scope.launch { sheetState.show() }
                        }
                    )
                }

                item { Spacer(modifier = Modifier.height(16.dp)) }
            }

            if (selectedItem != null && sheetState.isVisible) {
                ModalBottomSheet(
                    onDismissRequest = {
                        scope.launch { sheetState.hide() }
                    },
                    sheetState = sheetState
                ) {
                    Itemdaloja2(
                        item = selectedItem!!,
                        onBuyClick = {
                            scope.launch {
                                sheetState.hide()
                                val item = selectedItem!!
                                Toast.makeText(
                                    context,
                                    "Acabou de comprar o item ${item.name} por $${String.format("%.2f", item.price)}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameDetailScreenPreview() {
    val game = ServidorFake.getGames().first()

    GameStoreTheme {
        GameDetailScreen(
            game = game,
            onBackClick = {}
        )
    }
}
