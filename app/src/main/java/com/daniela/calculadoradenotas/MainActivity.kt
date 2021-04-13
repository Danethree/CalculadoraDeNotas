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
            var num1 = binding.nota1
            var num2 = binding.nota2
            var num3 = binding.nota3
            var num4 = binding.nota4
            var faltas = binding.faltas
            var resultados = binding.resultado
            var nota1 = Integer.parseInt(num1.text.toString())
            var nota2 = Integer.parseInt(num2.text.toString())
            var nota3 = Integer.parseInt(num3.text.toString())
            var nota4 = Integer.parseInt(num4.text.toString())
            var numeroFaltas = Integer.parseInt(faltas.text.toString())
            CalculoDeNotas(nota1,nota2,nota3,nota4,numeroFaltas,resultados)
        }
    }

    fun CalculoDeNotas(n1:Int,n2:Int,n3:Int,n4:Int,faltas:Int, resultado: TextView)
    {
        val media = (n1 + n2 + n3 + n4)/4
        if(media>=5 && faltas<=20)
        {
            resultado.setText("Aluno foi aprovado. \n Média Final $media")
            resultado.setTextColor(getColor(R.color.green))
        }
        else if(faltas > 20)
        {
            resultado.setText("Aluno foi reprovado por faltas. \n Média Final $media")
            resultado.setTextColor(getColor(R.color.red))
        }
        else if(media<5)
        {
            resultado.setText("Aluno foi reprovado por nota. \n Média Final $media")
            resultado.setTextColor(getColor(R.color.red))
        }

    }



}