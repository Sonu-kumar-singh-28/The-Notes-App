package com.ssu.xyvento.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.ssu.xyvento.notesapp.databinding.ActivityLoginPageBinding

class Login_Page_Activity : AppCompatActivity() {
    private val binding: ActivityLoginPageBinding by lazy {
        ActivityLoginPageBinding.inflate(layoutInflater)
    }

    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.registerbutttonloginpage.setOnClickListener {
            startActivity(Intent(this, Register_User_Activity::class.java))
            finish()
        }

        auth = FirebaseAuth.getInstance()

        binding.forgetpassword.setOnClickListener {
            startActivity(Intent(this, Forget_Passwordf_Activity::class.java))
            finish()
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailtextfield.text.toString()
            val password = binding.passwodinputfield.text.toString()

            if(email.isEmpty() ||password.isEmpty()){
                Toast.makeText(this, "Please Fill all textField", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener {
                        task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Login SuccessFull", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, notesactivity_Activity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this, "Error${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}
