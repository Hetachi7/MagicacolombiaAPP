package com.example.trabajo1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class Historias : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener { private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historias)
        // Configuración del DrawerLayout y Toolbar

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        /*val departamenbtn:Button = findViewById<Button>(R.id.hitoriasm)
        departamenbtn.setOnClickListener (viewListener)*/

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Homefragment()).commit()
            navigationView.setCheckedItem(R.id.home)
        }
        val CardOpen: CardView = findViewById(R.id.Historia1card)
        CardOpen.setOnClickListener {
            val myfragment1 = Historia1fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia1fragment::class.java.simpleName)
            if (fragment !is Historia1fragment) {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.fragment_container2,
                        myfragment1,
                        Historia1fragment::class.java.simpleName
                    )
                    .commit()

            }
        }
        val CardOpen2: CardView = findViewById(R.id.Historia2card)
        CardOpen2.setOnClickListener {
            val myfragment2 = Historia2fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia2fragment::class.java.simpleName)
            if (fragment !is Historia2fragment) {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.fragment_container,
                        myfragment2,
                        Historia2fragment::class.java.simpleName
                    )
                    .commit()
            }
        }
        val CardOpen3: CardView = findViewById(R.id.Historia3card)
        CardOpen3.setOnClickListener {
            val myfragment3 = Historia3fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia3fragment::class.java.simpleName)
            if (fragment !is Historia3fragment) {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.fragment_container,
                        myfragment3,
                        Historia3fragment::class.java.simpleName
                    )
                    .commit()
            }
        }
        val CardOpen4: CardView = findViewById(R.id.Historia4card)
        CardOpen4.setOnClickListener {
            val myfragment4 = Historia4fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia4fragment::class.java.simpleName)
            if (fragment !is Historia4fragment) {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.fragment_container,
                        myfragment4,
                        Historia4fragment::class.java.simpleName
                    )
                    .commit()
            }
        }

        val CardOpen5: CardView = findViewById(R.id.Historia5card)
        CardOpen5.setOnClickListener {
            val myfragment5 = Historia5fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia5fragment::class.java.simpleName)
            if (fragment !is Historia5fragment) {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.fragment_container,
                        myfragment5,
                        Historia5fragment::class.java.simpleName
                    )
                    .commit()
            }
        }
        val CardOpen6: CardView = findViewById(R.id.Historia6card)
        CardOpen6.setOnClickListener {
            val myfragment6 = Historia6fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia6fragment::class.java.simpleName)
            if (fragment !is Historia6fragment) {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.fragment_container,
                        myfragment6,
                        Historia6fragment::class.java.simpleName
                    )
                    .commit()
            }
        }


    }


    fun enivarhistorias() {
        val intent: Intent = Intent(this, Historias::class.java)
        startActivity(intent)
    }

    fun enviarsubir() {
        val intent: Intent = Intent(this, SubirHistoria::class.java)
        startActivity(intent)
    }

    fun enviarreport() {
        val intent: Intent = Intent(this, ReportarError::class.java)
        startActivity(intent)
    }

    private val viewListener = View.OnClickListener {
        when (it.id) {
            R.id.hitoriasm -> enivarhistorias()
            R.id.Subir -> enviarsubir()
            R.id.message -> enviarreport()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Homefragment()).commit()

            R.id.perfil -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Perfilfragment()).commit()

            R.id.salir -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
            R.id.hitoriasm -> {
                val intent = Intent(this, Historias::class.java)
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








