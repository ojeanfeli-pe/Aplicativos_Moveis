package exemploInterface

class Pessoa(var nome: String) : IAcoes{

    override fun mover() {
        println("A pessoa $nome está caminhando")
    }
}