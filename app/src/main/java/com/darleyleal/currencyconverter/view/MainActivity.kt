package com.darleyleal.currencyconverter.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.darleyleal.currencyconverter.R
import com.darleyleal.currencyconverter.databinding.ActivityMainBinding
import com.darleyleal.currencyconverter.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    private var resultado: Float = 0.0f
    private var valor: Float = 0.0f

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.imageEuro.setOnClickListener {
            valor = binding.editValor.text.toString().toFloat()

            resultado = viewModel.calcularEuro(valor).toString().toFloat()
            binding.textResultado.text = "Valor convertido de Real para Euro: $" + "%.2f".format(resultado)
            binding.editValor.text.clear()
        }
        binding.imageDollar.setOnClickListener {
            valor = binding.editValor.text.toString().toFloat()

            resultado = viewModel.calcularDolar(valor).toString().toFloat()
            binding.textResultado.text = "Valor convertido de Real para Dólar: $" + "%.2f".format(resultado)
            binding.editValor.text.clear()
        }
    }
}