package com.example.aula10.model

class FolhaPagamento(
    var nome: String,
    var horasTrab : Float,
    var valorHora : Float,
    var salBruto : Float,
    var ir : Float,
    var inss : Float,
    var salLiquido : Float
){
    constructor(nome: String,horasTrab: Float,valorHora: Float) :
            this(nome,horasTrab,valorHora, 0f,0f,0f,0f){

        calcularSalBruto()
        calcularIR()
        calcularINSS()
        calcularSalLiquido()

    }

    fun calcularSalBruto(){
        salBruto = valorHora * horasTrab
    }
    fun calcularIR(){
        ir = salBruto * 0.08f
    }
    fun calcularINSS(){
        inss = salBruto * 0.09f
    }
    fun calcularSalLiquido(){
        salLiquido = salBruto - ir - inss
    }

    override fun toString(): String {
        return "FOLHA CALCULADA:" +
                "\nNome do Funcionário: $nome" +
                "\nHoras Trabalhadas: $horasTrab hrs" +
                "\nValor da Hora: R$ $valorHora" +
                "\nSalário Bruto: R$$salBruto" +
                "\nIR do mês: R$$ir" +
                "\nINSS do mês: R$$inss" +
                "\nSalário Líquido: R$$salLiquido"

    }

}