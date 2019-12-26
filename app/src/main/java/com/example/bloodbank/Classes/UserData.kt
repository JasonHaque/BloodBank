package com.example.bloodbank.Classes

import java.io.Serializable

data class UserData(
    val FirstName:String="",
    val LastName:String="",
    val age:Int,
    val contact:String="",
    val bloodGroup:String=""
):Serializable