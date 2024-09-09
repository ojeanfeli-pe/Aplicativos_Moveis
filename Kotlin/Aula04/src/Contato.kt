class Contato(var nome: String, var telefone: String) {

    fun ligar(){
        println("Ligando para $nome : $telefone")
    }
}