package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener
import kotlin.math.max

class CorreioDaLusofona(
    val maxLeitores : Int,
    private val noticias: MutableList<Noticia> = mutableListOf()
) {
    private val noticiaListeners : MutableList<OnNoticiaListener> = mutableListOf()

    fun adicionarLeitor(leitor : OnNoticiaListener){
        if (noticiaListeners.size == maxLeitores) throw LimiteDeLeitoresAtingidoException("CorreioDaLusofona", maxLeitores)
        noticiaListeners.add(leitor)
        leitor.leitorAdicionadoComSucesso()
    }

    fun removerLeitor(leitor: OnNoticiaListener){
        noticiaListeners.forEach {
            if (leitor == it){
                noticiaListeners.remove(it)
                leitor.leitorRemovidoComSucesso()
            }
        }
        throw LeitorInexistenteException()
    }

    private fun notificarLeitores(){
        noticiaListeners.forEach { leitor ->
            noticias.forEach { noticia ->  leitor.onReceiveNoticia(noticia) }
        }
    }

    fun iniciar() = notificarLeitores()
}