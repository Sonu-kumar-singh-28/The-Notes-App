package com.ssu.xyvento.notesapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class notesactivity_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notesactivity)

        val notesActivity = findViewById<FloatingActionButton>(R.id.floatingactionbutton)

        notesActivity.setOnClickListener {
            startActivity(Intent(this, Create_Notes_Activity::class.java))
            finish()
        }
        
    }
}