package com.lopes.albert.ondee.injection.component

import com.lopes.albert.ondee.base.BaseView
import com.lopes.albert.ondee.injection.module.ContextModule
import com.lopes.albert.ondee.injection.module.NetworkModule
import com.lopes.albert.ondee.ui.pesquisa.PesquisaPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(pesquisaPresenter: PesquisaPresenter)

    @Component.Builder
    interface Builder {

        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}
