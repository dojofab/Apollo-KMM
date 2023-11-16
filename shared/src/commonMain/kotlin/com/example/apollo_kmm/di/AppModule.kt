package com.example.apollo_kmm.di

import com.example.apollo_kmm.data.local.LocalDataSource
import com.example.apollo_kmm.data.local.LocalDataSourceImpl
import com.example.apollo_kmm.data.network.NetworkDataSource
import com.example.apollo_kmm.data.network.NetworkDataSourceImpl
import com.example.apollo_kmm.data.network.api.ApolloClient
import com.example.apollo_kmm.repository.CountryRepository
import com.example.apollo_kmm.repository.CountryRepositoryImpl
import org.koin.dsl.module

fun appModule() = module {
    single { ApolloClient() }
    single<LocalDataSource> { LocalDataSourceImpl() }
    single<NetworkDataSource> { NetworkDataSourceImpl(get()) }
    single<CountryRepository> { CountryRepositoryImpl(get(), get ()) }
}


