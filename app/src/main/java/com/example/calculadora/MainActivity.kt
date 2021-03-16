package com.example.calculadora

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Função click de numeros
        Numero_Zero.setOnClickListener{Expressao(numero="0", limpar_dados=true)}
        Numero_Um.setOnClickListener{Expressao(numero="1", limpar_dados=true)}
        Numero_Dois.setOnClickListener{Expressao(numero="2", limpar_dados=true)}
        Numero_Tres.setOnClickListener{Expressao(numero="3", limpar_dados=true)}
        Numero_Quatro.setOnClickListener{Expressao(numero="4", limpar_dados=true)}
        Numero_Cinco.setOnClickListener{Expressao(numero="5", limpar_dados=true)}
        Numero_Seis.setOnClickListener{Expressao(numero="6", limpar_dados=true)}
        Numero_Sete.setOnClickListener{Expressao(numero="7", limpar_dados=true)}
        Numero_Oito.setOnClickListener{Expressao(numero="8", limpar_dados=true)}
        Numero_Nove.setOnClickListener{Expressao(numero="9", limpar_dados=true)}
        Numero_Ponto.setOnClickListener{Expressao(numero=".", limpar_dados=true)}

        // Operadores

        Soma.setOnClickListener{Expressao(numero = "+", limpar_dados = false)}
        Subtracao.setOnClickListener{Expressao(numero = "-", limpar_dados = false)}
        Multiplicacao.setOnClickListener{Expressao(numero = "*", limpar_dados = false)}
        Divisao.setOnClickListener{Expressao(numero = "/", limpar_dados = false)}

        // Fução limpar
        Limpar.setOnClickListener{
            expressao.text=""
            resultado.text=""
        }
        // Função igualdade
        Igual.setOnClickListener{
            expressao.text=""
            resultado.text=""
        }
        // Função apagar
        Numero_Apagar.setOnClickListener{
            val string = expressao.text.toString()
            if(string.isNotBlank()){
                expressao.text= string.substring(0,string.length-1)

            }

            resultado.text=""
        }

        Igual.setOnClickListener{
            try{
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val equacao = expressao.evaluate()
                val longResult = equacao.toLong()
                if(equacao == longResult.toDouble()){
                    resultado.text= longResult.toString()
                }
                else
                    resultado.text=resultado.toString()
            }catch (e: Exception){

            }
        }

    }

    // passando paramentros da primeiro text view
    fun Expressao(numero: String ,limpar_dados:Boolean ){
        if(resultado.text.isNotEmpty()){
            expressao.text=""
        }
        if(limpar_dados){
            resultado.text=""
            expressao.append(numero)
        }else{
            expressao.append(resultado.text)
            expressao.append(numero)
            resultado.text=""
        }

    }

}