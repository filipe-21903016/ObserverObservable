package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class CorreioDaLusofona(
    val maxLeitores : Int,
    private val noticias: List<Noticia>
) {
    private val noticiaListeners : List<OnNoticiaListener> = listOf()

    fun adicionarLeitor(leitor : OnNoticiaListener){}
    fun removerLeitor(leitor: OnNoticiaListener){}
    private fun notificarLeitores(){}
    fun iniciar(){}
}