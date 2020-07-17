package com.app.mvvmstarter.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tbl_image")
@Parcelize
data class Image(
    @PrimaryKey val id: Long,
    val imageUrl: String,
    val author: String
) : Parcelable