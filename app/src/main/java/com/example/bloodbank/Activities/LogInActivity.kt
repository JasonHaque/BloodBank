package com.example.bloodbank.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bloodbank.R
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bindListeners()
    }
    fun bindListeners(){
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
        }
    }
    fun validateInputs():Boolean{
        if(login_mail.text.toString().isEmpty() || login_password.text.toString().isEmpty()){
            return true
        }
        return false
    }
}
