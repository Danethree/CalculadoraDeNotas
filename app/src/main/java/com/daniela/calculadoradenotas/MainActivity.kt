package com.daniela.calculadoradenotas

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.daniela.calculadoradenotas.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        binding.btCalcular.setOnClickListener()
        {
            ValidateCamps()
        }
    }

    fun CalculoDeNotas(num1:EditText,num2:EditText,num3:EditText,num4:EditText,faltas:EditText)
    {
        var nota1 = Integer.parseInt(num1.text.toString())
        var nota2 = Integer.parseInt(num2.text.toString())
        var nota3 = Integer.parseInt(num3.text.toString())
        var nota4 = Integer.parseInt(num4.text.toString())
        var numeroFaltas = Integer.parseInt(faltas.text.toString())
        var resultados = binding.resultado

        val media = (nota1 + nota2 + nota3 + nota4)/4
        if(media>=5 && numeroFaltas <=20)
        {
            resultados.setText("Aluno foi aprovado. \n Média Final $media")
            resultados.setTextColor(getColor(R.color.green))
        }
        else if(numeroFaltas > 20)
        {
            resultados.setText("Aluno foi reprovado por faltas. \n Média Final $media")
            resultados.setTextColor(getColor(R.color.red))
        }
        else if(media<5)
        {
            resultados.setText("Aluno foi reprovado por nota. \n Média Final $media")
            resultados.setTextColor(getColor(R.color.red))
        }

    }

    fun ValidateCamps()
    {
        var num1 = binding.nota1
        var num2 = binding.nota2
        var num3 = binding.nota3
        var num4 = binding.nota4
        var faltas = binding.faltas



        if(num1.text.toString().isEmpty())
        {

            num1.setError("Preencha a nota 1")
            num1.requestFocus()
        }
        else if(num2.text.toString().isEmpty())
        {

            num2.setError("Preencha a nota 2")
            num2.requestFocus()
        }
        else if(num3.text.toString().isEmpty())
        {

            num3.setError("Preencha a nota 3")
            num3.requestFocus()
        }
        else if(num4.text.toString().isEmpty())
        {

            num4.setError("Preencha a nota 4")
            num4.requestFocus()
        }
        else if(faltas.text.toString().isEmpty())
        {

            faltas.setError("Preencha o número de faltas")
            faltas.requestFocus()
        }
        else
        {
            CalculoDeNotas(num1,num2,num3,num4,faltas);
        }



    }



}