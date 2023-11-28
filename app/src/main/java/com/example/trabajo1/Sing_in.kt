package com.example.trabajo1

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Sing_in : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        val emailEditText2 = findViewById<EditText>(R.id.email1)
        val passwordEditText2 = findViewById<EditText>(R.id.password2)
        val user = Firebase.auth.currentUser
        val Singintbtn2=findViewById <Button>(R.id.sing_in2)

        Singintbtn2.setOnClickListener(viewListener)

        val Cuentabtn=findViewById <TextView>(R.id.cuenta1)
        Cuentabtn.setOnClickListener(viewListener)
       }
    fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            // El usuario está autenticado, redirige a la actividad principal
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }else {
            // La autenticación ha fallado, realiza acciones para un fallo de inicio de sesión
            Log.w(TAG, "Authentication failed")
            Toast.makeText(
                applicationContext,
                "Authentication failed.",
                Toast.LENGTH_SHORT
            ).show()
            // El usuario está autenticado, realiza acciones para un inicio de sesión exitoso
        }
        // Si el usuario es null, puedes realizar otras acciones según tus necesidades
    }



    fun entraruser(emailEditText2: EditText, passwordEditText2: EditText){

        val email =emailEditText2.text.toString()
        val password = passwordEditText2.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    updateUI(null)
                }
            }
    }
      fun enviarhome(){
        val intent: Intent = Intent ( this,Home::class.java)
        startActivity(intent)
      }
  fun enviarLogin(){
      val intent:Intent=Intent(this,Login::class.java)
      startActivity(intent)
  }
      private val viewListener = View.OnClickListener {
        when(it.id){
            R.id.sing_in2->enviarhome()
            R.id.cuenta1->enviarLogin()
        }
      }
    }
