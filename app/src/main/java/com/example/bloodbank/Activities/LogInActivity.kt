package com.example.bloodbank.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bloodbank.R
import com.example.bloodbank.Views.ProfileView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bindListeners()
        checkUSerStatus()
    }
    private fun bindListeners(){
        go_to_signup.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        login_button.setOnClickListener {
            val error =validateInputs()
            if(error){
                Toast.makeText(this,"Fill up the fields properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val mail = login_mail.text.toString()
            val pass = login_password.text.toString()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(mail,pass).addOnSuccessListener {
                Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,ProfileView::class.java)
                startActivity(intent)
            }

        }
    }
    private fun validateInputs():Boolean{
        if(login_mail.text.toString().isEmpty() || login_password.text.toString().isEmpty()){
            return true
        }
        return false
    }
    private fun checkUSerStatus(){
        if(FirebaseAuth.getInstance().currentUser != null){
            val intent = Intent(this,ProfileView::class.java)
            startActivity(intent)
        }
    }
}
