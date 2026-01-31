package com.manuelzacarias.api.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    // Empty to avoid duplicate bindings with TranslationModule
}
