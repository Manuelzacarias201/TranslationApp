package com.manuelzacarias.api.di

import com.manuelzacarias.api.features.translation.data.repositories.TranslationRepositoryImpl
import com.manuelzacarias.api.features.translation.domain.repositories.TranslationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTranslationRepository(
        impl: TranslationRepositoryImpl
    ): TranslationRepository
}
