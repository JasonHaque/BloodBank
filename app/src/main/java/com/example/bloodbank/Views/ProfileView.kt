package com.example.bloodbank.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bloodbank.Activities.LogInActivity
import com.example.bloodbank.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile_view.*

class ProfileView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)
        bindListeners()
    }

    fun bindListeners(){
        log_out.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
        go_to_timeline.setOnClickListener {
            val intent = Intent(this,TImelineView::class.java)
            startActivity(intent)
        }
    }
}
