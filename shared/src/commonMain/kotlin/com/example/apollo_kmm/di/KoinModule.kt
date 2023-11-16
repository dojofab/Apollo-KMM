package com.example.apollo_kmm.di

import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(appModule())
}