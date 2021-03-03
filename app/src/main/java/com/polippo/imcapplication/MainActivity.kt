package com.polippo.imcapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){

        calcularButton?.setOnClickListener {
            calcularIMC(pesoEdit.text.toString(), alturaEdit.text.toString())
        }
    }

    private fun calcularIMC(peso:String, altura:String){

        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso != null && altura != null){
            val imc = peso/ (altura * altura)
            titleTxt.text = "Seu IMC é %.2f".format(imc)
        }

    }


}