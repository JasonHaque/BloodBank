package com.example.bloodbank.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bloodbank.Activities.RequstBlood
import com.example.bloodbank.R
import kotlinx.android.synthetic.main.activity_timeline_view.*

class TImelineView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline_view)
        bindListeners()
    }

    fun bindListeners(){
        Request_blood.setOnClickListener {
            val intent = Intent(this,RequstBlood::class.java)
            startActivity(intent)
        }
    }
}
