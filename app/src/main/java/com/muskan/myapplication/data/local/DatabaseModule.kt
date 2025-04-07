package com.muskan.myapplication.data.local

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule{

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CountryDataBase {
        return Room.databaseBuilder(
            context,
            CountryDataBase::class.java,
            "country_db"
        ).build()
    }

    @Binds
    fun provideDatabaseHelper(db: CountryDataBase):DatabaseHelper{
        return db.countryDao()
    }
}