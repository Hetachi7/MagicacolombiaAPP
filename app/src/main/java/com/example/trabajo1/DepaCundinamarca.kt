package com.example.trabajo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class DepaCundinamarca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depa_cundinamarca)

        val CardAmaOpen: CardView = findViewById(R.id.Amazonas1card)
        CardAmaOpen.setOnClickListener{
            val  myfragment1 = Historia1fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia1fragment::class.java.simpleName)
            if ( fragment !is Historia1fragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,myfragment1,Historia1fragment :: class.java.simpleName)
                    .commit()
            }
        }
        val CardOpen2: CardView = findViewById(R.id.Cundinamarca2card)
        CardOpen2.setOnClickListener{
            val  myfragment2 = Historia2fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia2fragment::class.java.simpleName)
            if ( fragment !is Historia2fragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,myfragment2,Historia2fragment :: class.java.simpleName)
                    .commit()
            }
        }
        val CardOpen3: CardView = findViewById(R.id.Cundinamarca3card)
        CardOpen3.setOnClickListener{
            val  myfragment3 = Historia3fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia3fragment::class.java.simpleName)
            if ( fragment !is Historia3fragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,myfragment3,Historia3fragment :: class.java.simpleName)
                    .commit()
            }
        }
        val CardOpen4: CardView = findViewById(R.id.Cundinamarca4card)
        CardOpen4.setOnClickListener{
            val  myfragment4 = Historia4fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia4fragment::class.java.simpleName)
            if ( fragment !is Historia4fragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,myfragment4,Historia4fragment :: class.java.simpleName)
                    .commit()
            }
        }

        val CardOpen5: CardView = findViewById(R.id.Cundinamarca5card)
        CardOpen5.setOnClickListener{
            val  myfragment5 = Historia5fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia5fragment::class.java.simpleName)
            if ( fragment !is Historia5fragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,myfragment5,Historia5fragment :: class.java.simpleName)
                    .commit()
            }
        }
        val CardOpen6: CardView = findViewById(R.id.Cundinamarca6card)
        CardOpen6.setOnClickListener{
            val  myfragment6 = Historia6fragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(Historia6fragment::class.java.simpleName)
            if ( fragment !is Historia6fragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,myfragment6,Historia6fragment :: class.java.simpleName)
                    .commit()
            }
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }
}