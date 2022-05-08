package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(
    val maxLeitores: Int,
    private val numeros: List<Int> = listOf()
) {
    private val leitores: MutableList<OnNumeroListener> = mutableListOf()

    fun adicionarLeitor(leitor: OnNumeroListener) {
        if (leitores.size == maxLeitores) throw LimiteDeLeitoresAtingidoException("GeradorNumerico", maxLeitores)
        leitores.add(leitor)
        leitor.leitorAdicionadoComSucesso()
    }

    fun removerLeitor(leitor: OnNumeroListener) {
        leitores.forEach {
            if (leitor == it){
                leitores.remove(it)
                it.leitorRemovidoComSucesso()
                return
            }
        }
        throw LeitorInexistenteException()
    }
    private fun notificarLeitores() {
        leitores.forEach { leitor ->
            numeros.forEach { num -> leitor.onReceiveNumero(num) }
        }
    }
    fun iniciar() = notificarLeitores()
}