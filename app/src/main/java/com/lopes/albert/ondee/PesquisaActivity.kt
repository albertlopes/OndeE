package com.lopes.albert.ondee

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lopes.albert.ondee.base.BaseActivity
import com.lopes.albert.ondee.model.Endereco
import com.lopes.albert.ondee.ui.pesquisa.PesquisaPresenter
import com.lopes.albert.ondee.ui.pesquisa.PesquisaView

class PesquisaActivity : BaseActivity<PesquisaPresenter>(), PesquisaView {

    override fun showErro(erro: String) {
        Toast.makeText(this,erro,Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        Toast.makeText(this,"carregando",Toast.LENGTH_LONG).show()
    }

    override fun hideLoading() {
        Toast.makeText(this,"esconde",Toast.LENGTH_LONG).show()
    }

    override fun atualizaEndereco(endereco: Endereco?) {
    Toast.makeText(this,endereco?.logradouro,Toast.LENGTH_LONG).show()
    }

    override fun instantPresenter(): PesquisaPresenter {
        return PesquisaPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
        presenter.pesquisar("04163010")

    }

}
