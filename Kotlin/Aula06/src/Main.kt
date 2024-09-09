import exemploHeranca.* // importa todas as classes do pacote
import exemploInterface.*

fun main() {

    exInterface()
}

fun heran(){

//Criando instâncias das classes
    var animal = Animal()
    var animal2 = Animal("Bolinho")
    var cachorro = Cachorro("Caramelo")
    var cachorro2 = Cachorro("Mimo", "Lhasa")
    var gato = Gato("Lisa")
    var gato2 = Gato("Pipoca", "Preto")

//Invocando método comer
    animal.comer()
    animal2.comer()
    cachorro.comer()
    cachorro2.comer()
    gato.comer()
    gato2.comer()
}

fun exInterface(){

    //Criando instâncias
    var pessoa = Pessoa("Fulano")
    var carro = Carro("Honda Civic")
    var cavalo = Cavalo("Epona")

    //Chama método "mover"
    pessoa.mover()
    carro.mover()
    cavalo.mover()
}