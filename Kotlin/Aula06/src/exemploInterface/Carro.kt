package exemploInterface

class Carro(var marcaModelo: String) :IAcoes {

    override fun mover() {
        println("O carro $marcaModelo está acelerando!")
    }
}