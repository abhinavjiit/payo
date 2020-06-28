package com.example.payo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "User_Detail")
class UserDetail {
    @NonNull
    @PrimaryKey
    var employeeCode: String? = null
    @Ignore
    var name: String? = null
    var phoneNumber: String? = null
    @Ignore
    var dob: String? = null
    var debited: String? = null
    var credited: String? = null
}