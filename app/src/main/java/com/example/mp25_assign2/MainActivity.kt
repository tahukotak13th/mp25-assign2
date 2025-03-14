package com.example.mp25_assign2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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

            if (hargaAwalStr.isEmpty() || diskonStr.isEmpty()) {
                hasil.setTextColor(getColor(R.color.red))
                hasil.text = "⚠️ Harap isi semua kolom!"
            } else {
                val hargaAwal = hargaAwalStr.toDouble()
                val diskon = diskonStr.toDouble()

                val hargaSetelahDiskon = hargaAwal - (hargaAwal * diskon / 100)

                hasil.setTextColor(getColor(R.color.black))
                hasil.text = "Harga Setelah Diskon: Rp${String.format("%.2f", hargaSetelahDiskon)}"
            }
        }
    }
}