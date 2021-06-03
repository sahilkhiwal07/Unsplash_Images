package com.example.unsplashimages.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Subcategory(
    val pretty_slug: String,
    val slug: String
): Parcelable