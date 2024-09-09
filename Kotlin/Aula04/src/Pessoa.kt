class Pessoa(var nome: String, var idade: Int) {

    //receber apenas nome, setando a idade como 0
    constructor(nome: String): this (nome, 0)

    // receber apenas a idade, setando o nome como "desconhecido"
    constructor(idade: Int): this ("Desconhecido", idade)

    //não recebe nenhum parâmetro
    constructor(): this ("", 0)

    fun apresentar(){
        println("Meu nome é $nome e tenho $idade anos")
    }
}