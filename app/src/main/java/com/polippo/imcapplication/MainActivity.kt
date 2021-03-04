package com.polippo.imcapplication

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setListeners(){

        calcularButton?.setOnClickListener {
            calcularIMC(pesoEdit.text.toString(), alturaEdit.text.toString())
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun calcularIMC(peso:String, altura:String){

        if((peso.isEmpty() || peso.isBlank()) && (altura.isEmpty() || altura.isBlank())){
            Snackbar.make(findViewById(R.id.coordinatorLayout), getString(R.string.snackbar_text), Snackbar.LENGTH_SHORT).show()
        } else {

            val pesoFloat = peso.toFloatOrNull()
            val alturaFloat = altura.toFloatOrNull()


            if (pesoFloat != null && alturaFloat != null) {
                val imc = pesoFloat / (alturaFloat * alturaFloat)
                resultImcTxt.text = getString(R.string.imc_result).format(imc)

                when {
                    imc < 18.5 -> {
                        resultTxt.text = getString(R.string.abaixo_peso)
                        resultTxt.setTextColor(Color.RED)
                        resultImcTxt.setTextColor(getColor(R.color.ic_launcher_background))
                    }
                    imc <= 24.9 -> {
                        resultTxt.text = getString(R.string.peso_normal)
                        resultTxt.setTextColor(Color.GREEN)
                        resultImcTxt.setTextColor(getColor(R.color.ic_launcher_background))
                    }
                    imc <= 29.9 -> {
                        resultTxt.text = getString(R.string.sobrepeso)
                        resultTxt.setTextColor(Color.YELLOW)
                        resultImcTxt.setTextColor(getColor(R.color.ic_launcher_background))
                    }
                    imc <= 34.9 -> {
                        resultTxt.text = getString(R.string.obesidade_1)
                        resultTxt.setTextColor(Color.RED)
                        resultImcTxt.setTextColor(getColor(R.color.ic_launcher_background))
                    }
                    imc <= 39.9 -> {
                        resultTxt.text = getString(R.string.obesidade_2)
                        resultTxt.setTextColor(Color.RED)
                        resultImcTxt.setTextColor(getColor(R.color.ic_launcher_background))
                    }
                    else -> {
                        resultTxt.text = getString(R.string.obesidade_morbida)
                        resultTxt.setTextColor(Color.RED)
                        resultImcTxt.setTextColor(Color.RED)
                    }
                }
            }
        }

    }


}