package com.example.trabajo1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
class Historias : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historias)


        val Historia1card = findViewById<CardView>(R.id.Historia1card)
        Historia1card.setOnClickListener {
            val intent = Intent(this@Historias, Historia1fragment::class.java)
            startActivity(intent)
        }
       /* val Historia2card = findViewById<CardView>(R.id.Historia2.




        card)
        Historia2card.setOnClickListener {
            val intent2 = Intent(this@Historias, Historia2fragment::class.java)
            startActivity(intent2)
        }*/
        val Historia3card = findViewById<CardView>(R.id.Historia3card)
        Historia3card.setOnClickListener {
            val intent3 = Intent(this@Historias, Historia3fragment::class.java)
            startActivity(intent3)
        }
        val Historia4card = findViewById<CardView>(R.id.Historia4card)
        Historia4card.setOnClickListener {
            val intent4 = Intent(this@Historias, Historia4fragment::class.java)
            startActivity(intent4)
        }
        val Historia5card = findViewById<CardView>(R.id.Historia5card)
        Historia5card.setOnClickListener {
            val intent5 = Intent(this@Historias, Historia5fragment::class.java)
            startActivity(intent5)
        }
        /*val Historia6card = findViewById<CardView>(R.id.Historia6card)
        Historia6card.setOnClickListener {
            val intent6 = Intent(this@Historias, Historia6fragment::class.java)
            startActivity(intent6)
        }*/

        val Historia6Card = findViewById<CardView>(R.id.Historia6card)
        Historia6Card.setOnClickListener( object : View.OnClickListener{
            override fun onClick(v: View?) {
                supportFragmentManager.beginTransaction().replace(R.id.Historia6card,Historia6fragment()).commit()
            }
        })
    }
}