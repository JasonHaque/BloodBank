package com.example.bloodbank.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.bloodbank.Classes.UserData
import com.example.bloodbank.R
import com.example.bloodbank.Views.ProfileView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_additional_data.*

class AdditionalData : AppCompatActivity() {
    private var db = FirebaseDatabase.getInstance().reference
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
            val bg = findViewById<RadioButton>(bloodGroup.checkedRadioButtonId).text.toString()
            print(bg)
            val data:UserData = UserData(firstName,lastName,ageData.toInt(),contactData,bg)
            db.child("Users").child(FirebaseAuth.getInstance().currentUser?.uid.toString())
                .child("Data").setValue(data).addOnSuccessListener {
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,ProfileView::class.java))
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
