package com.example.bloodbank.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bloodbank.R
import kotlinx.android.synthetic.main.activity_additional_data.*

class AdditionalData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additional_data)
        bindWidgets()
    }
    fun bindWidgets(){
        save_info.setOnClickListener {
            val firstName = first_name.text.toString()
            val lastName =  last_name.text.toString()
            val ageData = age.text.toString()
            val contactData = phone_number.text.toString()
            val error = validateInputs(firstName,lastName,ageData,contactData)
            if (error != ""){
                Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    fun validateInputs(firstName:String,lastName:String,ageData:String,contact:String):String{
        if(firstName.isEmpty() || lastName.isEmpty() || ageData.isEmpty() || contact.isEmpty()){
            return "Fill up the fields dude"
        }
        return ""
    }
}
