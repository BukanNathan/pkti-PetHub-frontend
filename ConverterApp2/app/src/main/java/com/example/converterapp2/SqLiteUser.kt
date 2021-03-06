package com.example.converterapp2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SqLiteUser(
    var id: Int = 0,
    var nama: String = "",
    var email: String = "") : Parcelable {
}