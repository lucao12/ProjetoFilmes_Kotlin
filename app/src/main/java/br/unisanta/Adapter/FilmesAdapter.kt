package br.unisanta.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.Model.Filmes
import br.unisanta.R

class FilmesAdapter(private val filmes: List<Filmes>): RecyclerView.Adapter<FilmesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtTitulo = itemView.findViewById<TextView>(R.id.txt_Titulo)
        val txtDiretor = itemView.findViewById<TextView>(R.id.txt_Diretor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.txtTitulo.text = filme.titulo
        holder.txtDiretor.text = filme.diretor
    }
}
