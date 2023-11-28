package com.example.trabajo1

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)

        createUserFromEditText(emailEditText, passwordEditText)

        val user = Firebase.auth.currentUser

        val logintbtn2= findViewById <Button>(R.id.login2)

        logintbtn2.setOnClickListener(viewListener)

        val Recuperarbtn=findViewById<TextView>(R.id.Recuperar)

        Recuperarbtn.setOnClickListener(viewListener)

        val Crearbtn=findViewById <TextView>(R.id.Crear)

        auth = Firebase.auth




        Crearbtn.setOnClickListener(viewListener)
        user!!.sendEmailVerification()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Email sent.")
                }
            }




    }
    fun reload(){
        val user = FirebaseAuth.getInstance().currentUser
        user?.reload()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // La recarga fue exitosa, puedes acceder a la información actualizada del usuario
                val updatedUser = FirebaseAuth.getInstance().currentUser
                // Realiza acciones con el usuario actualizado
            } else {
                // La recarga falló, maneja la situación
            }
        }
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
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }
    fun createUserFromEditText(emailEditText: EditText, passwordEditText: EditText) {
        val email =emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registro exitoso, actualiza la interfaz de usuario con la información del usuario registrado
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // Si el registro falla, muestra un mensaje al usuario.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        applicationContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }



    fun erroruser(){
        val user = Firebase.auth.currentUser
     user?.let {
        // Name, email address, and profile photo Url
        val name = it.displayName
        val email = it.email
        val photoUrl = it.photoUrl

        // Check if user's email is verified
        val emailVerified = it.isEmailVerified

        // The user's ID, unique to the Firebase project. Do NOT use this value to
        // authenticate with your backend server, if you have one. Use
        // FirebaseUser.getIdToken() instead.
        val uid = it.uid
        }
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


