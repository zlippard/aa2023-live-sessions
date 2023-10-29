package com.kodeco.android.aa2023.di

import com.kodeco.android.aa2023.repositories.SchoolRepository
import com.kodeco.android.aa2023.repositories.SchoolRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SingletonModule {
    @Binds
    @Singleton
    abstract fun bindSchoolRepository(
        impl: SchoolRepositoryImpl,
    ): SchoolRepository
}

//@Module
//@InstallIn(SingletonComponent::class)
//class SingletonModule {
//    @Provides
//    @Singleton
//    fun provideSchoolRepository(): SchoolRepository = SchoolRepositoryImpl()
//}
