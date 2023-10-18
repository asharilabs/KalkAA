package com.example.kalkulatoraa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // 1
    override fun onCreate(savedInstanceState: Bundle?) {

        var pilihan = 0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region Inisialisasi Widget
        // 1. edt 1
        var gEdt1 = findViewById<EditText>(R.id.edt_bil1)
        // 2. edt 2
        var gEdt2 = findViewById<EditText>(R.id.edt_bil2)
        // 3. spinner
        var gSpin = findViewById<Spinner>(R.id.myspinner)
        // 4. button
        var gBtnCal = findViewById<Button>(R.id.btn_calculate)
        // 5. textview
        var gTvHasil = findViewById<TextView>(R.id.tv_hasil)
        //endregion

        //region Definisi Button Click
        gBtnCal.setOnClickListener {
            // 3
            var nilai1 = gEdt1.text.toString().toDouble()
            var nilai2 = gEdt2.text.toString().toDouble()
            var hasil = 0.0

            Log.d("galih", "nilai1: " + nilai1 +
            ", nilai2: " + nilai2)

            if(pilihan.equals(0)){ // tambah
                hasil = nilai1 + nilai2
            }
            else if( pilihan.equals(1)){
                hasil = nilai1 - nilai2
            }
            else if( pilihan.equals(2)){
                hasil = nilai1 * nilai2
            }
            else if( pilihan.equals(3)){
                hasil = nilai1/nilai2
            }

            gTvHasil.text = hasil.toString()

        }
        //endregion

        gSpin.setOnItemSelectedListener(
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    Log.d("galih", "pilih item: " + p2)
                    pilihan = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            })
    }
}