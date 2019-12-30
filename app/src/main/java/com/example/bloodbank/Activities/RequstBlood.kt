package com.example.bloodbank.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bloodbank.R
import kotlinx.android.synthetic.main.activity_requst_blood.*

class RequstBlood : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requst_blood)
        bindListeners()
    }
    fun bindListeners(){
        submit_request.setOnClickListener {
            //TODO: add a new listener
        }
    }
}
