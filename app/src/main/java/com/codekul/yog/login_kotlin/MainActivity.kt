package com.codekul.yog.login_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var temp = ptnum.text
            var num= Integer.parseInt(temp.toString())
            showWord.text = numToWords(num)

        }
    }

/*
Program to convert number to Characters
for ex. if input 1023 output one thousand twenty three
 */


    object NumberToWordsConverter {
        val units = arrayOf<String>("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
        val tens = arrayOf<String>("", // 0
                "", // 1
                "Twenty", // 2
                "Thirty", // 3
                "Forty", // 4
                "Fifty", // 5
                "Sixty", // 6
                "Seventy", // 7
                "Eighty", // 8
                "Ninety" // 9
        )
        fun convert(n:Int):String {
            if (n < 0)
            {
                return "Minus " + convert(-n)
            }
            if (n < 20)
            {
                return units[n]
            }
            if (n < 100)
            {
                return tens[n / 10] + (if ((n % 10 != 0)) " " else "") + units[n % 10]
            }
            if (n < 1000)
            {
                return units[n / 100] + " Hundred" + (if ((n % 100 != 0)) " " else "") + convert(n % 100)
            }
            if (n < 100000)
            {
                return convert(n / 1000) + " Thousand" + (if ((n % 10000 != 0)) " " else "") + convert(n % 1000)
            }
            if (n < 10000000)
            {
                return convert(n / 100000) + " Lakh" + (if ((n % 100000 != 0)) " " else "") + convert(n % 100000)
            }
            return convert(n / 10000000) + " Crore" + (if ((n % 10000000 != 0)) " " else "") + convert(n % 10000000)
        }
    }

    private fun numToWords(n:Int):String { //optional
        val ntw = NumberToWordsConverter // directly implement this
        return ntw.convert(n)
    }

    }
