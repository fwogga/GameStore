package pt.iade.ei.gamestore.model

import java.io.Serializable

data class jogo(
    val id: String,
    val name: String,
    val description: String,
    val imageResId: Int,
    val items: List<Item>
) : Serializable
