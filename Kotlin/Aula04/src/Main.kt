fun main() {
    //CLASSE CARRO
    //println("\nExemplo 1 - Carro(Carro1)")
//    var carro1 = Carro()
//    carro1.marca = "Ford"
//    carro1.modelo = "Ranger"
//
//    carro1.acelerar()

    //CLASSE CONTATO
    //println("\nExemplo 2 - Contato(contato)")
//    var contato1 = Contato("Jean", "(41)98547-1124")
//
//    contato1.ligar()

    //CLASSE PESSOA
    //4 instancias de Pessoa:
    //println("\nExemplo 3 - Pessoa(p1 a p4)")
//    var p1 = Pessoa("Jean", 20) //construtor primario
//    var p2 = Pessoa("Maria")//construtor que recebe apenas o nome
//    var p3 = Pessoa(29)////construtor que recebe apenas a idade
//    var p4 = Pessoa()//construtor que não recebe parâmetros

//    p1.apresentar()
//    p2.apresentar()
//    p3.apresentar()
//    p4.apresentar()

    //CLASSE JOGO
    println("\nExemplo 4 - Jogo(jogo1 e jogo2)")
    var jogo1 = Jogo(
        "God of War",
        2018,
        "Ação/Aventura",
        9.9f,
        "PS3, PS4, PS5, PC")

    var jogo2 = Jogo()

    println(jogo1.toString())
    println(jogo2.toString())
}

fun revisaoArrays(){
    var numeros = arrayOf(2,4,6,8,10)

    var nomes = arrayOf("João", "Maria", "José")

    var idades = Array(5){0}

    for (i in idades.indices){
        idades[i] = i + 10
        println(idades[i])
    }
    println(idades.joinToString()) //aqui ele pega o valor de cada string e separa por vírgula

    var valores = mutableListOf<Int>() // array dinamico //ou então array list

    valores.add(10)
    valores.add(20)
    valores.add(70)
    println("\nInforme um valor inteiro: ")
    val n = readln().toInt()
    valores.add(n)

    println("Valores do arrayList: ")
    println(valores.joinToString() )
}
