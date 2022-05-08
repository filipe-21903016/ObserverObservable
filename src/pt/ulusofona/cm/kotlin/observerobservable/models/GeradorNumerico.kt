package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(
    val maxLeitores: Int,
    private val nums: ArrayList<Int> = ArrayList()
) {
    private val numListeners: ArrayList<OnNumeroListener> = ArrayList()

    fun adicionarLeitor(leitor: OnNumeroListener) {
        if (numListeners.size == maxLeitores) throw LimiteDeLeitoresAtingidoException("GeradorNumerico", maxLeitores)
        numListeners.add(leitor)
        leitor.leitorAdicionadoComSucesso()
    }

    fun removerLeitor(leitor: OnNumeroListener) {
        numListeners.forEach {
            if (leitor == it){
                numListeners.remove(it)
                leitor.leitorRemovidoComSucesso()
            }
        }
        throw LeitorInexistenteException()
    }
    private fun notificarLeitores() {
        numListeners.forEach { leitor ->
            nums.forEach { num ->  leitor.onReceiveNumero(num) }
        }
    }
    fun iniciar() = notificarLeitores()
}