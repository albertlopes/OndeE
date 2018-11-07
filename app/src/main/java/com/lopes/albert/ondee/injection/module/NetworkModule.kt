package com.lopes.albert.ondee.injection.module

import com.lopes.albert.ondee.network.EnderecoAPI
import com.lopes.albert.ondee.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {


    @Provides
    @JvmStatic
    @Reusable
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @Provides
    @JvmStatic
    @Reusable
    fun provideEnderecoAPI(retrofit: Retrofit): EnderecoAPI {

        return retrofit.create(EnderecoAPI::class.java)

    }

}