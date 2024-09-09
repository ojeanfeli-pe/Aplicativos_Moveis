fun main() {
    //exemploFor1()
    //exemploFor2()
    //exemploFor3()
    //exemploExpressaoIf()
    //exemploWhen1()
    //exemploWhen2()
    //exercicio01()
    //exercicio02()
    //exercicio07()
    exercicio08()
}

fun exemploFor1(){
    for(i in 0..10){
        println("Valor atual do contador crescente: $i")

    }
}

fun exemploFor2(){
    println("Contagem Regressiva")

    for (i in 10 downTo 1){
        println(i)
    }
    println("Lançar!")
}

fun exemploFor3 (){
    println("Valores ímpares entre 1 e 15")
    for (i in 1..15 step 2)
        println(i)
}

fun exemploExpressaoIf(){
    var a = 5
    var b = 10

    var max = if (a > b) a else b

    //mesma coisa que:
    /*
     if (a > b) {
        max = a
     } else {
        max = b
     }
     */
    println("Valor de max: $max")
}

fun exemploWhen1 (){
    val x = 1

    when (x){
        1 -> println("X vale 1")
        2 -> println("X vale 2")
        else -> println("X não vale 1 e nem 2")
    }
    //similiar ao switch case
    /*
     switch(x){
        case 1:
        println ("X vale 1")
        break
        case 2:
        println ("X vale 2")
        break
        default:
        println ("X não vale 1 e nem 2")
        break
     }
     */

}

fun exemploWhen2 (){
    val x = 0

    when {
      x > 0 -> println("X é positivo")
      x < 0 -> println("X é negativo")
      else -> println("X é zero")
    }
}

fun exercicio01(){
    println("Exercício 01 - Média das Notas \n")

    println("Informe a nota da primeiria prova")
    var n1 = readln().toFloat()

    println("Informe a nota da segunda prova")
    var n2 = readln().toFloat()

    println("Informe a nota da terceira prova")
    var n3 = readln().toFloat()

    var media = (n1 + n2 + n3) /3

    var mediaFormatada = String.format("%.1f", media)

    if (media >= 7){
        println("Aprovado com média $mediaFormatada")
    }else {
        println("Reprovado com média $mediaFormatada")
    }
}

fun exercicio02(){
    println("Exercício 02 - PAR ou IMPAR \n")

    println("Informe um valor inteiro")
    var valor = readln().toInt()

    when{
        valor % 2 == 0 -> println("$valor é par!")
        valor % 2 != 0 -> println("$valor é impar!")
    }
}

fun exercicio07(){

    println("Exercício 07: Contar as vogais numa palavras")

    println("Digite uma palavra: ")
    var palavra = readln()

    var qtdVogais = 0 // zero vogais nesse momento
    var qtdConsoantes = 0

    for (letra in palavra){
        if(letra.lowercaseChar() in "aeiou"){
            qtdVogais++
        } else {
            qtdConsoantes++
        }
    }
        println("Existem $qtdVogais vogais e $qtdConsoantes consoantes na palavra $palavra")


}

fun exercicio08(){

    println("Exercício 08 - Verificar se um número é Primo")

    println("Informe um numero inteiro: ")
    var numero = readln().toInt()
    var primo = true

    for ( contador in 2.. numero/2){
        if (numero % contador == 0){
            primo = false
            break
        }
    }
   if (primo){
       println("O numero $numero é primo!")
   }else {
       println("O numero $numero não é primo!")

   }
}