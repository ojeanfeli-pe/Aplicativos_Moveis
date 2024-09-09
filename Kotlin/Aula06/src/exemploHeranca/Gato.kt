package exemploHeranca

class Gato (nome: String, var cor: String) : Animal(nome){

    constructor(nome: String) : this (nome, "Cinza")

    override fun comer() {
        println("O gato $cor $nome está comendo sachê!")
    }
}