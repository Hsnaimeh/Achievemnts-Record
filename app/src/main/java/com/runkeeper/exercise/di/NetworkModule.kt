package com.runkeeper.exercise.di

import com.runkeeper.exercise.BuildConfig
import com.runkeeper.exercise.data.datasource.main.RemoteMainDataSource
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideRetrofit(factory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(factory)
            .build()
    }

    @Provides
    @Reusable
    fun provideConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Reusable
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Wrapped.ADAPTER_FACTORY)
            .build()
    }

    @Provides
    @Singleton
    fun provideRemoteOrdersDataSource(retrofit: Retrofit): RemoteMainDataSource {
        return retrofit.create(RemoteMainDataSource::class.java)
    }
}
