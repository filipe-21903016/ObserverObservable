package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener
import kotlin.math.max

class CorreioDaLusofona(
    val maxLeitores : Int,
    val noticias: MutableList<Noticia> = mutableListOf()
) {
    private val leitores : MutableList<OnNoticiaListener> = mutableListOf()

    fun adicionarLeitor(leitor : OnNoticiaListener){
        if (leitores.size == maxLeitores) throw LimiteDeLeitoresAtingidoException("CorreioDaLusofona", maxLeitores)
        leitores.add(leitor)
        leitor.leitorAdicionadoComSucesso()
    }

    fun removerLeitor(leitor: OnNoticiaListener){
        leitores.forEach {
            if (leitor == it){
                leitores.remove(it)
                leitor.leitorRemovidoComSucesso()
            }
        }
        throw LeitorInexistenteException()
    }

    private fun notificarLeitores(){
        leitores.forEach { leitor ->
            noticias.forEach { noticia ->  leitor.onReceiveNoticia(noticia) }
        }
    }

    fun iniciar() = notificarLeitores()
}