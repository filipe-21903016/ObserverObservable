package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class Bufo(nome: String = "bufo") : Leitor(nome), OnNumeroListener, OnNoticiaListener {
    private val nums: MutableList<Int> = mutableListOf()
    val noticias: MutableList<Noticia> = mutableListOf()

    override fun onReceiveNoticia(noticia: Noticia) {
        noticias.add(noticia)
    }

    override fun onReceiveNumero(num: Int) {
        nums.add(num)
    }

    fun imprimeNumeros(): String {
        val numsStr: StringBuilder = StringBuilder()
        nums.forEach { numsStr.append(it) }
        return "$nome escutou os seguintes numeros: $nums"
    }

    fun imprimeNoticias(): String {
        val noticiasStr: StringBuilder = StringBuilder()
        noticias.forEach { noticiasStr.append("${it.titulo},") }
        return "$nome leu as seguintes noticias: $nums"
    }

}