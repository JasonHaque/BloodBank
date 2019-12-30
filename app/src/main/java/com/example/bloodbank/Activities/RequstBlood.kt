package com.example.bloodbank.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bloodbank.Classes.EmergencyBlood
import com.example.bloodbank.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_requst_blood.*

class RequstBlood : AppCompatActivity() {

    private var db = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requst_blood)
        bindListeners()
    }
    private fun bindListeners(){
        submit_request.setOnClickListener {
            val error =validateInputs()
            if (error != ""){
                Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val bloodgroup = requesting_blood_group.text.toString()
            val location = requesting_location.text.toString()
            val time = requesting_time.text.toString()
            val amount = amount_of_blood.text.toString()

            val bloodData = EmergencyBlood(bloodgroup,location,time, amount)
            db.child("EmergencyBlood").child("Need")
                .child(FirebaseAuth.getInstance()
                    .currentUser?.uid.toString()).setValue(bloodData)
                .addOnSuccessListener {
                    Toast.makeText(this,"Success Creating Emergency",Toast.LENGTH_SHORT).show()
                }

        }
    }
    private fun validateInputs():String{
        val bloodgroup = requesting_blood_group.text.toString()
        val location = requesting_location.text.toString()
        val time = requesting_time.text.toString()
        val amount = amount_of_blood.text.toString()

        if (bloodgroup.isEmpty() || location.isEmpty() || time.isEmpty() || amount.isEmpty()){
            return "Fill up the fields"
        }

        return ""
    }
}
