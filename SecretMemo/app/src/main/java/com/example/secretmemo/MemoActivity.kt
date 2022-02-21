package com.example.secretmemo

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)

        val shareButton=findViewById<FloatingActionButton>(R.id.shareButton)
        val memo=findViewById<EditText>(R.id.editText)

        shareButton.setOnClickListener{
            val sendIntent=Intent().apply{
                action= Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,memo.text.toString())
                type="text/plain"
            }

            val shareIntent=Intent.createChooser(sendIntent,null)
            startActivity(shareIntent)
        }
    }
}