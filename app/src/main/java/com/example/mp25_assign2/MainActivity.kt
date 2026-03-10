package com.example.mp25_assign2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val hasil: TextView = findViewById(R.id.hasil)
        val hitungdiskon: Button = findViewById(R.id.hitungdiskon)
        val harganormal: EditText = findViewById(R.id.harganormal)
        val diskon: EditText = findViewById(R.id.diskon)

        hitungdiskon.setOnClickListener {

            val hargaAwalStr = harganormal.text.toString()
            val diskonStr = diskon.text.toString()

            val hargaAwal = hargaAwalStr.toDoubleOrNull()
            val diskonValue = diskonStr.toDoubleOrNull()

            if (hargaAwal == null || diskonValue == null) {
                hasil.setTextColor(getColor(R.color.red))
                hasil.text = "⚠️ Input harus berupa angka!"
            } else {
                val hargaSetelahDiskon = hargaAwal - (hargaAwal * diskonValue / 100)

                hasil.setTextColor(getColor(R.color.white))
                hasil.text = "Harga Setelah Diskon: Rp ${String.format("%.2f", hargaSetelahDiskon)}"
            }
        }
    }
}