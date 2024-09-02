package br.unisanta.Dao

import br.unisanta.Model.Filmes

class FilmesDao {

    companion object {
        private val filmes = mutableListOf<Filmes>(
            Filmes("Bastardos Inglórios", "Quentin Tarantino"),
            Filmes("Interestelar", "Cristopher Nolan"),
            Filmes("O Poderoso Chefão", "Francis Ford Copolla"),
            Filmes("Clube da Luta", "David Fincher"),
            Filmes("E.T. ", "Steven Spilberg"),
            Filmes("Ilha do Medo", "Martin Scorsese")
        )
    }

    fun cadastraFilme(filme: Filmes) {
        Companion.filmes.add(filme)
    }

    fun obterLista(): List<Filmes> {
        return Companion.filmes
    }
}
