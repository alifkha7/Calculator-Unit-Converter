package com.alkhademy.calculatorunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alkhademy.task3.ConverterFragment
import com.alkhademy.task3.VolumeFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragmentArea = AreaFragment()
        val area: Button = findViewById(R.id.area)
        area.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragmentArea).commit()
        }

        val fragmentVolume = VolumeFragment()
        val volume: Button = findViewById(R.id.volume)
        volume.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragmentVolume).commit()
        }

        val fragmentConverter = ConverterFragment()
        val converter: Button = findViewById(R.id.converter)
        converter.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragmentConverter).commit()
        }
    }
}