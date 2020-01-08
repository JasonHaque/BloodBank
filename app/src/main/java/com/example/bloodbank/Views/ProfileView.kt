package com.example.bloodbank.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bloodbank.Activities.LogInActivity
import com.example.bloodbank.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_profile_view.*

class ProfileView : AppCompatActivity() {

    private var db = FirebaseDatabase.getInstance().getReference()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)
        bindWidgets()
        bindListeners()
    }

    private fun bindWidgets(){
        db.child("Users").child(FirebaseAuth.getInstance().currentUser?.uid.toString())
            .child("Data").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    println("Error receiving data")
                }

                override fun onDataChange(p0: DataSnapshot) {

                    val children = p0!!.children
                    var name =""
                    children.forEach{

                        if(it.key.equals("firstName")){
                            name =it.value.toString()
                        }
                        else if(it.key.equals("lastName")){
                            name+=it.value.toString()
                        }
                        else if(it.key.equals("age")){
                            user_age.text="Age : "+it.value.toString()
                        }
                        else if(it.key.equals("contact")){
                            user_contact.text="Contact : "+it.value.toString()

                        }
                        else if (it.key.equals("sex")){
                            user_sex_view.text ="Sex : "+ it.value.toString()
                        }
                        else if(it.key.equals("bloodGroup")){
                            user_blood_group.text="Blood Group : "+it.value.toString()

                        }
                    }
                    user_name.text="User Name : "+name
                    user_mail.text="User Email : "+FirebaseAuth.getInstance().currentUser?.email

                }

            })
    }

    private fun bindListeners(){
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
