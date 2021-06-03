package com.example.unsplashimages.Model

data class Images(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)