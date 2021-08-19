package com.rodrigo.financ.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rodrigo.financ.utils.constants.Constants
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = Constants.TaskConst.TABLE_NAME)
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tittle: String,
    val description: String,
    val value: String,
    val hour: String,
    val date: String
    ):Parcelable