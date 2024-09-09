package com.example.aula11

class Validacao {

    companion object{
        private const val USER = "jean"
        private const val PASSWORD = "54321"

        fun validarLogin(usuario: String, senha: String):Boolean{

            if (usuario == USER && senha == PASSWORD){
                return true
            }
            return false
        }
    }
}