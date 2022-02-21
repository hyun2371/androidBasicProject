package com.example.secretmemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editEmail=findViewById<EditText>(R.id.editTextEmail)
        val editText=findViewById<EditText>(R.id.editTextNumberPW)

        val intent= Intent(this,MemoActivity::class.java)
        findViewById<Button>(R.id.button2).setOnClickListener{

            val emailText=editEmail.text.toString()
            val pwText=editText.text.toString()


            if (emailText=="hyun27@gmail.com"){
                if (pwText=="13579"){
                    startActivity(intent)
                    this.finish()
                }
                else{
                    findViewById<TextView>(R.id.textView1).text="비밀번호가 틀렸습니다. 다시 입력해주세요."
                }
            }
            else{
                findViewById<TextView>(R.id.textView1).text="이메일이 틀렸습니다. 다시 입력해주세요."
            }
        }
    }


}