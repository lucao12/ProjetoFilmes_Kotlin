package br.unisanta.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.Dao.FilmesDao
import br.unisanta.Model.Filmes
import br.unisanta.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    val dao = FilmesDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCadastra = findViewById<Button>(R.id.btnCadastra)
        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtDiretor = findViewById<EditText>(R.id.edtDiretor)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        btnCadastra.setOnClickListener {
            val filme = Filmes(edtTitulo.text.toString(), edtDiretor.text.toString())
            dao.cadastraFilme(filme)
            Toast.makeText(this, "Filme cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            edtTitulo.text.clear()
            edtDiretor.text.clear()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
