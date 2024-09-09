package exemploHeranca

class Cachorro(nome: String, var raca: String) : Animal(nome){

    constructor(nome:String) : this(nome, "SRD")

    override fun comer() {

        println("O Cachorro $nome ($raca) está comendo ração!")

    }
}