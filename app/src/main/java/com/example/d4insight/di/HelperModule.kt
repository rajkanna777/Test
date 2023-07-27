package com.example.d4insight.di

import android.content.Context
import com.example.d4insight.util.Helper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HelperModule {
    @Provides
    fun provideHelper(@ApplicationContext context: Context): Helper {
        return Helper(context)
    }
}
