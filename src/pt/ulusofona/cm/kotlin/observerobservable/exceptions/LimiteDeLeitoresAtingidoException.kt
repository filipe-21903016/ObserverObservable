package pt.ulusofona.cm.kotlin.observerobservable.exceptions

class LimiteDeLeitoresAtingidoException(val gerador: String,val maxLeitores:Int) :
    Exception("$gerador atingiu o número máximo de leitores: $maxLeitores") {
}