package com.lopes.albert.ondee.ui.pesquisa

import com.lopes.albert.ondee.base.BaseView
import com.lopes.albert.ondee.model.Endereco

interface PesquisaView : BaseView{

    fun atualizaEndereco(endereco: Endereco?)

    fun showErro(erro: String)

    fun showLoading()

    fun hideLoading()

}