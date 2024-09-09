package exemploInterface

class Cavalo(var nome: String) : IAcoes {

    override fun mover() {
        println("O Cavalo $nome está galopando!")
    }
}