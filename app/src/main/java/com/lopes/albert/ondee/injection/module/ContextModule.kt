package com.lopes.albert.ondee.injection.module

import android.app.Application
import android.content.Context
import com.lopes.albert.ondee.base.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule{

    @Provides
    @JvmStatic
    fun provideContext(baseView: BaseView): Context{
        return baseView.getContext()
    }

    @Provides
    @JvmStatic
    fun provideApplication(context: Context): Application{
        return context.applicationContext as Application
    }

}