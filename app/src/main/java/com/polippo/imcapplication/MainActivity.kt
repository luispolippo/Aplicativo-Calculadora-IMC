package com.polippo.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecycle", "entrei no CREATE - estou criando a tela")
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "entrei no START - deixei a tela visivel")
    }

    override fun onResume(){
        super.onResume()
        Log.w("lifecycle", "entrei no RESUME - agora você pode interagir com a tela")
    }

    override fun onPause(){
        super.onPause()
        Log.w("lifecycle", "PAUSE - A tela perdeu o foco, você não pode interagir")
    }

    override fun onStop(){
        super.onStop()
        Log.w("lifecycle", "STOP - A tela não está mais visivel mas ainda existe")
    }

    override fun onRestart(){
        super.onRestart()
        Log.w("lifecycle", "entrei no RESTART - A tela está retornando ao foco")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.w("lifecycle", "entrei no DESTROY - A tela foi destruida")
    }


}