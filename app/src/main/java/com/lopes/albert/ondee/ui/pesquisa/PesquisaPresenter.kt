package com.lopes.albert.ondee.ui.pesquisa

import com.lopes.albert.ondee.base.BasePresenter
import com.lopes.albert.ondee.model.Endereco
import com.lopes.albert.ondee.network.EnderecoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PesquisaPresenter(pesquisaView: PesquisaView): BasePresenter<PesquisaView>(pesquisaView){

    @Inject
    lateinit var enderecoAPI: EnderecoAPI

    private  var subscription: Disposable? = null


    fun pesquisar(cep:String){

        subscription = enderecoAPI
                .pesquisar(cep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate {view.hideLoading()}
                .subscribe({endereco: Endereco? -> view.atualizaEndereco(endereco) }
                        ,{view.showErro("Erro desconhecido")})

    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription?.dispose()
    }
}