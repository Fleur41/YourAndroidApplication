package com.okumu.yourapplication

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
        //
        //val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.HelloAndroid)
        val inputField = findViewById<EditText>(R.id.enterName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)

        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""

        submitButton.setOnClickListener{
            var enteredName = inputField.text.toString()

            if(enteredName == ""){
                offersButton.visibility = INVISIBLE
                Toast.makeText(this@MainActivity,
                    "Please enter your name!",
                    Toast.LENGTH_SHORT).show()
            }
            else {
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()

                offersButton.visibility = VISIBLE
            }

            offersButton.setOnClickListener{
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("USER", enteredName)
                startActivity(intent)
            }

        }
    }
}

