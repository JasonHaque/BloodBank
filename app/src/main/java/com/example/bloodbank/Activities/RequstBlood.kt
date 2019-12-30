package com.example.bloodbank.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bloodbank.R
import kotlinx.android.synthetic.main.activity_requst_blood.*

class RequstBlood : AppCompatActivity() {

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
