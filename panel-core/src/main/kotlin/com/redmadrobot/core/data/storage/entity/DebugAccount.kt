package com.redmadrobot.core.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DebugAccount.TABLE_NAME)
data class DebugAccount(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "pinNeeded")
    val pinNeeded: Boolean = false
) {
    companion object {
        const val TABLE_NAME = "debug_account"
    }
}
