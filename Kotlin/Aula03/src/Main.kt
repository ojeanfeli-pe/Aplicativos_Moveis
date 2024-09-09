fun main(){
    //exemploArray1()
    //exemploCompanionObject()
    //exercicio01()
    //exercicio02()
    //exercicio05()
    exercicio17()
}

fun exemploArray1(){

    var numeros = arrayOf(1,2,3,4,5)
    var nomes = arrayOf("Anabrulina", "Brunilza", "Cardisgrilda")

    println("Número na pos 0 do array de numeros: " + numeros[0])
    println("Nome na pos 0 do array de nomes: " + nomes[1])

    //mostrando dados do array utilizado for
    println("Valores do array numeros:")

    for(numeroAtual in numeros){
        print("$numeroAtual ")
    }

    //mostrando dados do array nomes utilizando foreach
    println("\nNomes do array nomes:")
    nomes.forEach { println(it) }
    nomes.forEach { nomeAtual -> print("$nomeAtual ") }// aqui você altera os dados
}

fun exemploFunSimples(){
    val media = calcularMedia(5f, 7.2f, 3.7f)
    val notaFormatada = String.format("%.1f", media)
    print("Média do aluno: $notaFormatada")
}

fun calcularMedia(n1: Float, n2: Float, n3: Float) : Float{
    val media = (n1+n2+n3)/3
    return media
}

fun exemploCompanionObject(){
    println("Exemplo de Soma")
    println("75 + 25 = ${Calculadora.somar(75,25)}")
    println("\nExemplo de Subtração")
    println("75 - 25 = ${Calculadora.subtrair(75,25)}")
    println("\nExemplo de Divisão")
    println("100 / 25 = ${Calculadora.dividir(100,25)}")
    println("\nExemplo de Multiplicação")
    println("100 * 25 = ${Calculadora.multiplicar(100,25)}")
}

fun exercicio01(){
    var idades = Array(5){0} // Todos os arrays inicializam em 0

    for(i in idades.indices){
        println("Informe uma ${i+1} idade: ")
        idades[i] = readln().toInt()

    }
    val media = idades.average() //calcula a media dos valores do array
    println("\nMédia das idades $media")
}

fun exercicio02(){

    var temperaturas = Array (7){ 0f }

    var min : Float = 0f
    var max : Float = 0f

    for(i in temperaturas.indices){
        println("Informe a temperatura do ${i+1}° dia:")
        temperaturas[i] = readln().toFloat()

     //Utilizaremos when para facilitar o código
        when {
            i == 0 -> {
                min = temperaturas[0]
                max = temperaturas[0]
            }
            temperaturas[i] > max -> max = temperaturas[i]
            temperaturas[i] < min -> min = temperaturas[i]

        }

    }
    //verifica valor minimo e máximo dentro de uma array
    min = temperaturas.min()
    max = temperaturas.max()

    println("Temperatura mínima: $min")
    println("Temperatura máxima: $max")
}

fun exercicio05(){

    var nomes = Array(5){""}

    for (i in nomes.indices){
        print("Digite o ${i+1}° nome: ")
        nomes[i] = readln()
    }
    nomes.sort()

    println("Nomes em ordem alfabetica: ")
    nomes.forEach { nomeAtual -> print("$nomeAtual ") }// aqui você altera os dados
}

fun exercicio17(){
    print("Id atual: ${Exercicio17.gerarID()}")
    print("\nId atual: ${Exercicio17.gerarID()}")
    print("\nId atual: ${Exercicio17.gerarID()}")
    print("\nId atual: ${Exercicio17.gerarID()}")
    print("\nId atual: ${Exercicio17.gerarID()}")
    print("\nId atual: ${Exercicio17.gerarID()}")

}