package com.lopes.albert.ondee.network

import com.lopes.albert.ondee.model.Endereco
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface  EnderecoAPI {

    @GET(value="/ws/{cep}/json")
    fun pesquisar(@Path(value = "cep")cep: String): Observable<Endereco>


}