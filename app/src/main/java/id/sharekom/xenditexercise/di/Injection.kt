package id.sharekom.xenditexercise.di

import android.content.Context
import id.sharekom.xenditexercise.repository.DataRepository
import id.sharekom.xenditexercise.repository.RemoteDataSource
import id.sharekom.xenditexercise.utils.JsonParser

object Injection {
    fun provideRepository(context: Context): DataRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonParser(context))

        return DataRepository.getInstance(remoteDataSource)
    }
}