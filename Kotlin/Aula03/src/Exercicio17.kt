class Exercicio17 {

    companion object{
        var idAtual = 1

        fun gerarID() : Int{
            return idAtual++
        }

    }
}