package com.example.aula04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import com.example.aula04.databinding.ActivityTemperaturaBinding
//import kotlinx.android.synthetic.main.activity_temperatura.*

class TemperaturaActivity : AppCompatActivity() {

    lateinit var binding : ActivityTemperaturaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val valorCelsius: EditText = findViewById(R.id.valorCelsius)
//        val grupoTemperatura: RadioGroup = findViewById(R.id.grupoTemperatura)
//        val textResultado: TextView = findViewById(R.id.textResultado)
//        val buttonCalcular: Button = findViewById(R.id.buttonCalcular)

        binding.buttonCalcular.setOnClickListener {
            if (binding.valorCelsius.text.isNotEmpty()) {
                val valor = binding.valorCelsius.text.toString().toFloat()

                when (binding.grupoTemperatura.checkedRadioButtonId) {
                    R.id.radioKelvin -> {
                        val resultado = valor + 273
                        binding.textResultado.setText(resultado.toString())
                    }
                    R.id.radioFahrenheit -> {
                        val resultado = valor * 1.8 + 32
                        binding.textResultado.setText(resultado.toString())
                    }
                    else -> {
                        binding.textResultado.setText("Selecione uma temperatura")
                    }
                }
            } else {
                binding.textResultado.setText("Digite uma temperatura em Celsius")
            }
        }

    }
}
