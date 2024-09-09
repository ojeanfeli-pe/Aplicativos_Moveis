package exemploHeranca

open class Animal (var nome: String){

    constructor(): this("Desconhecido")

    open fun comer(){
        println("O animal $nome esta comendo")
    }
}