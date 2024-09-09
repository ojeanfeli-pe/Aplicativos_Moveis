class Jogo (
    var titulo: String,
    var ano: Int,
    var genero: String,
    var metaScore: Float,
    var plataformas: String
    ) {
    constructor(): this(
         "",
        0,
        "",
        0f,
        "")

    override fun toString(): String {
        return "Jogo(titulo='$titulo', ano=$ano, genero='$genero', metaScore=$metaScore, plataformas='$plataformas')"
    }

}