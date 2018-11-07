package com.lopes.albert.ondee.base

import com.lopes.albert.ondee.injection.component.DaggerPresenterInjector
import com.lopes.albert.ondee.injection.component.PresenterInjector
import com.lopes.albert.ondee.injection.module.ContextModule
import com.lopes.albert.ondee.injection.module.NetworkModule
import com.lopes.albert.ondee.ui.pesquisa.PesquisaPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V)  {


    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {

        inject()

    }

    open fun onViewCreated(){ }


    open fun onViewDestroyed(){ }

    private fun  inject(){
        when (this) {

            is PesquisaPresenter -> injector.inject(this)
        }


    }

}