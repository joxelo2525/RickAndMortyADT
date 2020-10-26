package com.apolis.adtrick.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apolis.adtrick.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = RickAndMortyFragment()
        val manager = supportFragmentManager
        manager.beginTransaction().add(R.id.fragment_holder, fragment).commit()
    }
}