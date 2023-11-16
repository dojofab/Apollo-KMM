package com.example.apollo_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
