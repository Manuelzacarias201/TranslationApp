package com.manuelzacarias.api.features.translation.di

import com.manuelzacarias.api.features.translation.data.datasources.remote.TranslationRemoteDataSource
import com.manuelzacarias.api.features.translation.data.datasources.remote.TranslationRemoteDataSourceImpl
import com.manuelzacarias.api.features.translation.data.repository.TranslationRepositoryImpl
import com.manuelzacarias.api.features.translation.domain.repositories.TranslationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TranslationModule {

    @Binds
    @Singleton
    abstract fun bindTranslationRepository(
        translationRepositoryImpl: TranslationRepositoryImpl
    ): TranslationRepository

    @Binds
    @Singleton
    abstract fun bindTranslationRemoteDataSource(
        translationRemoteDataSourceImpl: TranslationRemoteDataSourceImpl
    ): TranslationRemoteDataSource
}
