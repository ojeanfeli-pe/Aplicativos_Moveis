package com.example.aula10.model

class Contato (
    var nome: String,
    var fone: String,
    var email: String
) {

    init {
        if(nome.isEmpty()){
            nome = "Desconhecido"
        }
        if(fone.isEmpty()){
            fone = "Não Informado"
        }
        if(email.isEmpty()){
            email = "Não informado"
        }
    }
    override fun toString(): String {
        return "Nome: $nome" +
                "\nFone: $fone" +
                "\nE-mail: $email"
    }
}