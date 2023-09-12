package com.example.trabajo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logintbtn: Button = findViewById(R.id.login)

        logintbtn.setOnClickListener(viewListener)

        val  singbtn : Button = findViewById (R.id.sing_in)
        singbtn.setOnClickListener (viewListener)

     }


        fun enviarLogin(){
            val intent: Intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
        fun enviarSingin(){
            val intent: Intent = Intent(this,Sing_in::class.java)
            startActivity(intent)
        }

        private val  viewListener =View.OnClickListener{
            when (it.id){
                R.id.login->enviarLogin()
                R.id.sing_in->enviarSingin()
            }
        }

    }