package com.example.unsplashimages.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ancestry(
    val category: Category,
    val subcategory: Subcategory,
    val type: Type
): Parcelable