package com.example.unsplashimages.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileImageX(
    val large: String,
    val medium: String,
    val small: String
): Parcelable