package pt.iade.ei.gamestore.model

import pt.iade.ei.gamestore.R

object ServidorFake {

    val jogos:List<jogo> by lazy{
        listOf(
            jogo(
                id = "j1",
                name = "Guilty Gear: Strive",
                description = "Vive a emoção da batalha com as mecânicas cheias de opções e " +
                        "animações lindíssimas de Guilty Gear -Strive-, o título mais " +
                        "recente da sempre inovadora série Guilty Gear!",
                imageResId = R.drawable.strive,
                items = listOf(
                    Item(
                        id = "i1",
                        name = "A.B.A",
                        description = "Adiciona A.B.A ao elenco de personagens jogáveis. Um homúnculo nascido" +
                                " em um laboratório chamado Frasco." +
                                "Ela deu o nome de Paracelso a um machado que se assemelha muito a " +
                                "uma chave e o trata como seu marido.",
                        price = 6.99,
                        imageResId = R.drawable.aba
                    ),
                    Item(
                        id = "i2",
                        name = "Testament",
                        description = "Permite-te usar Testament no jogo.Testament já foi humano," + " antes de ser cirurgicamente modificado para se tornar um Gear." +
                                "Após os eventos do Segundo Torneio de Seleção da Ordem Sagrada," + " no entanto, ele recuperou a consciência de si mesmo..",
                        price = 6.99,
                        imageResId = R.drawable.testament
                    ),
                    Item(
                        id = "i3",
                        name = "Slayer",
                        description = "Adiciona Slayer ao elenco de personagens jogáveis. Um cavalheiro descendente de linhagem vampírica, que aprecia o combate genuíno e o haicai como passatempos.\n" +
                                "Ele segue seu próprio código de \"dandismo\" e consegue " +
                                "lidar com quase tudo com tranquilidade.",
                        price = 6.99,
                        imageResId = R.drawable.slayer
                    ),
                )
            ),
            jogo(
                id = "j2",
                name = "Dead Cells",
                description = "Dead Cells coloca você no meio de um experimento alquímico que falhou," +
                        " onde você deve descobrir o que está acontecendo em uma ilha extensa, " +
                        "mutável e aparentemente amaldiçoada. " +
                        "Combates difíceis mas justos, controles sensíveis," +
                        " inimigos desafiadores, morte permanente",
                imageResId = R.drawable.deadcells,
                items = listOf(
                    Item(
                        id = "i4",
                        name = "The Bad Seed",
                        description = "Explore um Arboretum relaxante, cruze um pântano tóxico e" +
                                " enfrente um novo chefe neste conteúdo do jogo" +
                                " concebido para expandir o universo de Dead Cells.",
                        price = 4.99,
                        imageResId = R.drawable.badseed
                    ),
                    Item(
                        id = "i5",
                        name = "Fatal Falls",
                        description = "Enfrente dois novos níveis e um chefe enquanto escapa de armadilhas e inimigos." +
                                "Tente não cair enquanto desbrava os enormes desfiladeiros do litoral da ilha. " +
                                "Explore altares flutuantes, infiltre-se no esconderijo de uma sociedade secreta" +
                                " proibida e descubra tudo sobre um novo chefe. ",
                        price = 4.99,
                        imageResId = R.drawable.fatalfalls
                    ),
                    Item(
                        id = "i6",
                        name = "The Queen and the Sea",
                        description = "Batalhe pelos barcos afundados, galgue um farol em chamas e " +
                                "confronte o inimigo mais letal de todos. Se você fizer tudo isso," +
                                " talvez consiga finalmente sair dessa ilha maldita..."+
                                "Este conteúdo de fim de jogo oferece alternativas para os " +
                                "biomas Castelo Pinacular, Destilaria Abandonada e Sala do Trono.",
                        price = 4.99,
                        imageResId = R.drawable.queenandsea
                    )
                )
            )
        )
    }

    fun getGames():List<jogo> = jogos
}
