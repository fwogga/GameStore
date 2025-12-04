package pt.iade.ei.gamestore.views.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.model.Item
import pt.iade.ei.gamestore.model.ServidorFake
import pt.iade.ei.gamestore.ui.theme.GameStoreTheme

@Composable
fun Itemdaloja2(
    item: Item,
    onBuyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.name,
                modifier = Modifier.size(72.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$${String.format("%.2f", item.price)}",
                style = MaterialTheme.typography.titleMedium
            )

            Button(
                onClick = onBuyClick,
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "Buy with 1-click")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Itemdaloja2Preview() {
    val game = ServidorFake.getGames().first()
    val item = game.items.first()

    GameStoreTheme {
        Itemdaloja2(
            item = item,
            onBuyClick = {}
        )
    }
}
