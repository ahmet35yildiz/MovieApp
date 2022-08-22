package com.example.movieapp.di

import com.example.movieapp.data.repo.MoviesDaoRepository
import com.example.movieapp.retrofit.ApiUtils
import com.example.movieapp.retrofit.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMoviesDaoRepository(mDao: MoviesDao): MoviesDaoRepository {
        return MoviesDaoRepository(mDao)
    }

    @Provides
    @Singleton
    fun provideMoviesDao(): MoviesDao {
        return ApiUtils.getMoviesDao()
    }
}