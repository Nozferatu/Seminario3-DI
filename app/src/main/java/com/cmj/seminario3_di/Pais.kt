package com.cmj.seminario3_di

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pais(
    val nombre: String,
    val habitantes: Int,
    val bandera: Int
): Parcelable
