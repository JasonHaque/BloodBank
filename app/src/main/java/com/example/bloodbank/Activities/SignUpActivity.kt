package com.example.bloodbank.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bloodbank.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        bindWidgets()
    }
    fun bindWidgets(){
        go_to_login.setOnClickListener {
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
        signup.setOnClickListener {
            val mail = signup_mail.text.toString()
            val pass = signup_password.text.toString()
            val confirm = confirm_password.text.toString()
            val contact = phone_number.text.toString()
            if(mail.isEmpty() || pass.isEmpty() || confirm.isEmpty() || contact.isEmpty()){
                Toast.makeText(this,"Fill up the fields properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(pass != confirm){
                Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail,pass).addOnSuccessListener {
                val intent = Intent(this,AdditionalData::class.java)
                startActivity(intent)
            }
        }
    }


}
