package com.example.lottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.content.res.ColorStateList
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    private val random= Random() //랜덤값을 사용할 수 있도록 선언
    private val numbers=arrayListOf<Int>() //로또 번호 저장할 배열 선언
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1=findViewById<Button>(R.id.lottoNum1)
        val num2=findViewById<Button>(R.id.lottoNum2)
        val num3=findViewById<Button>(R.id.lottoNum3)
        val num4=findViewById<Button>(R.id.lottoNum4)
        val num5=findViewById<Button>(R.id.lottoNum5)
        val num6=findViewById<Button>(R.id.lottoNum6)

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            setLottoNum(num1) //로또번호 생성하는 함수 호출
            setLottoNum(num2)
            setLottoNum(num3)
            setLottoNum(num4)
            setLottoNum(num5)
            setLottoNum(num6)

        }
    }
    private fun setLottoNum(lottoNum: Button){
        var num=0
        while (true){
            //1~45까지의 랜덤 숫자 생성
            num=random.nextInt(45)+1
            //array안에 숫자가 있는지 여부 체크
            //중복되지 않을 때까지 반복
            if (!numbers.contains(num)){
                numbers.add(num)
                break
            }
        }
        //정수를 텍스트화
        lottoNum.text="${num}"

        //숫자에 따른 배경색 변경
        if (num<=10){ //노란색
            lottoNum.backgroundTintList=ColorStateList.valueOf(Color.rgb(248,223,129))
        }
        else if (10<num&&num<=20){ //파란색
            lottoNum.backgroundTintList=ColorStateList.valueOf(Color.rgb(186,223,218))
        }
        else if (20<num&&num<=30){ //빨간색
            lottoNum.backgroundTintList=ColorStateList.valueOf(Color.rgb(246,170,144))
        }
        else if (30<num&&num<=40){ //회색
            lottoNum.backgroundTintList=ColorStateList.valueOf(Color.rgb(107,107,107))
        }
        else { //초록색
            lottoNum.backgroundTintList=ColorStateList.valueOf(Color.rgb(155,208,183))
        }


    }
}