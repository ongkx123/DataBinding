package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //lateinit = late initialise
    private lateinit var binding: ActivityMainBinding
    //create an instance of the contact class
    private var mycontact: Contact = Contact("Yong","101010101")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.contact = mycontact

        binding.buttonDone.setOnClickListener(){
            updateName()
        }
    }

    fun updateName(){
        //apply = multiple setter on a single object

        binding.apply{
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextPhone.text.toString()
            this.invalidateAll()
        }
    }
}
