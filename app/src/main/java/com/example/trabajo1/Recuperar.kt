package com.example.trabajo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Recuperar : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener { private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        /*val departamenbtn:Button = findViewById<Button>(R.id.hitoriasm)
        departamenbtn.setOnClickListener (viewListener)*/

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,Homefragment()).commit()
            navigationView.setCheckedItem(R.id.home)
        }
    }

    fun enivarhistorias(){
        val intent: Intent = Intent( this,Historias::class.java)
        startActivity(intent)
    }
    fun enviarsubir(){
        val intent: Intent = Intent(this,SubirHistoria::class.java)
        startActivity(intent)
    }
    fun enviarreport(){
        val intent: Intent = Intent( this,ReportarError::class.java)
        startActivity(intent)
    }

    private val viewListener = View.OnClickListener{
        when(it.id){
            R.id.hitoriasm->enivarhistorias()
            R.id.Subir->enviarsubir()
            R.id.message->enviarreport()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home-> supportFragmentManager.beginTransaction() .replace(R.id.fragment_container, Homefragment()).commit()
            R.id.perfil -> supportFragmentManager.beginTransaction() .replace(R.id.fragment_container, Perfilfragment()).commit()
            R.id.salir -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
            R.id.hitoriasm->{
                val intent  =  Intent(this,Historias::class.java)
                startActivity(intent)
                return true
                Toast.makeText(this, "Android Menu is Clicked", Toast.LENGTH_LONG).show()
            }


        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}