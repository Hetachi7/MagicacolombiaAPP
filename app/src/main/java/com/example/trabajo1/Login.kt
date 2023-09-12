package com.example.trabajo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class Login : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val logintbtn2= findViewById <Button>(R.id.login2)

        logintbtn2.setOnClickListener(viewListener)

        val Recuperarbtn=findViewById<TextView>(R.id.Recuperar)

        Recuperarbtn.setOnClickListener(viewListener)

        val Crearbtn=findViewById <TextView>(R.id.Crear)

        Crearbtn.setOnClickListener(viewListener)

    }

    fun enviarhome(){
        val intent:Intent= Intent ( this,Home::class.java)
      startActivity(intent)
    }
    fun enviarRecuperar(){
        val intent:Intent=Intent(this,Recuperar::class.java)
        startActivity(intent)
    }
    fun enviarSing_in(){
        val intent:Intent=Intent(this,Sing_in::class.java)
        startActivity(intent)
    }

    private val viewListener = View.OnClickListener {
        when(it.id){
            R.id.login2->enviarhome()
            R.id.Recuperar->enviarRecuperar()
            R.id.Crear->enviarSing_in()
        }
    }
}