import java.util.Scanner
import kotlin.math.pow

fun main() {
    val input = Scanner(System.`in`)
    val close :String = "SAIR"

    var executando: Boolean = true

    println("CALCULADORA DE CONSOLE")
    println("Formato: 1°Número TipoOperação 2°Número \n")

    while (executando){
    println("Digite o 1° número:")
    val a : String = input.next()

    println("Digite o 2° número:")
    val b : String = input.next()

    println("Digite a operação desejada entre as opções:")
    enumValues<Operacao>().forEach { println("${it.ordinal} - ${it.name}") }
    val o = input.next()


        if(a.toUpperCase().equals(close)||b.toUpperCase().equals(close)||o.toUpperCase().equals(close)){
            executando=false
        }
    val aFloat :Float? = a.toFloatOrNull()
    val bFloat :Float? = b.toFloatOrNull()
    val oInt : Int? = o.toIntOrNull()

    if(aFloat == null || bFloat ==null){
        println("! Atenção ! - preencha todos os 2 números")
    }else if (oInt ==null){
        println("! Atenção ! - digite o número correspondente a operação desejada")
    }
    else{
        try{
        println("Realizando operação:  $aFloat ${Operacao.values()[oInt].name} $bFloat")
        println("Resultado: ${Operacao.values()[oInt].calcularOperacao(aFloat,bFloat) }")
        }
        catch (exception: NumberFormatException) {
            println("Ocorreu o erro: ${exception.message} ao formatar o número")
        } catch (exception: ArithmeticException) {
            println("Ocorreu o erro: ${exception.message} ao realizar a operação com os números")
        } catch (exception: Exception) {
            println("Ocorreu o erro: ${exception.message} ao executar a aplicação")
    }
    }
    println("Para terminar, digite SAIR")
    }
}

interface IOperacao {
 fun calcularOperacao(a:Float,b:Float): Float
 }

enum class Operacao: IOperacao{
    ADICAO{
        override fun calcularOperacao(a:Float,b:Float) :Float = a.plus(b)
    },
    SUBTRACAO{
        override fun calcularOperacao(a: Float,b: Float) :Float = a.minus(b)
             },
    MULTIPLICACAO{
        override fun calcularOperacao(a: Float,b: Float) :Float = a.times(b)
    },
    DIVISAO{
        override fun calcularOperacao(a: Float,b: Float) :Float = a.div(b)
           },
    EXPONENCIAL{
        override fun calcularOperacao(a: Float,b: Float):Float  = a.pow(b)
    },
    RESTO {
        override fun calcularOperacao(a: Float,b: Float) :Float = a.rem(b)
    },
    RAIZ {
        override fun calcularOperacao(a: Float,b: Float) :Float = a.pow(1/b)
    };
}