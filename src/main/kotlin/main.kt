import java.util.Scanner
import kotlin.math.pow

fun main() {
    val input = Scanner(System.`in`)

    println("CALCULADORA DE CONSOLE")
    println("Formato: 1°Número TipoOperação 2°Número \n")

    println("Digite o 1° número:")
    val a : String = input.next()

    println("Digite o 2° número:")
    val b : String = input.next()

    println("Digite a operação desejada entre as opções:")
    enumValues<Operacao>().forEach { println("${it.ordinal} - ${it.name}") }
    val o = input.nextInt()

    val aFloat :Float? = a.toFloatOrNull()
    val bFloat :Float? = b.toFloatOrNull()

    if(aFloat == null || bFloat ==null){
        println("! Atenção - preencha todos os 2 números !")
    }
    else{
        println("${Operacao.values()[o.toInt()].calcularOperacao(aFloat,bFloat) }")
    }
}

 interface IOperacao {
 fun calcularOperacao(a:Float,b:Float): Float
 }

enum class Operacao: IOperacao{
    ADICAO{
        override fun calcularOperacao(a:Float,b:Float) :Float = a+b
    },
    SUBTRACAO{
        override fun calcularOperacao(a: Float,b: Float) :Float = a-b
             },
    MULTIPLICACAO{
        override fun calcularOperacao(a: Float,b: Float) :Float = a*b
    },
    DIVISAO{
        override fun calcularOperacao(a: Float,b: Float) :Float = a/b
           },
    EXPONENCIAL{
        override fun calcularOperacao(a: Float,b: Float):Float  = a.pow(b)
    },
    RESTO {
        override fun calcularOperacao(a: Float,b: Float) :Float = a%b
    };
}