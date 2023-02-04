package com.room.ps.lifecycleawaredemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var model: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        data = MainActivityDataGenerator()
        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val myRandomNumber = model.getNumber()
        val tvNumber = findViewById<TextView>(R.id.tvNumber)
        

        //Updating the ui with Livedata
        myRandomNumber.observe(this, Observer<String> { number ->
            tvNumber.text = number
            Log.i(TAG, "Random Number set")
        })

        val bRandom = findViewById<Button>(R.id.bRandom)
        bRandom.setOnClickListener{
            model.createNumber()
        }
    }

    companion object{
        private val TAG : String = MainActivity::class.java.simpleName
    }
}
